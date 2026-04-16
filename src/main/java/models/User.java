package models;

public class User {
    // Atributos
    private String name;
    private String lastname;
    private String email;

    // Constructores

    public User(String name, String lastname, String email) {
        this(name, lastname); // Esto llama al constructor que recibe los dos parametros
        this.email = email;
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public User() {
    }

    // Getters & Setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}
