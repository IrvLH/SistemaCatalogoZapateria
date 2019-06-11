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
import listaZap.Sucursal;
import listaZap.Zapato;
import listaZap.listaAlmacen;
import listaZap.listaSucursal;

/**
 *
 * @author Selx
 */
public class ListaSucur extends Pane{
    private TableView tb = new TableView();
    
    public ListaSucur(){
        crear();
    }
    
    public void crear(){
        List<Sucursal> listSuc = listaSucursal.Lista();

        TableColumn colId = new TableColumn("ID");
        colId.setPrefWidth(135);
        colId.setCellValueFactory(new PropertyValueFactory<Zapato,String>("idSucursal"));

        TableColumn colTel = new TableColumn("Telefono");
        colTel.setPrefWidth(135);
        colTel.setCellValueFactory(new PropertyValueFactory<Zapato,String>("telefono"));
        
        TableColumn colDir = new TableColumn("Direccion");
        colDir.setPrefWidth(135);
        colDir.setCellValueFactory(new PropertyValueFactory<Zapato,String>("direccion"));

        tb.getColumns().addAll(colId, colTel, colDir);
        tb.setItems(FXCollections.observableList(listSuc));

        getChildren().add(tb);
    }
    
    public Sucursal Devolver(){
        Sucursal su = (Sucursal) tb.getSelectionModel().getSelectedItem();
        return su;
    }
}
