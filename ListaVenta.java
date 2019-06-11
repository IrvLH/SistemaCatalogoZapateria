
package catalogozap;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import listaZap.Venta;
import listaZap.listaVent;

/**
 *
 * @author Selx
 */
public class ListaVenta extends Pane{
    private TableView tb = new TableView();
    
    public ListaVenta(){
        crear();
    }
    public void crear(){
        List<Venta> listSuc = listaVent.Lista();

        TableColumn colNom = new TableColumn("Nombre");
        colNom.setPrefWidth(135);
        colNom.setCellValueFactory(new PropertyValueFactory<Venta,String>("nombre"));

        TableColumn colCan = new TableColumn("Cantidad Productos");
        colCan.setPrefWidth(135);
        colCan.setCellValueFactory(new PropertyValueFactory<Venta,String>("cant"));
        
        TableColumn colMon = new TableColumn("MontoTotal");
        colMon.setPrefWidth(135);
        colMon.setCellValueFactory(new PropertyValueFactory<Venta,String>("monto"));

        tb.getColumns().addAll(colNom, colCan, colMon);
        tb.setItems(FXCollections.observableList(listSuc));

        getChildren().add(tb);
    }
    
    public Venta Devolver(){
        Venta ve = (Venta) tb.getSelectionModel().getSelectedItem();
        return ve;
    }
}
