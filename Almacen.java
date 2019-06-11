
package listaZap;

/**
 *
 * @author Selx
 */
public class Almacen {
    private String idAlmacen;
    private String ubicacion;
    private String nombre;
    private String inventario;

    public Almacen(String idAlmacen, String ubicacion, String nombre, String inventario) {
        this.idAlmacen = idAlmacen;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.inventario = inventario;
    }

    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }
    
    public String getIdAlmacen() {
        return idAlmacen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInventario() {
        return inventario;
    }
    
    
}
