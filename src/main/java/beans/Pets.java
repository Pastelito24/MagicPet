
package beans;

public class Pets {
    private int id_pet;
    private String name_pet;
    private String provisional_name;
    private String race;
    private int weight;
    private String vaccines_applied;
    private boolean sterilized;
    private String data_pet;

    public Pets(int id_pet, String name_pet, String provisional_name, String race, int weight, String vaccines_applied, boolean sterilized, String data_pet) {
        this.id_pet = id_pet;
        this.name_pet = name_pet;
        this.provisional_name = provisional_name;
        this.race = race;
        this.weight = weight;
        this.vaccines_applied = vaccines_applied;
        this.sterilized = sterilized;
        this.data_pet = data_pet;
    }

    public int getId_pet() {
        return id_pet;
    }

    public void setId_pet(int id_pet) {
        this.id_pet = id_pet;
    }

    public String getName_pet() {
        return name_pet;
    }

    public void setName_pet(String name_pet) {
        this.name_pet = name_pet;
    }

    public String getProvisional_name() {
        return provisional_name;
    }

    public void setProvisional_name(String provisional_name) {
        this.provisional_name = provisional_name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getVaccines_applied() {
        return vaccines_applied;
    }

    public void setVaccines_applied(String vaccines_applied) {
        this.vaccines_applied = vaccines_applied;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public String getData_pet() {
        return data_pet;
    }

    public void setData_pet(String data_pet) {
        this.data_pet = data_pet;
    }

    @Override
    public String toString() {
        return "Pets{" + "id_pet=" + id_pet + ", name_pet=" + name_pet + ", provisional_name=" + provisional_name + ", race=" + race + ", weight=" + weight + ", vaccines_applied=" + vaccines_applied + ", sterilized=" + sterilized + ", data_pet=" + data_pet + '}';
    }
    
}
