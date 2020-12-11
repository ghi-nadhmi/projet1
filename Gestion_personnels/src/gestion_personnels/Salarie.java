 
 
package gestion_personnels;

 
public abstract class Salarie {
    private String nom;
    private int matricule;
public Salarie(String nom,int matricule) 
{this.nom=nom ; this.matricule=matricule; }
public String getNom(){return(this.nom);}
public int getMatricule(){return (this.matricule);}
public void setMatricule(int matricule)
    {
    this.matricule=matricule;
    }
public void afficheSalaire()
    {
    System.out.println("le nom est : "+ this.nom);
    System.out.println("sa matricule est :"+this.matricule);
    }
 public abstract double calculerSalaire();




}
