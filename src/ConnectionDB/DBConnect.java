package ConnectionDB;
import java.sql.*;

public class DBConnect {
    Connection con;
    Statement stm;
    ResultSet rst;
   public DBConnect(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_restaurant","root","");
           stm=con.createStatement();
       }catch(Exception e){
           System.out.println("Erreur de chargement de pilote:"+e);
        } 
   }
   public void getData(){
       try{
           String query="select * from test ";//pour limiter la selection 
           rst=stm.executeQuery(query);
           System.out.println("Voici les enregistrement de la Table :Etudiant");
           while(rst.next()){
                int id=rst.getInt(""+ "code");
                //String nom=rst.getString("nom");
                //int age=rst.getInt("age");
           
                System.out.println(id+"\t");
           }
        }catch(Exception e){
        System.out.println("Erreur:"+e);
        }
   }
   public void ajouter(int id,String nom,int age){
       try{
           String query="INSERT INTO etudiant VALUES ("+id+",'"+nom+"',"+age+")";
           stm.executeUpdate(query);
                     
        }catch(Exception e){
        System.out.println("Erreur:"+e);
        }
   }
   public void supprimer(int id){
       try{
           String query="DELETE FROM Etudiant where id="+id;
           stm.executeUpdate(query);
                     
        }catch(Exception e){
        System.out.println("Erreur:"+e);
        }
   }
   public void chercher(String nom){
       try{
           String query="select * from etudiant where nom='"+nom+"'";
           rst=stm.executeQuery(query);
           rst.last();
           int nbrRow=0;
           nbrRow=rst.getRow();
           System.out.println(nbrRow);
           if(nbrRow!=0)
               System.out.println("Etudiant trouvé\t"+nbrRow);
           else
               System.out.println("Etudiant non trouvé");
        }catch(Exception e){
        System.out.println("Erreur:"+e);
        }
   }
   public void modifier(int id,String nom,int age){
       try{
           String query="update etudiant set id='"+id
                            +"',nom='"+nom
                            +"',age='"+age 
                            + "'Where id="+id;
           stm.executeUpdate(query);
                     
        }catch(Exception e){
        System.out.println("Erreur:"+e);
        }
   }
}



 

