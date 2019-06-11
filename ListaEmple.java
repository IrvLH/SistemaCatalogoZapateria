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
import listaZap.Empleado;
import listaZap.Zapato;
import listaZap.listaEmple;

/**
 *
 * @author Selx
 */
public class ListaEmple extends Pane{
    private TableView tb = new TableView();
    
    public ListaEmple(){
        componentes();
    }
    
    public void componentes(){
        List<Empleado> listEmp = listaEmple.Lista();

        TableColumn colId = new TableColumn("ID");
        colId.setPrefWidth(135);
        colId.setCellValueFactory(new PropertyValueFactory<Zapato,String>("idEmple"));

        TableColumn colUsu = new TableColumn("Usuario");
        colUsu.setPrefWidth(135);
        colUsu.setCellValueFactory(new PropertyValueFactory<Zapato,String>("usuario"));
        
        TableColumn colCont = new TableColumn("Contraseña");
        colCont.setPrefWidth(135);
        colCont.setCellValueFactory(new PropertyValueFactory<Zapato,String>("contraseña"));

        TableColumn colNom = new TableColumn("Nombre");
        colNom.setPrefWidth(135);
        colNom.setCellValueFactory(new PropertyValueFactory<Zapato,String>("nombres"));

        TableColumn colApe = new TableColumn("Apellidos");
        colApe.setPrefWidth(135);
        colApe.setCellValueFactory(new PropertyValueFactory<Zapato,String>("apellidos"));

        TableColumn colEda = new TableColumn("Edad");
        colEda.setPrefWidth(135);
        colEda.setCellValueFactory(new PropertyValueFactory<Zapato,String>("edad"));

        tb.getColumns().addAll(colId, colUsu, colCont, colNom, colApe, colEda);
        tb.setItems(FXCollections.observableList(listEmp));

        getChildren().add(tb);
    }
    
    public Empleado Devolver(){
        Empleado emple = (Empleado) tb.getSelectionModel().getSelectedItem();
        return emple;
    }
}
