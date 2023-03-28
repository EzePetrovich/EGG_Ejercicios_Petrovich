
package entity;

public class Cliente {
    
    // Attributes
    
    private String name, surname;
    private int dni;
    private String mail, domic, tel;
    
    // Constructors
    
    public Cliente() {}
    
    public Cliente(String name, String surname, int dni, String mail, String domic, String tel) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.mail = mail;
        this.domic = domic;
        this.tel = tel;
    }
    
    // Getters
    
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public int getDNI() {return dni;}
    public String getMail() {return mail;}
    public String getDomic() {return domic;}
    public String getTel() {return tel;}
    
    // Setters
    
    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setDNI(int dni) {this.dni = dni;}
    public void setMail(String mail) {this.mail = mail;}
    public void setDomic(String domic) {this.domic = domic;}
    public void setTel(String tel) {this.tel = tel;}

    // toString()

    @Override
    public String toString() {return "• CLIENTE.\n· Nombre: " + name + "\n· Apellido: " + surname + "\n· DNI: " + dni + "\n· Mail: " + mail + "\n· Domicilio: " + domic + "\n· Tel: " + tel;}
}
