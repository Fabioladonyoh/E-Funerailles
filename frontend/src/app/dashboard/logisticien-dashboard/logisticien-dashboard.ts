import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CercueilService } from '../../core/services/cercueil.service';
import { CorbillardService } from '../../core/services/corbillard.service';
import { InventoryItem } from '../../core/models/inventory.model';
import { Corbillard } from '../../core/models/corbillard.model';

@Component({
  selector: 'app-logisticien-dashboard',
  imports: [CommonModule],
  templateUrl: './logisticien-dashboard.html',
  styleUrl: './logisticien-dashboard.scss',
  providers: [CercueilService, CorbillardService]
})
export class LogisticienDashboardComponent implements OnInit {
  activeTab: 'Inventaire' | 'Corbillards' = 'Inventaire';

  inventory: InventoryItem[] = [];
  corbillards: Corbillard[] = [];
  categories: Array<'Cercueils' | 'Couronnes' | 'Accessoires'> = ['Cercueils', 'Couronnes', 'Accessoires'];

  constructor(
    private cercueilService: CercueilService,
    private corbillardService: CorbillardService
  ) {}

  ngOnInit(): void {
    this.loadInventory();
    this.loadCorbillards();
  }

  loadInventory(): void {
    this.cercueilService.getAllCercueils().subscribe(cercueils => {
      this.inventory = cercueils.map(c => ({
        id: c.id.toString(),
        name: c.nom,
        category: 'Cercueils',
        quantity: c.quantite,
        threshold: 5, // Seuil simulé
        price: c.prix,
        supplier: 'Fournisseur simulé',
        lastRestock: new Date().toLocaleDateString() // Date simulée
      }));
    });
  }

  loadCorbillards(): void {
    this.corbillardService.getAllCorbillards().subscribe(data => this.corbillards = data);
  }

  getItemsByCategory(category: string): InventoryItem[] {
    return this.inventory.filter(item => item.category === category);
  }

  get alerts(): InventoryItem[] {
    return this.inventory.filter(item => item.quantity <= item.threshold);
  }

  isLowStock(item: InventoryItem): boolean {
    return item.quantity <= item.threshold;
  }
}