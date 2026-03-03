import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { forkJoin } from 'rxjs';
import { FactureService } from '../../core/services/facture.service';
import { DefuntService } from '../../core/services/defunt.service';
import { PaiementService } from '../../core/services/paiement.service';
import { KpiCard, PaymentDistribution, Dossier } from '../../core/models/dashboard.model';
import { Facture } from '../../core/models/facture.model';

@Component({
  selector: 'app-admin-dashboard',
  imports: [CommonModule],
  templateUrl: './admin-dashboard.html',
  styleUrl: './admin-dashboard.scss',
  providers: [FactureService, DefuntService, PaiementService]
})
export class AdminDashboardComponent implements OnInit {

  kpis: KpiCard[] = [];
  paymentDistribution: PaymentDistribution[] = [];
  paymentRate: number = 0;
  dossiers: Dossier[] = [];

  constructor(
    private factureService: FactureService,
    private defuntService: DefuntService,
    private paiementService: PaiementService
  ) {}

  ngOnInit(): void {
    this.loadDashboardData();
  }

  loadDashboardData(): void {
    forkJoin({
      factures: this.factureService.getAllFactures(),
      paiements: this.paiementService.getAllPaiements(),
      defunts: this.defuntService.getAllDefunts()
    }).subscribe(({ factures, paiements, defunts }) => {
      
      // Calcul du chiffre d'affaires
      const totalRevenue = factures.reduce((sum, f) => sum + f.montant, 0);
      
      // Calcul du total payé
      const totalPaid = paiements.reduce((sum, p) => sum + p.montant, 0);

      // Calcul du nombre de dossiers
      const totalDossiers = defunts.length;
      
      // Calcul des dossiers terminés (factures entièrement payées)
      const completedDossiers = factures.filter(f => f.statut.toLowerCase() === 'payé').length;

      this.kpis = [
        { icon: 'shopping_cart', title: 'Chiffre d\'affaires', value: `${totalRevenue.toLocaleString()} FCFA`, color: 'green' },
        { icon: 'folder_open', title: 'Dossiers total', value: totalDossiers.toString(), color: 'blue' },
        { icon: 'hourglass_top', title: 'En cours', value: (totalDossiers - completedDossiers).toString(), color: 'orange' },
        { icon: 'check_circle', title: 'Terminés', value: completedDossiers.toString(), color: 'green' }
      ];

      // Taux de paiement global
      this.paymentRate = totalRevenue > 0 ? (totalPaid / totalRevenue) * 100 : 0;

      // Simulation pour la distribution des paiements
      this.paymentDistribution = [
        { name: 'TMoney', percentage: 45, color: '#0b8e7d' },
        { name: 'Flooz', percentage: 30, color: '#f6b03c' },
        { name: 'Espèces', percentage: 20, color: '#4285f4' },
        { name: 'Chèque', percentage: 5, color: '#e2e8f0' }
      ];

      // Mapper les factures récentes pour l'affichage
      this.dossiers = factures.slice(0, 4).map(f => ({
        code: `DOS${f.id.toString().padStart(3, '0')}`,
        deceasedName: f.defunt ? `${f.defunt.nom} ${f.defunt.prenom}` : 'N/A',
        ceremonyDate: new Date(f.dateFacturation).toLocaleDateString(),
        amount: f.montant,
        status: f.statut === 'Payé' ? 'Terminé' : 'En cours'
      }));
    });
  }
}

