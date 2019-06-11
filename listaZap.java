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
public class listaZap {
    
    public static boolean Eliminar(Zapato zapa){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            
            String cadSQL = "delete from zapato where idInv = '"+zapa.getClave()+"'";
            instr.executeUpdate(cadSQL);
            System.out.println("eliminado");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean Agregar(Zapato zapa){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String campos = "idInv, tipo, marca, numero, descripcion, temporada, color, precio";
            String valores = "'"+zapa.getClave()+"', '"+zapa.getTipo()+"', '"+zapa.getMarca()+"', '"+zapa.getNumero()+
                    "', '"+zapa.getDescripcion()+"', '"+zapa.getTemporada()+"', '"+zapa.getColor()+"', '"
                    +zapa.getPrecio()+"'";
            String cadSQL = "insert into zapato ("+campos+") values("+valores+")";
            instr.executeUpdate(cadSQL);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static boolean Modificar(Zapato zapa){
        try{
            Connection con;
            Statement instr;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            String cadSQL = "update zapato set idInv='"+zapa.getClave()+"', tipo='"+zapa.getTipo()+
                    "', marca='"+zapa.getMarca()+"', numero='"+zapa.getNumero()+"', descripcion='"+zapa.getDescripcion()+"', temporada='"
                    +zapa.getTemporada()+"', color='"+zapa.getColor()+"', precio='"+zapa.getPrecio()
                    +"' where idInv='"+zapa.getClave()+"' and tipo='"+zapa.getTipo()+"'";
            instr.executeUpdate(cadSQL);
            System.out.println("modificado!");
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    
    public static List<Zapato> Lista(){
        List<Zapato> listaZap = new ArrayList();
        try{
            Connection con;
            Statement instr;
            ResultSet rsDepto;
            Class.forName("com.mysql.jdbc.Driver").newInstance();//puede no llevar newInstance
            con = DriverManager.getConnection("jdbc:mysql://localhost/zapato?user=root&password=Sphinx");
            instr = con.createStatement();
            rsDepto = instr.executeQuery("select * from zapato");
            
            while(rsDepto.next()){
                String clave = rsDepto.getString("idInv");
                String descri = rsDepto.getString("descripcion");
                String tipo = rsDepto.getString("tipo");
                String mar = rsDepto.getString("marca");
                String color = rsDepto.getString("color");
                String temp = rsDepto.getString("temporada");
                String pre = rsDepto.getString("precio");
                String num = rsDepto.getString("numero");
                
                Zapato zap = new Zapato(clave, descri, tipo, mar, color, temp, pre, num);
                
                listaZap.add(zap);
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
        return listaZap;
    }
}
