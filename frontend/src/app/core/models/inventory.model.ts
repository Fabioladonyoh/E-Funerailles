export interface InventoryItem {
  id: string;
  name: string;
  category: 'Cercueils' | 'Couronnes' | 'Accessoires';
  quantity: number;
  threshold: number;
  price: number;
  supplier: string;
  lastRestock: string;
}
