/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogozap;

import listaZap.Zapato;
import listaZap.listaZap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author Selx
 */
public class ListaCatal extends Pane{
    private TableView tb = new TableView();
    
    public ListaCatal(){
        componentes();
    }
    
    public void componentes(){
        List<Zapato> listZap = listaZap.Lista();
    
        TableColumn colCla = new TableColumn("Clave");
        colCla.setPrefWidth(50);
        colCla.setCellValueFactory(new PropertyValueFactory<Zapato,String>("clave"));
    
        TableColumn colDes = new TableColumn("Tipo");
        colDes.setPrefWidth(114);
        colDes.setCellValueFactory(new PropertyValueFactory<Zapato,String>("tipo"));
        
        TableColumn colMar = new TableColumn("Marca");
        colMar.setPrefWidth(114);
        colMar.setCellValueFactory(new PropertyValueFactory<Zapato,String>("marca"));

        TableColumn colTip = new TableColumn("Numero");
        colTip.setPrefWidth(60);
        colTip.setCellValueFactory(new PropertyValueFactory<Zapato,String>("numero"));

        TableColumn colCol = new TableColumn("Descripcion");
        colCol.setPrefWidth(114);
        colCol.setCellValueFactory(new PropertyValueFactory<Zapato,String>("descripcion"));

        TableColumn colTem = new TableColumn("Temporada");
        colTem.setPrefWidth(114);
        colTem.setCellValueFactory(new PropertyValueFactory<Zapato,String>("temporada"));

        TableColumn colPre = new TableColumn("Color");
        colPre.setPrefWidth(114);
        colPre.setCellValueFactory(new PropertyValueFactory<Zapato,String>("color"));

        TableColumn colNum = new TableColumn("Precio");
        colNum.setPrefWidth(50);
        colNum.setCellValueFactory(new PropertyValueFactory<Zapato,String>("precio"));

        tb.getColumns().addAll(colCla, colDes, colTip, colMar, colCol, colTem, colPre, colNum);
        tb.setItems(FXCollections.observableList(listZap));

        getChildren().add(tb);
    }
    
    public Zapato devolver(){
        Zapato zapa = (Zapato) tb.getSelectionModel().getSelectedItem();
        
        return zapa;
    }
}
