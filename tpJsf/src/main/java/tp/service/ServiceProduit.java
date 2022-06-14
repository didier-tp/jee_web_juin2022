package tp.service;

import java.util.ArrayList;
import java.util.List;

import tp.entity.Categorie;
import tp.entity.Produit;

/*
 Business Service (plus tard pris en charge par Spring ou EJB)
 gérant des produits classés par categorie
 Dans la version temporaire sans spring : design pattern Singleton 
  + jeu de données en dur (simulation sans base de données)
 */
public class ServiceProduit {
	
	private static ServiceProduit uniqueInstance=null;
	
	public static /*synchronized*/ ServiceProduit getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance=new ServiceProduit();
		}
		return uniqueInstance;
	}
	
	private List<Produit> produits; //+get/set ou ...
	
	public List<Produit> rechercherProduitsParCategorie(Long catId){
		List<Produit> sousListeProduits = new ArrayList<Produit>();
		for(Produit prod : this.produits) {
			if( (catId==0) 
				|| (catId==1 && prod.getNum()<=10 )
				|| (catId==2 && prod.getNum()>=10 && prod.getNum()<=20)
				|| (catId==3 && prod.getNum()>=21)) {
				sousListeProduits.add(prod);
			} //sur vrai projet SELECT * From Produit WHERE ....
		}
		return sousListeProduits;
	}
	
	public ServiceProduit(){
		produits=new ArrayList<Produit>();
		produits.add(new Produit(1L,"cahier" , 2.5 ,"grands carreaux"));
		produits.add(new Produit(2L,"stylo" , 1.5 ,"bleu"));
		
		produits.add(new Produit(11L,"film 1" , 12.5 ,"DVD"));
		produits.add(new Produit(12L,"film 2" , 11.5 ,"blue ray"));
		
		produits.add(new Produit(21L,"livre 1" , 7.5 ,"Roman"));
		produits.add(new Produit(22L,"livre 2" , 6.5 ,"BD"));
	}
	
	public List<Categorie> rechercherListeCategories(){
		List<Categorie> listeCat = new ArrayList<Categorie>();
		listeCat.add(new Categorie(0L,"ALL"));
		listeCat.add(new Categorie(1L,"fournitures de bureau"));
		listeCat.add(new Categorie(2L,"films"));
		listeCat.add(new Categorie(3L,"livres"));
		//un SELECT ... FROM Categorie sur vrai projet
		return listeCat;
	}

}
