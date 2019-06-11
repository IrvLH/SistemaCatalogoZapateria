
package catalogozap;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Selx
 */
public class AccesoInicial extends Stage{
    private BorderPane bp;
    private Label usuario, contraseña;
    private TextField us, con;
    private Button acceder, cancelar;
    private GridPane caja;
    private boolean act=false;
    private CatalogoCliente ant;
    
    public AccesoInicial(CatalogoCliente ant){
        iniciar();
        this.ant=ant;
    }

    private void iniciar() {
        bp = new BorderPane();
        caja = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        caja.getColumnConstraints().add(column1);
        caja.getColumnConstraints().add(column2);
        column1.setPercentWidth(50);
        column2.setPercentWidth(50);
        
     
        usuario = new Label("Usuario: ");
        contraseña = new Label("Contraseña: ");
        caja.add(usuario,0,1);
        caja.add(contraseña,0,2);
        
        us = new TextField();
        con = new TextField();
        caja.add(us,1,1);
        caja.add(con,1,2);
        
        acceder = new Button("Ingresar");
        acceder.setOnAction(ev ->{
            String usua = us.getText();
            String contr = con.getText();
            
            if(verificar(usua, contr)){
                System.out.println("Correcto!");
                Principal p = new Principal(ant);
                us.setDisable(true);
                con.setDisable(true);
                acceder.setDisable(true);
                hide();
                ant.ocultar(true);
            }else{
                System.out.println("Incorrecto");
                Alert dialogo = new Alert(Alert.AlertType.ERROR);
                dialogo.setTitle("Sin autorizacion");
                dialogo.setHeaderText("Datos incorrectos");
                dialogo.setContentText("El usuario o contraseña no son correctos!");
                dialogo.show();
                
            }
        });
        cancelar = new Button("Cancelar");
        cancelar.setOnAction(ev ->{
            this.close();
        });
        caja.add(acceder,0,3);
        caja.add(cancelar,1,3);
        
        bp.setCenter(caja);
        bp.setAlignment(caja,Pos.CENTER);
        
        Scene sc = new Scene(bp,500,100);
        setScene(sc);
        setTitle("Acceso Administrativo");
        show();
    }
    
    public boolean verificar(String usua, String cont){
        boolean acceso=false; 
        if(listaZap.listaEmple.Autorizar(usua, cont))
            acceso=true;
        
        return acceso;
    }
    
    public void activar(){
        
    }
}
