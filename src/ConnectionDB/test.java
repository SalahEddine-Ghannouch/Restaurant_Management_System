
package ConnectionDB;
import java.sql.SQLException;

public class test {

      public static void main(String[] args) throws SQLException {
        DBConnect connect=new DBConnect();
        connect.getData();
        //connect.ajouter(21, "samira", 20);
        //connect.supprimer(19);
        //connect.chercher("samira");
        //connect.modifier(19, "Karimi", 20);
        //connect.getData();
        connect.stm.close();
        connect.con.close();
    }
}


