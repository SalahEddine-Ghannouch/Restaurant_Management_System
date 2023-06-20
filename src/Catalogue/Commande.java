
package Catalogue;
import java.sql.*;

public class Commande {
    //!!!!!!!!!!!!!!
    public Connection con;
    public Statement stm;
    public ResultSet rst;
    //!!!!!!!!!!!!!
    private int CodeCmd;
    private String DateCmd;
    private String Content;
    private String Total_Price;
    private int IdCustomer;
    
    public Commande(){
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant","root","");
           stm=con.createStatement();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        } 
    }
    
    public Commande(int CodeCmd , String DateCmd ,String Content, String Total_Price ,int IdCustomer){
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant","root","");
           stm=con.createStatement();
           this.CodeCmd = CodeCmd;
           this.Total_Price = Total_Price ; 
           this.DateCmd = DateCmd;
           this.Content = Content;
           this.IdCustomer = IdCustomer;
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        } 
    }
    
    public void AddCmd(int CodeCmd ,  String DateCmd ,String Content, String Total_Price ,int IdCustomer){
        try{
           String query="INSERT INTO Request  VALUES ("+CodeCmd+",'"+DateCmd+"' ,'"+Content+"',"+Total_Price+","+IdCustomer+" ) ";
           stm.executeUpdate(query);
             System.out.println("Bien Ajouter");       
        }catch(Exception e){
        System.out.println("Erreur Dans L'ajout : "+e);
        }
    }
    
    public void DropCmd(int CodeCmd){
        try{
           String query="DELETE FROM Request WHERE Code_Request = "+CodeCmd;
           stm.executeUpdate(query);
             System.out.println("Bien Supprimer");        
        }catch(Exception e){
        System.out.println("Erreur Dans la supprition : "+e);
        }
    }

    public int getCodeCmd() {
        return CodeCmd;
    }

    public void setCodeCmd(int CodeCmd) {
        this.CodeCmd = CodeCmd;
    }

   

    public String getDateCmd() {
        return DateCmd;
    }

    public void setDateCmd(String DateCmd) {
        this.DateCmd = DateCmd;
    }

    public String getCodeMenu() {
        return Total_Price;
    }

    public void setCodeMenu(String Total_Price) {
        this.Total_Price = Total_Price;
    }

    public int getIdCustomer() {
        return IdCustomer;
    }

    public void setIdCustomer(int IdCustomer) {
        this.IdCustomer = IdCustomer;
    }
    
    
    public int getMaxCodeCommande(){
       int x = 0;
       try{
           String query="select MAX(Code_Request) from request ";
           rst=stm.executeQuery(query);
           //System.out.println("Voici les enregistrement de la Table :Etudiant");
           while(rst.next()){
                x=rst.getInt("MAX(Code_Request)");
           }
        }catch(Exception e){
        System.out.println("Erreur:"+e);
        }

        return x;
   }
}
