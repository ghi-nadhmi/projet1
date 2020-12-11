 
package gestion_personnels;

public class Directeur extends Salarie {
    private double salaire;
	private double prime;

	public Directeur(String nom, int matricule, double salaire,double prime) {
		super(nom, matricule);
		this.prime=prime;
		this.salaire=salaire;
	
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public double getPrime() {
		return prime;
	}
	public void setPrime(double prime) {
		this.prime = prime;
	}
	
	/****************afficher salarie*********************/
	public void afficherSalarie() {
		super.afficheSalaire();
                        

		System.out.println("le salaire est "+ this.getSalaire());
		System.out.println("le prime sur salaire est "+ this.getPrime());
		System.out.println("le salaire est "+this.calculerSalaire());
		System.out.println("***************************************");
	}
	/*****************calcul salaire****************/
	
	public double calculerSalaire() {
		return this.salaire+this.prime;
	}

	
	

    
}
