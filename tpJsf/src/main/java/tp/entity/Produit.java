package tp.entity;

//@Entity
public class Produit {
	
	private Long num;
	private String label;
	private Double prix;
	private String description;
	//....
	public Produit() {
	}

	public Produit(Long num, String label, Double prix, String description) {
		this.num = num;
		this.label = label;
		this.prix = prix;
		this.description = description;
	}



	public Long getNum() {
		return num;
	}
	
	public void setNum(Long num) {
		this.num = num;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
