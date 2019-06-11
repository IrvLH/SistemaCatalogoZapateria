
package listaZap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Selx
 */
public class listaVent {
    public static List<Venta> Lista(){
        List<Venta> listaVen = new ArrayList();
        try{
            Connection con;
            Statement instr;
            ResultSet rsDepto;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            rsDepto = instr.executeQuery("select * from venta");
            
            while(rsDepto.next()){
                String nom = rsDepto.getString("nombre");
                int cant = rsDepto.getInt("cantPro");
                int mon = rsDepto.getInt("monto");
                
                Venta ven = new Venta(nom, cant, mon);
                
                listaVen.add(ven);
            }
        }catch(SQLException e){
            System.out.println("Error en SQL: "+e);
        }catch(ClassNotFoundException e){
            System.out.println("Error en Class: "+e);
        }catch(InstantiationException e){
            System.out.println("Error en Instantiation: "+e);
        }catch(IllegalAccessException e){
            System.out.println("Error en Acceso: "+e);
        }
        return listaVen;
    }
    
    public static boolean Agregar(Venta ven){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String campos = "nombre, cantPro, monto";
            String valores = "'"+ven.getNombre()+"', '"+ven.getCant()+
                    "', '"+ven.getMonto()+"'";
            String cadSQL = "insert into venta ("+campos+") values("+valores+")";
            instr.executeUpdate(cadSQL);
            System.out.println("venta agregada!");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean Eliminar(Venta ven){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            
            String cadSQL = "delete from venta where nombre = '"+ven.getNombre()+"'";
            instr.executeUpdate(cadSQL);
            System.out.println("eliminado");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
