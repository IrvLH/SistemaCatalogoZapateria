
package listaZap;

/**
 *
 * @author Selx
 */
public class Sucursal {
    private String idSucursal;
    private String telefono;
    private String direccion;
    
    public Sucursal(String idSuc, String tel, String dire){
        this.idSucursal=idSuc;
        this.telefono=tel;
        this.direccion=dire;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdSucursal() {
        return idSucursal;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
}
