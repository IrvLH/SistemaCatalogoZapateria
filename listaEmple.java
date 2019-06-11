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
public class listaEmple { 
    public static boolean Agregar(Empleado emp){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String campos = "idEmpledo, usuario, contraseña, nombres, apellidos, edad";
            String valores = "'"+emp.getIdEmple()+"', '"+emp.getUsuario()+"', '"+emp.getContraseña()+"', '"+
                    emp.getNombres()+"', '"+emp.getApellidos()+"', '"+emp.getEdad()+"'";
            String cadSQL = "insert into empleado ("+campos+") values("+valores+")";
            instr.executeUpdate(cadSQL);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static List<Empleado> Lista(){
        List<Empleado> listaEmp = new ArrayList();
        try{
            Connection con;
            Statement instr;
            ResultSet rsDepto;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            rsDepto = instr.executeQuery("select * from empleado");
            
            while(rsDepto.next()){
                String id = rsDepto.getString("idEmpledo");
                String usu = rsDepto.getString("usuario");
                String cont = rsDepto.getString("contraseña");
                String nombre = rsDepto.getString("nombres");
                String apel = rsDepto.getString("apellidos");
                String edad = rsDepto.getString("edad");
                
                Empleado emp = new Empleado(id, usu, cont, nombre, apel, edad);
                
                listaEmp.add(emp);
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
        return listaEmp;
    }
    
    public static boolean Eliminar(Empleado emp){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            
            String cadSQL = "delete from empleado where idEmpledo = '"+emp.getIdEmple()+"'";
            instr.executeUpdate(cadSQL);
            System.out.println("eliminado");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean Modificar(Empleado emp){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String cadSQL = "update empleado set idEmpledo='"+emp.getIdEmple()+"', usuario='"+emp.getUsuario()+
                    "', contraseña='"+emp.getContraseña()+"', nombres='"+emp.getNombres()+"', apellidos='"
                    +emp.getApellidos()+"', edad='"+emp.getEdad()+"' where idEmpledo='"+emp.getIdEmple()+"'";
            instr.executeUpdate(cadSQL);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean Autorizar (String usuar,String contra){
        try{
            Connection con;
            Statement instr;
            ResultSet rsDepto;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            rsDepto = instr.executeQuery("select contraseña from empleado where usuario="+usuar+"");
            
            rsDepto.next();
            String cont = rsDepto.getString("contraseña");
            if(contra.equals(cont))
                return true;
            else
                return false;
        }catch(Exception e){
            return false;
        }
    }
    
}
