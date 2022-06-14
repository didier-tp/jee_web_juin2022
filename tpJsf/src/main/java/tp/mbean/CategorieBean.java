package tp.mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import tp.entity.Categorie;
import tp.service.ServiceProduit;

@ManagedBean
@SessionScoped
public class CategorieBean {
	
	private List<Categorie> listeCategorie; //pour remplir valeurs selectionnables
    //dans liste  (+get/set)

    private Categorie categorie=null;
    private Long idCategorie=null;
    private Boolean bNew = Boolean.FALSE;
    
    private ServiceProduit serviceProduit;
    
    public CategorieBean() {
    	this.serviceProduit = ServiceProduit.getInstance();//singleton
    	this.listeCategorie = this.serviceProduit.rechercherListeCategories();
    	/*
    	if(this.listeCategorie!=null && !this.listeCategorie.isEmpty()) {
    	    this.categorie = this.listeCategorie.get(0);
    	    this.idCategorie = this.categorie.getIdCat();
    	}*/
    	this.categorie = new Categorie();
    }
    
    private void selectCategorieFromIdCategorie() {
    	for(Categorie c : this.listeCategorie) {
    		if(c.getIdCat() == this.idCategorie) {
    			this.categorie = c;
    			break;
    		}
    	}
    }
    
    public void onNewCategorie(ActionEvent event) {
		System.out.println("onNewCategorie() ");
		this.categorie = new Categorie();
		this.bNew = true;
	}
    
    public void onAddCategorie(ActionEvent event) {
		System.out.println("onAddCategorie() , categorie=" + this.categorie);
		if(this.categorie.getLabel()!=null && !this.categorie.getLabel().isEmpty()
				&& this.categorie.getIdCat() != null && this.categorie.getIdCat()>0) {
				this.listeCategorie.add(categorie);
				this.idCategorie = this.categorie.getIdCat();
				this.bNew = false;
		}
	}
    
    
    public void onUpdateCategorie(ActionEvent event) {
		System.out.println("onUpdateCategorie() ");
		//...
	}
    
    public void onDeleteCategorie(ActionEvent event) {
		System.out.println("onDeleteCategorie() ");
		if(this.listeCategorie.contains(this.categorie)) {
			this.listeCategorie.remove(this.categorie);
			this.categorie = new Categorie();
			this.idCategorie = null;
		}
	}
    
    public void onCategorieChange(ValueChangeEvent event) {
		this.idCategorie = (Long) event.getNewValue();
		System.out.println("onCategorieChange() idCategorie=" + idCategorie);
		selectCategorieFromIdCategorie();
	}
    
    

	public List<Categorie> getListeCategorie() {
		return listeCategorie;
	}

	public void setListeCategorie(List<Categorie> listeCategorie) {
		this.listeCategorie = listeCategorie;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public Boolean getbNew() {
		return bNew;
	}

	public void setbNew(Boolean bNew) {
		this.bNew = bNew;
	}

    
}
