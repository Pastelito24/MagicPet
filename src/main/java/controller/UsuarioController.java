
package controller;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.User;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;
public class UsuarioController implements IUsuarioController {
    @Override
    public String login(int user_id, String user_password) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from user where user_id = '" + user_id
                + "' and user_password = '" + user_password + "'";    
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String user_name = rs.getString("user_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String location_user = rs.getString("location_user");
                

                User user
                        = new User(user_id, user_password, user_name, last_name, email, location_user);
                return gson.toJson(user);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    public String login(String user_id, String user_password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
