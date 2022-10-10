package controller;
import java.util.Map;
public interface IUsuarioController {

    public String login(int user_id, String user_password);
    public String register(int user_id, String user_password,
            String user_name, String last_name, String email, String location_user);
    public String pedir(int user_id);
    public String modificar(int user_id, String user_password, String user_name, String last_name,
                                            String email, String location_user);
    public String eliminar(int user_id);
}
