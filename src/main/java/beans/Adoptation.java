
package beans;


public class Adoptation {
    private int nit;
    private String location_adop;
    private String email_adop;
    private int user_id;
    private int id_pet;

    public Adoptation(int nit, String location_adop, String email_adop, int user_id, int id_pet) {
        this.nit = nit;
        this.location_adop = location_adop;
        this.email_adop = email_adop;
        this.user_id = user_id;
        this.id_pet = id_pet;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getLocation_adop() {
        return location_adop;
    }

    public void setLocation_adop(String location_adop) {
        this.location_adop = location_adop;
    }

    public String getEmail_adop() {
        return email_adop;
    }

    public void setEmail_adop(String email_adop) {
        this.email_adop = email_adop;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId_pet() {
        return id_pet;
    }

    public void setId_pet(int id_pet) {
        this.id_pet = id_pet;
    }

    @Override
    public String toString() {
        return "Adoptation{" + "nit=" + nit + ", location_adop=" + location_adop + ", email_adop=" + email_adop + ", user_id=" + user_id + ", id_pet=" + id_pet + '}';
    }
    
}
