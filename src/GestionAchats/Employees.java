
package GestionAchats;
import Client.*;
import java.sql.*;



public class Employees extends Client {
    
    
    public Connection con;
    public Statement stm;
    public ResultSet rst;
    
     // les attributs
 private int Id;
 private String Nom;
 private String Prenom;
 private String Adresse;
 private String Email;
 private String Telephone;
 private int IdAdmin;
    
     // Voila le constracteur
 
     public Employees(int Id,String Nom,String Prenom,String Adresse,String Email,String Telephone,int IdAdmin){
         
       this.Id = Id;
       this.Nom = Nom;
       this.Prenom = Prenom;
       this.Adresse = Adresse;
       this.Email = Email;
       this.Telephone = Telephone;
       this.IdAdmin = IdAdmin;
   }
     
     // Voila le deuxieme constracteur
    
    public Employees(){
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant?useTimazone=true&serverTimezone=UTC","root","");
           stm=con.createStatement();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        } 
    }
   
    
    // Voila les getters

    public int getIdEmployee() {
        return Id;
    }

    public String getNomEmployee() {
        return Nom;
    }

    public String getPrenomEmployee() {
        return Prenom;
    }

    public String getAdresseEmployee() {
        return Adresse;
    }

    public String getEmailEmployee() {
        return Email;
    }

    public String getTelephoneEmployee() {
        return Telephone;
    }
    
    // Voila les setters

    public void setIdEmployee(int Id) {
        this.Id = Id;
    }

    public void setNomEmployee(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenomEmployee(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAdresseEmployee(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setEmailEmployee(String Email) {
        this.Email = Email;
    }

    public void setTelephoneEmployee(String Telephone) {
        this.Telephone = Telephone;
    }
    
     //methode Ajouter
    public void AjouterEmployee(int Id,String Nom,String Prenom,String Adresse,String Email,String Telephone ,int IdAdmin){
        try{
           String query="INSERT INTO Employees  VALUES ("+Id+",'"+Nom+"','"+Prenom+"','"+Adresse+"','"+Email+"','"+Telephone+"',"+IdAdmin+") ";
           stm.executeUpdate(query);
             System.out.println("Bien Ajouter");        
        }catch(Exception e){
        System.out.println("Erreur Dans L'ajout : "+e);
        }
        
    }
   
    //methodeUser  SELECT `Password_User`, `User_Id` FROM `account` WHERE 1
    public void User(int Id_User,int Password_User){
        try{
           String query="INSERT INTO account  VALUES ("+Password_User+","+Id_User+") ";
            stm.executeUpdate(query);
             System.out.println("Bien Ajouter compte ");        
        }catch(Exception e){
        System.out.println("Erreur Dans L'ajout : "+e);
        }
    }
     //methode miseàJour
     public void MiseàJourEmployee(int Id,String Nom,String Prenom,String Adresse,String Email,String Telephone ,int IdAdmin){
        try{
           String query="update Employees set Id_Employee="+Id+",Last_Name='"+Nom+"',First_Name='"+Prenom+"' ,Address_Employee='"+Adresse+"' ,Email_Employee='"+Email+"' ,Phone_Employee='"+Telephone+"' ,Id_Manager='"+IdAdmin+"' Where Id_Employee="+Id;
           stm.executeUpdate(query);    
        }catch(Exception e){
        System.out.println("Erreur dans la Mise à Jour: "+e);
        }
    }
    
     //methode Supprimer
     
     public void SupprimerEmployee(int Id){
        try{
           String query="DELETE FROM Employees where Id_Employee="+Id;
           stm.executeUpdate(query);
        }catch(Exception e){
        System.out.println("Erreur dans la supprission:"+e);
        }
    }
    
    
}
