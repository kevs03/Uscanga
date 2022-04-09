package modelo;

/**
 *
 * @author kevin
 */
public class Persona {
    int id;
    String nom;
    String nom2;
    String correo;
    String telefono;
    String ubicacion;
    String fecha;
    
    public Persona (){
    }

    public Persona(int id, String nom, String nom2, String correo, String telefono, String ubicacion, String fecha) {
    this.id = id;
        this.nom = nom;
        this.nom2 = nom2;
        this.correo = correo;
        this.telefono = telefono;
        this.ubicacion= ubicacion;
        this.fecha= fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getNom2() {
        return nom2;
    }

    public void setNom2(String nom2) {
        this.nom2 = nom2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
