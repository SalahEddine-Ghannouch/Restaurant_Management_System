
package Catalogue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Facture {
     //!!!!!!!!!!!!!!
    public Connection con;
    public Statement stm;
    public ResultSet rst;
    
    //!!!!!!!!!!!!!
    private int CodeFac;
    private float PrixTotal;
    private int CodeCommande;
    private int IdClient;
    
    public Facture(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant","root","");
           stm=con.createStatement();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        }
    }
    
    public Facture(int CodeFac , float PrixTotal ,int CodeCommande , int IdClient  ){
        this.CodeFac = CodeFac;
        this.PrixTotal = PrixTotal;
        this.IdClient = IdClient;
        this.CodeCommande = CodeCommande ; 
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant","root","");
           stm=con.createStatement();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        }
    }
    
    public void AddFacture(int CodeFac , int PrixTotal ,int CodeCommande , int IdClient  ){
        this.CodeFac = CodeFac;
        this.PrixTotal = PrixTotal;
        this.IdClient = IdClient;
        this.CodeCommande = CodeCommande ; 
        try{
           String query="INSERT INTO bill  VALUES ("+CodeFac+","+PrixTotal+" ,"+CodeCommande+","+IdClient+")";
           stm.executeUpdate(query);
             System.out.println("Bien Ajouter");        
        }catch(Exception e){
        System.out.println("Erreur Dans L'ajout : "+e);
        }
    }
    
    public void DropFacture(int CodeFac){
        try{
           String query="delete from bill where Code_Bill = "+CodeFac;
           stm.executeUpdate(query);
             System.out.println("Bien Supprimer");        
        }catch(Exception e){
        System.out.println("Erreur Dans La supprition : "+e);
        }
    }

    public int getCodeFac() {
        return CodeFac;
    }
    
    public void setCodeFac(int CodeFac) {
        this.CodeFac = CodeFac;
    }

    public float getPrixTotal() {
        return PrixTotal;
    }

    public void setPrixTotal(float PrixTotal) {
        this.PrixTotal = PrixTotal;
    }

    public int getCodeCommande() {
        return CodeCommande;
    }

    public void setCodeCommande(int CodeCommande) {
        this.CodeCommande = CodeCommande;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int IdClient) {
        this.IdClient = IdClient;
    }
    
    
}
