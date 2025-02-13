package kz.aitu.oop.MyProject.entities;

public class Customer {
    private int idC;
    private String name;
    private String email;

    public Customer() {}

    public Customer(int idC, String name, String email) {
        this.idC = idC;
        this.name = name;
        this.email = email;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
