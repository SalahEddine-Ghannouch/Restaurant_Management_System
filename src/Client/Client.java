
package Client;
import java.sql.*;


public class Client {
    
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
 public int IdAdmin;
    
     // Voila le premier constracteur
 
   public Client(int Id,String Nom,String Prenom,String Adresse,String Email,String Telephone,int IdAdmin){
       this.Id = Id;
       this.Nom = Nom;
       this.Prenom = Prenom;
       this.Adresse = Adresse;
       this.Email = Email;
       this.Telephone = Telephone;
       this.IdAdmin = IdAdmin;
       
   }
   
    // Voila le deuxieme constracteur
   
    public Client(){
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant?useTimazone=true&serverTimezone=UTC","root","");
           stm=con.createStatement();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        } 
    }
    
    // Voila les getters
    
    public int getIdClient() {
        return Id;
    }

    public String getNomClient() {
        return Nom;
    }

    public String getPrenomClient() {
        return Prenom;
    }

    public String getAdresseClient() {
        return Adresse;
    }

    public String getEmailClient() {
        return Email;
    }

    public String getTelephoneClient() {
        return Telephone;
    }
    
    public int getIdAdmin() {
        return IdAdmin;
    }
    
    // Voila les setters

    public void setIdClient(int Id) {
        this.Id = Id;
    }

    public void setNomClient(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenomClient(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAdresseClient(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setEmailClient(String Email) {
        this.Email = Email;
    }

    public void setTelephoneClient(String Telephone) {
        this.Telephone = Telephone;  
    }
    
    public void setIdAdmin(int IdAdmin) {
        this.IdAdmin = IdAdmin;  
    }
    
    //methode inscription
    public void InscriptionClient(int Id,String Nom,String Prenom,String Adresse,String Email,String Telephone ,int IdAdmin){
        try{
           String query="INSERT INTO customer  VALUES ("+Id+",'"+Nom+"','"+Prenom+"','"+Adresse+"','"+Email+"','"+Telephone+"',"+IdAdmin+") ";
           stm.executeUpdate(query);
             System.out.println("Bien Ajouter");        
        }catch(Exception e){
        System.out.println("Erreur Dans L'ajout : "+e);
        }
    }
    //methodeUser
    public void User(int Id_User,int Password_User){  //account
        try{
           String query="INSERT INTO account  VALUES ("+Password_User+","+Id_User+") ";
            stm.executeUpdate(query);
             System.out.println("Bien Ajouter compte ");        
        }catch(Exception e){
        System.out.println("Erreur Dans L'ajout : "+e);
        }
    }
    
     //methode miseàJour
    public void MiseàJourClient(int Id,String Nom,String Prenom,String Adresse,String Email,String Telephone ,int IdAdmin){
        try{
           String query="update customer set Id_Customer="+Id+",Last_Name='"+Nom+"',Frist_Name='"+Prenom+"' ,Address_Customer='"+Adresse+"' ,Email_Customer='"+Email+"' ,Phone_Customer='"+Telephone+"' ,Id_Manager='"+IdAdmin+"' Where Id_Customer="+Id;
           stm.executeUpdate(query);    
        }catch(Exception e){
        System.out.println("Erreur dans la Mise à Jour: "+e);
        }
        
    }
    
     //methode Supprimer
     public void SupprimerClient(int Id){
         try{
           String query="DELETE FROM customer where Id_Customer ="+Id;
           stm.executeUpdate(query);
        }catch(Exception e){
        System.out.println("Erreur dans la supprission:"+e);
        }
         
    }
     
      //methode Afficher le Client Par son Id
     public void AfficherClientParId(int Id){
         int i=1;
         try{
           String query="select * from customer where Id_Customer= "+Id;// pour limiter la selection 
           rst=stm.executeQuery(query);
           System.out.println("Voici les enregistrements dans la Table Client du ID "+Id);
           while(rst.next()){
                int id=rst.getInt("Id_Client");
                String nom=rst.getString("Nom_Client");
                String prenom=rst.getString("Prenom_Client");
                String adresse=rst.getString("Adresse_Client");
                String email=rst.getString("Email_Client");
                String tele=rst.getString("Tel_client");
                int idAdmin=rst.getInt("Id_Admin");
                System.out.println(i+")==>\t"+"ID : "+id+"\t\t"+"Nom : "+nom+"\t\t"+"Prenom : "+prenom+"\t\t"+"Adresse : "+adresse+"\t\t"+"Email : "+email+"\t\t"+"Tele : "+tele+"IdAdmin : "+idAdmin);
                i++;}
              }catch(Exception e){
                 System.out.println("Erreur dans l'affichage par ID:"+e);
              }
             }
     
     //methode Afficher Tous les Client
      public void AfficherClient(){
          int i=1;
          try{
           String query="select * from client ";
           rst=stm.executeQuery(query);
           System.out.println("Voici les enregistrement dans la Table Client");
           while(rst.next()){
                int id=rst.getInt("Id_Client");
                String nom=rst.getString("Nom_Client");
                String prenom=rst.getString("Prenom_Client");
                String adresse=rst.getString("Adresse_Client");
                String email=rst.getString("Email_Client");
                String tele=rst.getString("telephone_client");
                int idAdmin=rst.getInt("Id_Admin");
                System.out.println(i+")==>\t"+"ID : "+id+"\t\t"+"Nom : "+nom+"\t\t"+"Prenom : "+prenom+"\t\t"+"Adresse : "+adresse+"\t\t"+"Email : "+email+"\t\t"+"Tele : "+tele+"IdAdmin : "+idAdmin);
                i++;}
              }catch(Exception e){
               System.out.println("Erreur dans l'affichage :"+e);
               }
            }
    
}
