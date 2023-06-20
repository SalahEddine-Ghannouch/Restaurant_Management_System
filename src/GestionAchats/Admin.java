
package GestionAchats;

public class Admin {
    private int IdAdmin;
    private String NomAdmin;
    private String PrenomAdmin;
    private String AdresseAdmin;
    private String EmailAdmin;
    private String TelAdmin;
    
    public Admin(){
        
    }
    
    public Admin(int IdAdmin , String NomAdmin , String PrenomAdmin , String AdresseAdmin , String EmailAdmin , String TelAdmin){
         this.IdAdmin = IdAdmin ;
         this.NomAdmin = NomAdmin;
         this.PrenomAdmin = PrenomAdmin;
         this.AdresseAdmin = AdresseAdmin;
         this.EmailAdmin = EmailAdmin; 
         this.TelAdmin = TelAdmin;
    
    }
    
    public void AddAdmin (int IdAdmin , String NomAdmin , String PrenomAdmin , String AdresseAdmin , String EmailAdmin , String TelAdmin){
         this.IdAdmin = IdAdmin ;
         this.NomAdmin = NomAdmin;
         this.PrenomAdmin = PrenomAdmin;
         this.AdresseAdmin = AdresseAdmin;
         this.EmailAdmin = EmailAdmin; 
         this.TelAdmin = TelAdmin;
    }
    
    public void UpdateAdmin(int IdAdmin , String NomAdmin , String PrenomAdmin , String AdresseAdmin , String EmailAdmin , String TelAdmin){

        if( IdAdmin != 0) this.IdAdmin = IdAdmin ;
         if( NomAdmin != null) 
             this.NomAdmin = NomAdmin;
         if( PrenomAdmin != null) 
             this.PrenomAdmin = PrenomAdmin;
         if( AdresseAdmin != null) 
             this.AdresseAdmin = AdresseAdmin;
         if( EmailAdmin != null) 
             this.EmailAdmin = EmailAdmin; 
         if( TelAdmin != null) 
             this.TelAdmin = TelAdmin;
    }
    
    public int Get_IdAdmin(){
        return this.IdAdmin;
    }
    
    public void DropAdmin(){
        
    }
    
}
