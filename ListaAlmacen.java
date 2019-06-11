/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogozap;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import listaZap.Almacen;
import listaZap.Empleado;
import listaZap.Zapato;
import listaZap.listaAlmacen;
import listaZap.listaEmple;

/**
 *
 * @author Selx
 */
public class ListaAlmacen extends Pane{
    private TableView tb = new TableView();
    
    public ListaAlmacen(){
        crear();
    }
    
    public void crear(){
        List<Almacen> listAlm = listaAlmacen.Lista();

        TableColumn colId = new TableColumn("ID");
        colId.setPrefWidth(135);
        colId.setCellValueFactory(new PropertyValueFactory<Zapato,String>("idAlmacen"));

        TableColumn colUbi = new TableColumn("Ubicacion");
        colUbi.setPrefWidth(135);
        colUbi.setCellValueFactory(new PropertyValueFactory<Zapato,String>("ubicacion"));
        
        TableColumn colNom = new TableColumn("Nombre");
        colNom.setPrefWidth(135);
        colNom.setCellValueFactory(new PropertyValueFactory<Zapato,String>("nombre"));

        TableColumn colInv = new TableColumn("Inventario");
        colInv.setPrefWidth(135);
        colInv.setCellValueFactory(new PropertyValueFactory<Zapato,String>("inventario"));

        tb.getColumns().addAll(colId, colUbi, colNom, colInv);
        tb.setItems(FXCollections.observableList(listAlm));

        getChildren().add(tb);
    }
    
    public Almacen Devolver(){
        Almacen al = (Almacen) tb.getSelectionModel().getSelectedItem();
        return al;
    }
}
