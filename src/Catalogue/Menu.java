package Catalogue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Menu {
    //!!!!!!!!!!!!!!
    public Connection con;
    public Statement stm;
    public ResultSet rst;
    //!!!!!!!!!!!!!
    private int CodeMenu;
    private String DescriptionMenu;
    private String ContenuMenu;
    private String TitleMenu;
    
    public Menu(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant","root","");
           stm=con.createStatement();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        } 
    }
    
    public Menu(int CodeMenu , String DescriptionMenu , String ContenuMenu , String TitleMenu){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant","root","");
           stm=con.createStatement();
           this.CodeMenu = CodeMenu;
           this.DescriptionMenu = DescriptionMenu;
           this.ContenuMenu = ContenuMenu;
           this.TitleMenu = TitleMenu;
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        } 
        
    }
   
    
    public void  AddMenu(int CodeMenu , String DescriptionMenu , String ContenuMenu , String TitleMenu){
        try{
           String query="INSERT INTO Menu  VALUES ("+CodeMenu+",'"+DescriptionMenu+"','"+ContenuMenu+"' ,'"+TitleMenu+"' ) ";
           stm.executeUpdate(query);
             System.out.println("Bien Ajouter");        
        }catch(Exception e){
        System.out.println("Erreur Dans L'ajout : "+e);
        }
    }
    
    public void  UpdateMenu(int CodeMenu , String DescriptionMenu , String ContenuMenu , String TitleMenu){
         try{
           String query="UPDATE Menu SET Description_Menu = '"+DescriptionMenu+"' , Content_Menu = '"+ContenuMenu+"' , Title_Menu = '"+TitleMenu+"' where Code_Menu = "+CodeMenu;
           stm.executeUpdate(query);
             System.out.println("Bien Modifier");        
        }catch(Exception e){
        System.out.println("Erreur Dans La modification : "+e);
        }
    }
    
    public void DropMunu(int CodeMunu){
        try{
           String query="delete from Menu where Code_Menu = "+CodeMunu;
           stm.executeUpdate(query);
             System.out.println("Bien Supprimer");        
        }catch(Exception e){
        System.out.println("Erreur Dans La Supprition : "+e);
        }
    }

    public int getCodeMenu() {
        return CodeMenu;
    }

    public void setCodeMenu(int CodeMenu) {
        this.CodeMenu = CodeMenu;
    }

    public String getDescriptionMenu() {
        return DescriptionMenu;
    }

    public void setDescriptionMenu(String DescriptionMenu) {
        this.DescriptionMenu = DescriptionMenu;
    }

    public String getContenuMenu() {
        return ContenuMenu;
    }

    public void setContenuMenu(String ContenuMenu) {
        this.ContenuMenu = ContenuMenu;
    }

    public String getTitleMenu() {
        return TitleMenu;
    }

    public void setTitleMenu(String TitleMenu) {
        this.TitleMenu = TitleMenu;
    }
    
}
