package tp.web.model;

//modèle dans MVC (javaBean , pojo)
public class CalculTva {
	private String ht;
	private String tauxTva;
	private Double tva;
	private Double ttc;
	private String message;//erreur ou pas
	
	public void calculer() {
		double dHt = Double.parseDouble(ht);
		double dTauxTva = Double.parseDouble(tauxTva);
		this.tva = dHt * dTauxTva/100;
		this.ttc = tva + dHt;
	}
	
	public CalculTva() {
	}
	
	public String getHt() {
		return ht;
	}
	public void setHt(String ht) {
		this.ht = ht;
	}
	public String getTauxTva() {
		return tauxTva;
	}
	public void setTauxTva(String tauxTva) {
		this.tauxTva = tauxTva;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
