package tg.Ipnet.efunerailles.dto;


public class CercueilDTO {
	
	    private Long id;
	    private String modele;
	    private String materiau;
	    private Double prix;
	    private Integer stockDisponible;
	    
	    public CercueilDTO() {
	    	
	    }
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getModele() {
			return modele;
		}
		public void setModele(String modele) {
			this.modele = modele;
		}
		public String getMateriau() {
			return materiau;
		}
		public void setMateriau(String materiau) {
			this.materiau = materiau;
		}
		public Double getPrix() {
			return prix;
		}
		public void setPrix(Double prix) {
			this.prix = prix;
		}
		public Integer getStockDisponible() {
			return stockDisponible;
		}
		public void setStockDisponible(Integer stockDisponible) {
			this.stockDisponible = stockDisponible;
		}
	    
	    
 

}
