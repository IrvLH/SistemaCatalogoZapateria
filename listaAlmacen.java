/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class listaAlmacen {
    public static boolean Agregar(Almacen alm){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String campos = "idAlmacen, ubicacion, nombre, inventario";
            String valores = "'"+alm.getIdAlmacen()+"', '"+alm.getUbicacion()+
                    "', '"+alm.getNombre()+"', '"+alm.getInventario()+"'";
            String cadSQL = "insert into almacen ("+campos+") values("+valores+")";
            instr.executeUpdate(cadSQL);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static List<Almacen> Lista(){
        List<Almacen> listaAlm = new ArrayList();
        try{
            Connection con;
            Statement instr;
            ResultSet rsDepto;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            rsDepto = instr.executeQuery("select * from almacen");
            
            while(rsDepto.next()){
                String id = rsDepto.getString("idAlmacen");
                String ubi = rsDepto.getString("ubicacion");
                String nom = rsDepto.getString("nombre");
                String inv = rsDepto.getString("inventario");
                
                Almacen alm = new Almacen(id, ubi, nom, inv);
                
                listaAlm.add(alm);
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
        return listaAlm;
    }
    
    public static boolean Eliminar(Almacen alm){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            
            String cadSQL = "delete from almacen where idAlmacen = '"+alm.getIdAlmacen()+"'";
            instr.executeUpdate(cadSQL);
            System.out.println("eliminado");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean Modificar(Almacen alm){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String cadSQL = "update almacen set idAlmacen='"+alm.getIdAlmacen()+"', ubicacion='"
                    +alm.getUbicacion()+"', nombre='"+alm.getNombre()+"', inventario='"+alm.getInventario()+
                    "' where idAlmacen='"+alm.getIdAlmacen()+"'";
            instr.executeUpdate(cadSQL);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
