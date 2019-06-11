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
public class listaSucursal {
    public static boolean Agregar(Sucursal suc){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String campos = "idSucursal, telefono, direccion";
            String valores = "'"+suc.getIdSucursal()+"', '"+suc.getTelefono()+
                    "', '"+suc.getDireccion()+"'";
            String cadSQL = "insert into sucursal ("+campos+") values("+valores+")";
            instr.executeUpdate(cadSQL);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static List<Sucursal> Lista(){
        List<Sucursal> listaSuc = new ArrayList();
        try{
            Connection con;
            Statement instr;
            ResultSet rsDepto;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            rsDepto = instr.executeQuery("select * from sucursal");
            
            while(rsDepto.next()){
                String id = rsDepto.getString("idSucursal");
                String tel = rsDepto.getString("telefono");
                String dir = rsDepto.getString("direccion");
                
                Sucursal suc = new Sucursal(id, tel, dir);
                
                listaSuc.add(suc);
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
        return listaSuc;
    }
    
    public static boolean Eliminar(Sucursal suc){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            
            String cadSQL = "delete from sucursal where idSucursal = '"+suc.getIdSucursal()+"'";
            instr.executeUpdate(cadSQL);
            System.out.println("eliminado");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean Modificar(Sucursal suc){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String cadSQL = "update sucursal set idSucursal='"+suc.getIdSucursal()+"', telefono='"
                    +suc.getTelefono()+"', direccion='"+suc.getDireccion()+
                    "' where idSucursal='"+suc.getIdSucursal()+"'";
            instr.executeUpdate(cadSQL);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
