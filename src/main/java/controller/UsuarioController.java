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
    @Override
    public String register (int user_id, String user_password,String user_name, 
            String last_name, String email, String location_user){

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into user values('" + user_id + "', '" + user_password + "', '" + user_name
                + "', '" + last_name + "', '" + email + "', '" + location_user + "')";


        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            User user = new User(user_id, user_password, user_name, last_name, email, location_user);

            st.close();

            return gson.toJson(user);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
    @Override
    public String pedir(int user_id) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from user where user_id = '" + user_id + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String user_password = rs.getString("user_password");
                String user_name = rs.getString("user_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String location_user = rs.getString("location_user");

                User user = new User(user_id, user_password,
                        user_name, last_name, email, location_user);

                return gson.toJson(user);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String modificar(int user_id, String user_password,
                            String user_name, String last_name,
                            String email, String location_user) {

        DBConnection con = new DBConnection();
        String sql = "UPDATE user SET "
                                    + "user_id = " + user_id + ", "
                                    + "user_password = '" + user_password + "', "
                                    + "user_name = '" + user_name + "', "
                                    + "last_name = '" + last_name + "', "
                                    + "email = '" + email + "', "
                                    + "location_user = '" + location_user + "' ";
        
        sql += "WHERE user_id = '" + user_id + "'"; 
        
        //return sql;
                                                                
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            con.desconectar();
            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    @Override
    public String eliminar(int user_id) {

        DBConnection con = new DBConnection();
        String sql = "DELETE FROM user WHERE user_id = " + user_id;

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            con.desconectar();
            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }
}





