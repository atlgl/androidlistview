package ejemplo.androidlistview.modelo;

/**
 * Created by Angelus on 15/02/2017.
 */

public class Ciudades {

    private int idCiudad;
    private String nombre;
    private String descripcion;
    private int foto;

    @Override
    public String toString() {
        return "Ciudades{" +
                "idCiudad=" + idCiudad +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", foto=" + foto +
                '}';
    }

    public Ciudades(int idCiudad, String nombre, String descripcion, int foto) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
    }

    public Ciudades(int idCiudad, String nombre) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
