
package test;

import beans.Pets;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
    public static void main(String[] args) {
       listarPets();
        //actualizarPets(1, "Danna");
    }
    
    public static void actualizarPets(int id_pet, String name_pet) {
        
    DBConnection con= new DBConnection();
    String sql= "UPDATE pets SET name_pet = '"+ name_pet +"'where id_pet =" + id_pet;
    
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            con.desconectar();
        }
        
}
   public static void listarPets(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM pets";
        
        try {
          Statement st = con.getConnection().createStatement();
          ResultSet rs = st.executeQuery(sql);
          
          while(rs.next()){
              int id_pet = rs.getInt("id_pet");
              String name_pet = rs.getString("name_pet");
              String provisional_name = rs.getString("provisional_name");
              String race = rs.getString("race");
              int weight = rs.getInt("weight");
              String vaccines_applied = rs.getString("vaccines_applied");
              boolean sterilized= rs.getBoolean("sterilized");
              String data_pet= rs.getString("data_pet");
              
              Pets pet = new Pets(id_pet, name_pet, provisional_name, race, weight, vaccines_applied, sterilized, data_pet);
              System.out.println(pet.toString());
          }
          
         st.executeQuery(sql);
        }catch(Exception ex){
            System.out.println(ex.getMessage());        
        }finally {
            con.desconectar();
        }
    }
}

