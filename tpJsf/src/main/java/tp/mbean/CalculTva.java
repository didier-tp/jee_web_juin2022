package tp.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean // nom logique par defaut = "calculTva" 
             // = nom de la classe avec minuscule au début
//@ManagedBean(name="mbCalculTva") possible
             
@RequestScoped //ou @SessionScoped
public class CalculTva {
	
	private Double ht; //à saisir (par defaut null si rien de saisi)
	private Double taux;//à saisir en %
	private Double tva;//à calculer et afficher
	private Double ttc;//à calculer et afficher
	
	public String calculerTvaEtTtc() {
		String suite=null;//pour rester sur la meme page
		
		this.tva = this.ht * this.taux / 100;
		this.ttc = this.ht + this.tva;
		
		return suite;//pour naviguer ou rester sur la meme page
	}
	
	public CalculTva() {
	}
	
	public Double getHt() {
		return ht;
	}
	public void setHt(Double ht) {
		this.ht = ht;
	}
	public Double getTaux() {
		return taux;
	}
	public void setTaux(Double taux) {
		this.taux = taux;
	}
	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	public Double getTtc() {
		return ttc;
	}
	public void setTtc(Double ttc) {
		this.ttc = ttc;
	}
	
	

}
