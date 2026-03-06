import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DossierService } from '../core/services/dossier.service';

@Component({
  selector: 'app-add-dossier',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './add-dossier.html',
  styleUrl: './add-dossier.scss'
})
export class AddDossierComponent {
  @Output() close = new EventEmitter<void>();
  @Output() refresh = new EventEmitter<void>();
  
  dossierForm: FormGroup;
  isSubmitting = false;

  constructor(
    private fb: FormBuilder,
    private dossierService: DossierService
  ) {
    this.dossierForm = this.fb.group({
      nom: ['', [Validators.required, Validators.minLength(2)]],
      prenom: ['', [Validators.required, Validators.minLength(2)]],
      dateDeces: [new Date().toISOString().split('T')[0], Validators.required],
      montantTotal: [150000, [Validators.required, Validators.min(100)]]
    });
  }

// add-dossier.component.ts

// add-dossier.ts

onSubmit() {
  if (this.dossierForm.valid && !this.isSubmitting) {
    this.isSubmitting = true;
    const val = this.dossierForm.value;
    
    const payload = {
      date: new Date().toISOString().split('T')[0],
      montantTotal: val.montantTotal,
      montantPaye: 0,
      resteAPayer: val.montantTotal,
      statut: 'NON_PAYEE', 
      defunt: {
        nom: val.nom.toUpperCase(),
        prenom: val.prenom,
        dateDeces: val.dateDeces,
        statut: 'EN_ATTENTE',
        // AJOUT DES CHAMPS OBLIGATOIRES DEMANDÉS PAR LE BACKEND :
        dateNaissance: val.dateNaissance || '1960-01-01', // Valeur test ou val.dateNaissance
        lieuConservation: val.lieuConservation || 'Morgue Principale' // Valeur test
      }
    };

    this.dossierService.createDossier(payload).subscribe({
      next: (res) => {
        this.isSubmitting = false;
        this.refresh.emit();
        this.close.emit();
      },
      error: (err) => {
        this.isSubmitting = false;
        console.error("Erreur de validation :", err);
        alert("Champs manquants pour le défunt !");
      }
    });
  }
}
}