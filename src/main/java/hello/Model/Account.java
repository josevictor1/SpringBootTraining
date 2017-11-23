package hello.Model;



public class Account {

    public int id;
    public String name;
    public String description;

    public Account(){
        this.id = -1;
    }

    public Account(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
