import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FactureService } from '../core/services/facture.service';
import { PaiementService } from '../core/services/paiement.service';
import { Facture } from '../core/models/facture.model';

@Component({
  selector: 'app-add-paiement',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './add-paiement.html',
  styleUrl: './add-paiement.scss'
})
export class AddPaiementComponent implements OnInit {
  @Output() close = new EventEmitter<void>();
  @Output() refresh = new EventEmitter<void>();

  paiementForm: FormGroup;
  facturesDisponibles: Facture[] = [];
  chargement = false;

  constructor(
    private fb: FormBuilder,
    private factureService: FactureService,
    private paiementService: PaiementService
  ) {
    this.paiementForm = this.fb.group({
      factureId: ['', Validators.required],
      montant: [0, [Validators.required, Validators.min(1)]],
      modePaiement: ['ESPECES', Validators.required],
      datePaiement: [new Date().toISOString().split('T')[0], Validators.required],
      commentaire: ['']
    });
  }

  ngOnInit(): void {
    this.chargerFactures();
  }
// À ajouter à l'intérieur de ta classe AddPaiementComponent
getDefunt(facture: Facture): any {
  return facture.defunt;
}
  chargerFactures(): void {
    // On récupère uniquement les factures qui ne sont pas encore totalement payées
    this.factureService.getAllFactures().subscribe({
      next: (data) => {
        this.facturesDisponibles = data.filter(f => f.resteAPayer > 0);
      },
      error: (err) => console.error("Erreur chargement factures", err)
    });
  }

  onSubmit(): void {
    if (this.paiementForm.valid) {
      this.chargement = true;
      const val = this.paiementForm.value;

      const nouveauPaiement: any = {
        montant: val.montant,
        modePaiement: val.modePaiement,
        datePaiement: val.datePaiement,
        facture: { id: val.factureId } // On lie le paiement à l'ID de la facture
      };

      this.paiementService.createPaiement(nouveauPaiement).subscribe({
        next: () => {
          this.chargement = false;
          this.refresh.emit(); // Actualise le dashboard
          this.close.emit();   // Ferme la modale
        },
        error: (err) => {
          this.chargement = false;
          alert("Erreur lors de l'enregistrement : " + err.message);
        }
      });
    }
  }
}