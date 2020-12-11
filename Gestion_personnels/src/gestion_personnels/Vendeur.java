 
package gestion_personnels;

public class Vendeur extends Employe{ private static double poucentage=0.2;
	private double ventes;
	

	public Vendeur(String nom, int matricule, int nbre_heure, double prix_heure, double ventes) 
	{
		super(nom, matricule, nbre_heure, prix_heure);
		this.ventes=ventes;
		
	}

	public double getVentes() {
		return ventes;
	}

	/************************************/
	public void setCommission(float ventes) {
		this.ventes = ventes;
	}
	/***************calcul salaire********************/
	public double calculerSalaire() {
		return super.calculerSalaire()+(this.ventes*Vendeur.poucentage);
	}
	
	/*******************affichage du vendeur********/
	public void afficherSalarie() {
		super.afficheSalaire();
		System.out.println("le total de ventes est "+this.ventes);
		//System.out.println("***************************************");
		
	}
	/*************************************************/
	


    
}
