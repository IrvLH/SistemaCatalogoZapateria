
package catalogozap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import listaZap.Zapato;
import listaZap.Venta;

/**
 *
 * @author Selx
 */
public class CatalogoCliente extends Stage{
    private BorderPane raiz;
    private List<Zapato> lisZ = new ArrayList();
    private TilePane t;
    private HBox h;
    private VBox v;
    private List<Zapato> lisCar = new ArrayList();
    private Zapato za;
    private TextField txNo;
    private int in;
    private int mont;
    
    public CatalogoCliente(){
        construir();
    }

    private void construir() {
        raiz = new BorderPane();
        ToolBar tb = new ToolBar();
        Pane esp = new Pane();
        esp.setMinWidth(450);
        
        Button cat = new Button("Catalogo");
        cat.setOnAction(ev ->{
            t = new TilePane();
            lisZ = listaZap.listaZap.Lista();
            for(Zapato z : lisZ){
                Pane p = new Pane();
                h = new HBox();
                v = new VBox();
                Image image1;
                ImageView imag; 
                Label l1 = new Label(z.getTipo());
                Label l2 = new Label(z.getMarca());
                Label l3 = new Label(z.getDescripcion());
                Label l4 = new Label(z.getTemporada());
                Label l5 = new Label(z.getPrecio());
                Button b = new Button("Agregar");
                b.setOnAction(eve ->{
                    lisCar.add(z);
                });
                v.getChildren().addAll(l1,l2,l3,l4,l5,b);
                
                switch(z.getTipo()){
                    case "Tenni":
                        image1 = new Image("img/tenis.jpg",80,80,false,false);
                        imag = new ImageView(image1);
                        h.getChildren().addAll(imag,v);
                        break;
                    case "Zapatilla":
                        image1 = new Image("img/zapatilla.jpg",80,80,false,false);
                        imag = new ImageView(image1);
                        h.getChildren().addAll(imag,v);
                        break;
                    case "Zapato":
                        image1 = new Image("img/zapato.jpg",80,80,false,false);
                        imag = new ImageView(image1);
                        h.getChildren().addAll(imag,v);
                        break;
                }
                
                p.getChildren().add(h);
                t.getChildren().add(p);
                t.setPadding(new Insets(10,10,10,10));        
                t.setHgap(15);
                t.setVgap(20);
            }
            raiz.setCenter(t);
        });
        
        Button comp = new Button("Comprar");
        comp.setOnAction(ev ->{
            if(txNo.getText()!=null && mont>1){
                String nombre = txNo.getText();
                Venta vent = new Venta(nombre,in,mont);
                listaZap.listaVent.Agregar(vent);
                Alert dialo = new Alert(Alert.AlertType.INFORMATION);
                dialo.setTitle("Venta");
                dialo.setHeaderText("Se a registrado la venta!");
                dialo.show();
            }else{
                Alert dialo = new Alert(Alert.AlertType.ERROR);
                dialo.setTitle("Error");
                dialo.setHeaderText("Se necesita al menos un producto!");
                dialo.show();
            }
            lisCar.clear();
            in=0;
            mont=0;
        });
        
        Button canc = new Button("Cancelar pedido");
        canc.setOnAction(ev ->{
            Alert dial = new Alert(Alert.AlertType.CONFIRMATION);
            dial.setTitle("Cancelar");
            dial.setHeaderText("Cancelar pedido");
            dial.setContentText("Desea cancelar el pedido?");
            Optional<ButtonType> respuesta = dial.showAndWait();
            if(respuesta.get() == ButtonType.OK){
                lisCar.clear();
                in=0;
                mont=0;
            }
        });
        
        Button car = new Button("Carrito");
        car.setOnAction(ev ->{
            v = new VBox();
            txNo = new TextField();
            txNo.setPromptText("Nombre cliente");
            v.getChildren().add(txNo);
            in=1;
            mont=0;
            for(Zapato z : lisCar){
                if(z!=null){
                    h = new HBox();
                    Label l1 = new Label(in+" "+z.getTipo());
                    Label l2 = new Label(", "+z.getMarca());
                    Label l3 = new Label(", "+z.getDescripcion());
                    Label l4 = new Label(", "+z.getPrecio());
                    mont=mont+Integer.parseInt(z.getPrecio());
                    h.getChildren().addAll(l1,l2,l3,l4);
                    v.getChildren().add(h);
                    h.setPadding(new Insets(10,10,10,10));
                    in++;
                }
            }
            Label l5 = new Label("Monto Total: $"+String.valueOf(mont));
            v.getChildren().add(l5);
            h = new HBox();
            h.getChildren().addAll(comp,canc);
            v.getChildren().add(h);
            raiz.setCenter(v);
        });
        
        Button sal = new Button("Salir");
        sal.setOnAction(ev ->{
            Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
            dialogo.setTitle("Advertencia");
            dialogo.setHeaderText("Salir de la aplicacion");
            dialogo.setContentText("¿Esta seguro de salir?");
            Optional<ButtonType> respuesta = dialogo.showAndWait();
            if(respuesta.get() == ButtonType.OK){
                System.exit(0);
            }
        });
        
        Button acc = new Button("Acceder");
        acc.setOnAction(ev ->{
            AccesoInicial ap = new AccesoInicial(this);
        });
        
        tb.getItems().addAll(cat,car,esp,acc,sal);
        raiz.setTop(tb);
        
        Scene sc = new Scene(raiz, 750, 500);
        setScene(sc);
        
    }
    
    public void ocultar(boolean ban){
        if(ban){
            hide();
        }else{
            show();
        }
    }
    
}
