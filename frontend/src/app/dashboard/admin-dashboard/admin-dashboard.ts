import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { forkJoin } from 'rxjs';
import { FactureService } from '../../core/services/facture.service';
import { DefuntService } from '../../core/services/defunt.service';
import { PaiementService } from '../../core/services/paiement.service';
import { KpiCard, PaymentDistribution, Dossier } from '../../core/models/dashboard.model';
import { AddDossierComponent } from '../../add-dossier/add-dossier';
import { AddPaiementComponent } from '../../add-paiement/add-paiement';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  // ✅ Ajout de AddPaiementComponent dans les imports
  imports: [CommonModule, AddDossierComponent, AddPaiementComponent],
  templateUrl: './admin-dashboard.html',
  styleUrl: './admin-dashboard.scss',
  providers: [FactureService, DefuntService, PaiementService]
})
export class AdminDashboardComponent implements OnInit {

  // Variables d'état
  kpis: KpiCard[] = [];
  paymentDistribution: PaymentDistribution[] = [];
  paymentRate: number = 0;
  dossiers: Dossier[] = [];
  
  // ✅ Gestion fine des modales
  isModalOpen: boolean = false;
  activeModal: 'dossier' | 'paiement' | null = null;

  constructor(
    private factureService: FactureService,
    private defuntService: DefuntService,
    private paiementService: PaiementService
  ) {}

  ngOnInit(): void {
    this.loadDashboardData();
  }

  // Méthodes de contrôle des modales
  openDossierModal(): void {
    this.activeModal = 'dossier';
    this.isModalOpen = true;
  }

  openPaiementModal(): void {
    this.activeModal = 'paiement';
    this.isModalOpen = true;
  }

  closeModal(): void {
    this.isModalOpen = false;
    this.activeModal = null;
  }

  handleRefresh(): void {
    this.loadDashboardData();
    this.closeModal();
  }

  loadDashboardData(): void {
    forkJoin({
      factures: this.factureService.getAllFactures(),
      paiements: this.paiementService.getAllPaiements(),
      defunts: this.defuntService.getAllDefunts()
    }).subscribe({
      next: ({ factures, paiements, defunts }) => {
        
        // Calcul du chiffre d'affaires
        const totalRevenue = factures.reduce((sum, f) => sum + (f.montantTotal || 0), 0);
        
        // Calcul du total déjà payé
        const totalPaid = paiements.reduce((sum, p) => sum + (p.montant || 0), 0);

        // Nombre de dossiers
        const totalDossiers = defunts.length;
        
        // Dossiers terminés (statut PAYE)
        const completedDossiers = factures.filter(f => 
          f.statut?.toLowerCase() === 'payé' || f.statut?.toUpperCase() === 'PAYE'
        ).length;

        // Mise à jour des cartes KPI
        this.kpis = [
          { icon: 'payments', title: 'Chiffre d\'affaires', value: `${totalRevenue.toLocaleString()} FCFA`, color: 'green' },
          { icon: 'people', title: 'Dossiers total', value: totalDossiers.toString(), color: 'blue' },
          { icon: 'pending', title: 'En cours', value: (totalDossiers - completedDossiers).toString(), color: 'orange' },
          { icon: 'task_alt', title: 'Terminés', value: completedDossiers.toString(), color: 'green' }
        ];

        // Taux de recouvrement
        this.paymentRate = totalRevenue > 0 ? Math.round((totalPaid / totalRevenue) * 100) : 0;

        // Graphique de répartition
        this.paymentDistribution = [
          { name: 'TMoney', percentage: 45, color: '#0b8e7d' },
          { name: 'Flooz', percentage: 30, color: '#f6b03c' },
          { name: 'Espèces', percentage: 25, color: '#4285f4' }
        ];

        // Mapping des dossiers récents pour le tableau
        this.dossiers = factures.slice(-5).reverse().map(f => {
          const defuntComplet = f.defunt as any; 
          return {
            code: `DOS-${f.id?.toString().padStart(4, '0')}`,
            deceasedName: defuntComplet?.nom ? `${defuntComplet.nom} ${defuntComplet.prenom}` : 'Inconnu',
            ceremonyDate: f.date ? new Date(f.date).toLocaleDateString() : 'N/A',
            amount: f.montantTotal,
            status: (f.statut?.toUpperCase() === 'PAYE') ? 'Terminé' : 'En cours'
          };
        });
      },
      error: (err) => console.error("Erreur chargement dashboard", err)
    });
  }
}