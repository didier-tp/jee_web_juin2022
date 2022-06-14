package tp.mbean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import tp.entity.Categorie;
import tp.entity.Produit;
import tp.service.ServiceProduit;

@ManagedBean
@SessionScoped
public class ProduitBean {
	
	//private Long idProduit; //selectionné , à détailler (avec get/set)
	//et/ou
	private Produit produit; //selectionné , à détailler (avec get/set)
	
	private Date date; //+get/set
	
	private Boolean avecDetails = Boolean.FALSE; //avec valeur par defaut et get/set
	
	private List<Produit> listeProduits; //à afficher dans tableau
	
	private List<Categorie> listeCategorie; //pour remplir valeurs selectionnables
	                                        //dans liste deroulante (+get/set)
	
	private Long categorie=0L;  //id de la categorie choisie/selectionnee 
	                        // via liste déroulante (+get/set) 
							//avec 1L comme valeur par defaut
	
	public String detaillerProduit() {
		String suite="detailProduit";//.jsp ou .xhtml
		//...
		return suite;
	}
	
	public void onDetailsChange(ValueChangeEvent event) {
		this.avecDetails = (Boolean) event.getNewValue();
		System.out.println("onDetailsChange() appele avecDetails=" + avecDetails);
	}
	
	public void onCategorieChange(ValueChangeEvent event) {
		this.categorie = (Long) event.getNewValue();
		System.out.println("onDetailsChange() categorie=" + categorie);
		//reactualisation de la liste des produits selon categorie choisie:
		this.listeProduits = 
			this.serviceProduit.rechercherProduitsParCategorie(this.categorie);
	}
	
	private ServiceProduit serviceProduit;
	
	public ProduitBean() {
		this.serviceProduit = ServiceProduit.getInstance();//singleton
		this.listeProduits = 
			this.serviceProduit.rechercherProduitsParCategorie(this.categorie);
		//avec 1L : id de la categorie par defaut (1L = 1 de type Long)
		this.listeCategorie = this.serviceProduit.rechercherListeCategories();
	}
	
	/*
	public String filtrerSelonCategorie() {
		String suite = null;
		System.out.println("avecDetails=" + avecDetails);
		System.out.println("categorie=" + categorie);//à visualiser dans console eclipse/tomcat
		//reactualisation de la liste des produits selon categorie choisie:
		this.listeProduits = 
				this.serviceProduit.rechercherProduitsParCategorie(this.categorie);
		return suite;
	}
	*/

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public Long getCategorie() {
		return categorie;
	}

	public void setCategorie(Long categorie) {
		this.categorie = categorie;
	}

	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	public Boolean getAvecDetails() {
		return avecDetails;
	}

	public void setAvecDetails(Boolean avecDetails) {
		this.avecDetails = avecDetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	

}
