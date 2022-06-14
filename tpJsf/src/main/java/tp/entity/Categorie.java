package tp.entity;
//@Entity
public class Categorie {
	//@Id
     private Long idCat;
     private String label;
     //+get/set , +constructeurs
     
     
     public Categorie(Long idCat, String label) {
 		super();
 		this.idCat = idCat;
 		this.label = label;
 	}
     
	public Categorie() {
	}

	public Long getIdCat() {
		return idCat;
	}
	
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", label=" + label + "]";
	}
     
	
}
