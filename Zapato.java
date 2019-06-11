/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaZap;

/**
 *
 * @author Selx
 */
public class Zapato {
    private String clav;
    private String tipo;
    private String marca;
    private String numero;
    private String desc;
    private String temp;
    private String color;
    private String prec;
    
    public Zapato(){
        
    }
    
    public Zapato(String cl, String des, String tip, String mar, String col, String temp, String pre, String num){
     this.clav=cl;
     this.desc=des;
     this.tipo=tip;
     this.marca=mar;
     this.color=col;
     this.temp=temp;
     this.prec=pre;
     this.numero=num;
    }

    public void setClav(String clav) {
        this.clav = clav;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setMarca(String mar) {
        this.marca = mar;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrec(String prec) {
        this.prec = prec;
    }
    
    

    public String getClave() {
        return clav;
    }

    public String getDescripcion() {
        return desc;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getTemporada() {
        return temp;
    }

    public String getPrecio() {
        return prec;
    }

    public String getNumero() {
        return numero;
    }
    
}
