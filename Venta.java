
package listaZap;

/**
 *
 * @author Selx
 */
public class Venta {
    private String nombre;
    private int cant;
    private int monto;

    public Venta(String nombre, int cant, int monto) {
        this.nombre = nombre;
        this.cant = cant;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
}
