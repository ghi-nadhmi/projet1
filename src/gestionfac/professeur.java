/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionfac;

/**
 *
 * @author HP
 */
public class professeur {
    int id ;
    String nom ;
    String prenom ;
    String secteur ;
    public professeur (int id ,String nom,String prenom,String secteur)
    { this.id=id;
      this.nom=nom ;
      this.prenom=prenom ;
      this.secteur=secteur ;
    
    }
  public String getNom()
  {return nom ;}
  public String getPrenom ()
  {return prenom ;}
  public int getId()
  {return id ;}
  public String getSecteur()
  {return secteur ;}
  public void setNom()
  {this.nom= nom ;}
  public void SetPrenom ()
  {this.prenom= prenom ;}
  public void setId()
  {this.id=id ;}
  public void setSecteur()
  {this.secteur=secteur ;}
  
  
    
}
