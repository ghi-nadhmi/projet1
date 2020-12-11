package gestion_personnels;
import java.io.IOException;
import java.util.Scanner;

 
public class Gestion_personnels {

 
 
    public static void main(String[] args) {
        TableSal T = new TableSal() ;
        System.out.println("*********** Menu *************");
        System.out.println("Ajouter un salaire  ");
        System.out.println("Supprimer un salarie ");
        System.out.println("Afficher laes salariers ");
        System.out.println("Total des payes a verser");
        System.out.println ("Quitter"); 
        System.out.println ("*********************");
        System.out.println ("donner votre choix ");
        Scanner scan = new Scanner(System.in );
        String val=scan.nextLine();
        char x = val.charAt(0);
        switch(x){
            case 'a' :
        { System.out.println("Directeur D");
          System.out.println("Employe E ");
          System.out.println ("Vendeue V ");
         
          String choix=scan.nextLine();
	  char c=choix.charAt(0);
	  if (c=='D')
           {
	      System.out.println("Vous avez choisi d'ajouter un directeur");
              System.out.println("donner nom");
              //String nom, int matricule, double salaire,double prime
              String nom=scan.nextLine();
              System.out.println("donner matricule");
              int matricule=scan.nextInt();
						
	      System.out.println("Veuillez saisir le salaire");
	      double salaire=scan.nextDouble();
						
	      System.out.println("Veuillez saisir la prime");
	      double prime=scan.nextDouble();
              Directeur D = new Directeur(nom,matricule ,salaire ,prime);
              T.ajouterSalarie(D);
           } 
        
        }
        }
    }
}

        
        
        
              

         
    
    

