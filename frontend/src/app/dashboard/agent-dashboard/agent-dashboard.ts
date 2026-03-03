import { Component, OnInit } from '@angular/core';
import { CommonModule, DecimalPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DossierService } from '../../core/services/dossier.service';
import { DossierCard } from '../../core/models/dossier.model';

@Component({
  selector: 'app-agent-dashboard',
  standalone: true,
  imports: [CommonModule, DecimalPipe, FormsModule],
  templateUrl: './agent-dashboard.html',
  styleUrls: ['./agent-dashboard.scss'],
  providers: [DossierService]
})
export class AgentDashboardComponent implements OnInit {
  dossiers: DossierCard[] = [];
  selectedDossier: DossierCard | null = null;
  paymentAmount: number | null = null;
  selectedPaymentMode: string = '';
  
  paymentModes = [
    { id: 'tmoney', name: 'TMoney', icon: 'phone_iphone' },
    { id: 'flooz', name: 'Flooz', icon: 'phone_in_talk' },
    { id: 'especes', name: 'Espèces', icon: 'payments' },
    { id: 'cheque', name: 'Chèque', icon: 'credit_card' }
  ];

  constructor(private dossierService: DossierService) {}

  ngOnInit(): void {
    this.loadDossiers();
  }

  loadDossiers(): void {
    this.dossierService.getAllDossiers().subscribe(data => this.dossiers = data);
  }

  getPaymentPercentage(paid: number, total: number): number {
    if (total === 0) return 0;
    return (paid / total) * 100;
  }

  get remainingAmount(): number {
    if (!this.selectedDossier) return 0;
    return this.selectedDossier.totalAmount - this.selectedDossier.paidAmount;
  }

  openPaymentModal(dossier: DossierCard): void {
    this.selectedDossier = dossier;
    this.paymentAmount = null; 
    this.selectedPaymentMode = ''; 
  }

  closePaymentModal(): void {
    this.selectedDossier = null;
  }

  selectPaymentMode(modeId: string): void {
    this.selectedPaymentMode = modeId;
  }

  submitPayment(): void {
    if (!this.selectedDossier || !this.paymentAmount || !this.selectedPaymentMode) return;

    if (this.paymentAmount <= this.remainingAmount) {
      this.selectedDossier.paidAmount += this.paymentAmount;
      
      if (this.selectedDossier.paidAmount >= this.selectedDossier.totalAmount) {
         this.selectedDossier.status = 'Terminé';
      }
      this.closePaymentModal();
    } else {
      alert("Le montant saisi dépasse le reste à payer !");
    }
  }
}