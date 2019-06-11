
package catalogozap;

import java.util.Optional;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import listaZap.Empleado;
import listaZap.Zapato;
import listaZap.Almacen;
import listaZap.Sucursal;
import listaZap.Venta;

/**
 *
 * @author Selx
 */
public class Principal extends Stage{
    private Zapato zp;
    private Empleado emp;
    private Almacen alm;
    private Sucursal suc;
    private Venta ven;
    private boolean nuevo=false;
    private TextField txCla, txDes, txTip, txCol, txTem, txPre, txNum, txIdE, txUsu, txCont ,txNom, txApe, txEda,
            txUbi, txNomb, txInv, txClaA, txClaS, txTel, txDir, txMar;
    private BorderPane bp = new BorderPane();
    private TitledPane tip = new TitledPane();
    private TitledPane tip2 = new TitledPane();
    private TitledPane tip3 = new TitledPane();
    private TitledPane tip4 = new TitledPane();
    private ListaCatal lic;
    private ListaEmple lie;
    private ListaAlmacen lia;
    private ListaSucur lis;
    private ListaVenta liv;
    private HBox espa = new HBox();
    private HBox botEspe = new HBox();
    private CatalogoCliente ant;
    
    public Principal(CatalogoCliente ant){
        crearComp();
        this.ant=ant;
    }
    
    public void crearComp(){
        ToolBar barr = new ToolBar();
        Button btsalir = new Button("Salir");
        Button btcatalogo = new Button("Catalogo");
        Button btempleados = new Button("Empleados");
        Button btsuc = new Button("Sucursal");
        Button btalm = new Button("Almacen");
        Button btvent = new Button("Ventas");
        
        btsalir.setOnAction(eve ->{
            Alert dialogo = new Alert(Alert.AlertType.CONFIRMATION);
            dialogo.setTitle("Advertencia");
            dialogo.setHeaderText("Salir de la administracion");
            dialogo.setContentText("¿Esta seguro de salir?");
            Optional<ButtonType> respuesta = dialogo.showAndWait();
            if(respuesta.get() == ButtonType.OK){
                ant.ocultar(false);
                this.close();
            }
        });
        
        btcatalogo.setOnAction(ev ->{
            lic = new ListaCatal();
            Catalogo();
            bp.setCenter(lic);
            bp.setBottom(null);
        });
        
        btempleados.setOnAction(ev-> {
            lie = new ListaEmple();
            Empleados();
            bp.setCenter(lie);
            bp.setBottom(null);
            
        });
        
        btsuc.setOnAction(ev ->{
            lis = new ListaSucur();
            Sucursal();
            bp.setCenter(lis);
            bp.setBottom(null);
        });
        
        btalm.setOnAction(ev ->{
            lia = new ListaAlmacen();
            Almacen();
            bp.setCenter(lia);
            bp.setBottom(null);
        });
        
        btvent.setOnAction(ev ->{
            liv = new ListaVenta();
            Ventas();
            bp.setCenter(liv);
            bp.setBottom(null);
        });
        
        espa.setMinWidth(200);
        barr.getItems().addAll(btcatalogo, btempleados, btsuc, btalm, btvent, btsalir, espa, botEspe);
        bp.setTop(barr);
        
        Scene scene = new Scene(bp, 800, 600);
        setTitle("El Zapato");
        setScene(scene);
        show();
    }
    
    public boolean valida(){
        boolean val = true;
        String cl = txCla.getText();
        String de = txDes.getText();
        String ti = txTip.getText();
        String ma = txMar.getText();
        String co = txCol.getText();
        String te = txTem.getText();
        String pr = txPre.getText();
        String nu = txNum.getText();
        if(cl == "" || de == "" || ti == "" || ma == "" || co == "" || te == "" || pr == "" || nu == ""){
            val = false;
        }
        
        if(val){
            if(nuevo){
                zp = new Zapato(cl, de, ti, ma, co, te ,pr, nu);
            }else{
                zp.setClav(cl);
                zp.setTipo(ti);
                zp.setMarca(ma);
                zp.setNumero(nu);
                zp.setDesc(de);
                zp.setTemp(te);
                zp.setColor(co);
                zp.setPrec(pr);
            }
            
        }else{
            Alert dialo = new Alert(Alert.AlertType.ERROR);
            dialo.setTitle("Error en valores");
            dialo.setHeaderText("Datos faltantes");
            dialo.show();
            val = false;
        }
        return val;
    }
    
    public boolean validaE(){
        boolean val = true;
        String id = txIdE.getText();
        String usu = txUsu.getText();
        String con = txCont.getText();
        String nom = txNom.getText();
        String ap = txApe.getText();
        String eda = txEda.getText();
        if(id == "" || nom == "" || ap == "" || eda == "" || usu=="" || con==""){
            Alert dialo = new Alert(Alert.AlertType.ERROR);
            dialo.setTitle("Error en valores");
            dialo.setHeaderText("Datos faltantes");
            dialo.show();
            val = false;
        }
        
        if(val){
            if(nuevo){
                emp = new Empleado(id, usu, con, nom, ap, eda);
            }else{
                emp.setIdEmple(id);
                emp.setUsuario(usu);
                emp.setContraseña(con);
                emp.setNombres(nom);
                emp.setApellidos(ap);
                emp.setEdad(eda);
            }
            
        }else{
            Alert dialo = new Alert(Alert.AlertType.ERROR);
            dialo.setTitle("Error en valores");
            dialo.setHeaderText("Datos faltantes");
            dialo.show();
            val = false;
        }
        return val;
    }
    
    public boolean validaA(){
        boolean val = true;
        String cl = txClaA.getText();
        String ub = txUbi.getText();
        String no = txNomb.getText();
        String in = txInv.getText();
        if(cl == "" || ub == "" || no == "" || in == ""){
            Alert dialo = new Alert(Alert.AlertType.ERROR);
            dialo.setTitle("Error en valores");
            dialo.setHeaderText("Datos faltantes");
            dialo.show();
            val = false;
        }
        
        if(val){
            if(nuevo){
                alm = new Almacen(cl, ub, no, in);
            }else{
                alm.setIdAlmacen(cl);
                alm.setUbicacion(ub);
                alm.setNombre(no);
                alm.setInventario(in);
            }
            
        }else{
            Alert dialo = new Alert(Alert.AlertType.ERROR);
            dialo.setTitle("Error en valores");
            dialo.setHeaderText("Datos faltantes");
            dialo.show();
            val = false;
        }
        return val;
    }
    
    public boolean validaS(){
        boolean val = true;
        String cl = txClaS.getText();
        String te = txTel.getText();
        String di = txDir.getText();
        if(cl == "" || te == "" || di == ""){
            Alert dialo = new Alert(Alert.AlertType.ERROR);
            dialo.setTitle("Error en valores");
            dialo.setHeaderText("Datos faltantes");
            dialo.show();
            val = false;
        }
        
        if(val){
            if(nuevo){
                suc = new Sucursal(cl, te, di);
            }else{
                suc.setIdSucursal(cl);
                suc.setTelefono(te);
                suc.setDireccion(di);
            }
            
        }else{
            Alert dialo = new Alert(Alert.AlertType.ERROR);
            dialo.setTitle("Error en valores");
            dialo.setHeaderText("Datos faltantes");
            dialo.show();
            val = false;
        }
        return val;
    }
    
    public void Catalogo(){
        tip = new TitledPane();
        tip.setText("Datos Producto");
        tip.setExpanded(false);
        tip.setVisible(false);
        GridPane gp = new GridPane();
        
        txCla = new TextField();
        txDes = new TextField();
        txTip = new TextField();
        txMar = new TextField();
        txCol = new TextField();
        txTem = new TextField();
        txPre = new TextField();
        txNum = new TextField();
        txCla.setPromptText("Clave de producto");
        txDes.setPromptText("Descripcion de producto");
        txTip.setPromptText("Tipo de producto");
        txMar.setPromptText("Marca del producto");
        txCol.setPromptText("Color de producto");
        txTem.setPromptText("Temporada de producto");
        txPre.setPromptText("Precio de producto");
        txNum.setPromptText("Numero de producto");
        
        Label cod = new Label("Clave");
        Label des = new Label("Descripcion");
        Label ti = new Label("Tipo");
        Label ma = new Label("Marca");
        Label col = new Label("Color");
        Label tem = new Label("Temporada");
        Label pre = new Label("Precio");
        Label num = new Label("Numero");
        
        Button btagregar = new Button("Agregar");
        btagregar.setOnAction(ev->{
            nuevo=true;
            bp.setBottom(tip);
            tip.setExpanded(true);
            tip.setVisible(true);
        });
        
        Button edit = new Button("Editar");
        edit.setOnAction(ev ->{
            nuevo=false;
            zp = lic.devolver();    
            if(zp!=null){
                txCla.setText(zp.getClave());
                txDes.setText(zp.getDescripcion());
                txTip.setText(zp.getTipo());
                txMar.setText(zp.getMarca());
                txCol.setText(zp.getColor());
                txTem.setText(zp.getTemporada());
                txPre.setText(zp.getPrecio());
                txNum.setText(zp.getNumero());
                bp.setBottom(tip);
                tip.setExpanded(true);
                tip.setVisible(true);
            } 
        });
        
        Button elim = new Button("Eliminar");
        elim.setOnAction(ev ->{
            nuevo=false;
            zp = lic.devolver();
            if(zp!=null){
                Alert dial = new Alert(Alert.AlertType.CONFIRMATION);
                dial.setTitle("Eliminar");
                dial.setHeaderText("Eliminar producto");
                dial.setContentText("Desea eliminar el producto?");
                Optional<ButtonType> respuesta = dial.showAndWait();
                if(respuesta.get() == ButtonType.OK){
                    listaZap.listaZap.Eliminar(zp);
                }
            }
        });
        botEspe.getChildren().clear();
        botEspe.getChildren().addAll(btagregar,edit,elim);
        
        Button agre = new Button("Aceptar");
        agre.setOnAction(ev-> {
            if(nuevo==true){
                if(valida()){
                    listaZap.listaZap.Agregar(zp);
                }
            }else{
                if(valida()){
                    listaZap.listaZap.Modificar(zp);
                }
            }
            tip.setExpanded(false);
            tip.setVisible(false);
        });
        Button canc = new Button("Cancelar");
        canc.setOnAction(ev-> {
            tip.setVisible(false);
            tip.setExpanded(false);
            
        });
        
        gp.setVgap(4);
        gp.setHgap(4);
        gp.add(cod,0,0);
        gp.add(ti,0,1);
        gp.add(ma,0,2);
        gp.add(num,0,3);
        gp.add(txCla,1,0);
        gp.add(txTip,1,1);
        gp.add(txMar,1,2);
        gp.add(txNum,1,3);
        
        gp.add(des,2,0);
        gp.add(tem,2,1);
        gp.add(col,2,2);
        gp.add(pre,2,3);
        gp.add(txDes,3,0);
        gp.add(txTem,3,1);
        gp.add(txCol,3,2);
        gp.add(txPre,3,3);
        
        gp.add(agre,4,3);
        gp.add(canc,5,3);
        tip.setContent(gp);
        
    }
    
    public void Empleados(){
        tip2 = new TitledPane();
        tip2.setText("Datos Empleado");
        tip2.setExpanded(false);
        tip2.setVisible(false);
        GridPane gp2 = new GridPane();
        
        txNom = new TextField();
        txUsu = new TextField();
        txCont = new TextField();
        txApe = new TextField();
        txEda = new TextField();
        txIdE = new TextField();
        txIdE.setPromptText("Clave de empleado");
        txUsu.setPromptText("Usuario para empleado");
        txCont.setPromptText("Contraseña para empleado");
        txNom.setPromptText("Nombre de epmpleado");
        txApe.setPromptText("Apellidos de empleado");
        txEda.setPromptText("Edad de empleado");
        
        Label idE = new Label("ID");
        Label us = new Label("Usuario");
        Label con = new Label("Contraseña");
        Label nom = new Label("Nombres");
        Label ape = new Label("Apellidos");
        Label eda = new Label("Edad");
        Label dir = new Label("Direccion");
        
        Button btagregare = new Button("Agregar");
        btagregare.setOnAction(ev->{
                nuevo=true;
                bp.setBottom(tip2);
                tip2.setExpanded(true);
                tip2.setVisible(true);
                
        });
        
        Button edit = new Button("Editar");
        edit.setOnAction(ev ->{
            nuevo=false;
            emp = lie.Devolver();
            if(emp!=null){
                txNom.setText(emp.getNombres());
                txUsu.setText(emp.getUsuario());
                txCont.setText(emp.getContraseña());
                txApe.setText(emp.getApellidos());
                txEda.setText(emp.getEdad());
                txIdE.setText(emp.getIdEmple());
                bp.setBottom(tip2);
                tip2.setExpanded(true);
                tip2.setVisible(true);
            }
        });
        
        Button elim = new Button("Eliminar");
        elim.setOnAction(ev ->{
            nuevo=false;
            emp = lie.Devolver();
            if(emp!=null){
                Alert dial = new Alert(Alert.AlertType.CONFIRMATION);
                dial.setTitle("Eliminar");
                dial.setHeaderText("Eliminar empleado");
                dial.setContentText("Desea eliminar el empleado?");
                Optional<ButtonType> respuesta = dial.showAndWait();
                if(respuesta.get() == ButtonType.OK){
                    listaZap.listaEmple.Eliminar(emp);
                }
            }
        });
        botEspe.getChildren().clear();
        botEspe.getChildren().addAll(btagregare,edit,elim);
        
        Button agre2 = new Button("Aceptar");
        agre2.setOnAction(ev-> {
            if(nuevo==true){
                if(validaE()){
                    listaZap.listaEmple.Agregar(emp);
                }
            }else{
                if(validaE()){
                    listaZap.listaEmple.Modificar(emp);
                }
            }
            tip2.setExpanded(false);
            tip2.setVisible(false);
        });
        
        Button canc2 = new Button("Cancelar");
        canc2.setOnAction(ev-> {
            tip2.setExpanded(false);
            tip2.setVisible(false);
        });
        
        gp2.setVgap(4);
        gp2.setHgap(4);
        gp2.add(idE,0,0);
        gp2.add(us,0,1);
        gp2.add(con,0,2);
        gp2.add(nom,0,3);
        gp2.add(txIdE,1,0);
        gp2.add(txUsu,1,1);
        gp2.add(txCont,1,2);
        gp2.add(txNom,1,3);
        
        gp2.add(ape,2,0);
        gp2.add(eda,2,1);
        gp2.add(txApe,3,0);
        gp2.add(txEda,3,1);
        gp2.add(agre2,2,3);
        gp2.add(canc2,3,3);
        tip2.setContent(gp2);
    }
    
    public void Sucursal(){
        tip4 = new TitledPane();
        tip4.setText("Datos Sucursal");
        tip4.setExpanded(false);
        tip4.setVisible(false);
        GridPane gp = new GridPane();
        
        txClaS = new TextField();
        txTel = new TextField();
        txDir = new TextField();
        txClaS.setPromptText("Clave de Sucursal");
        txTel.setPromptText("Telefono");
        txDir.setPromptText("Direccion");
        
        Label cod = new Label("Clave");
        Label tel = new Label("Telefono");
        Label dir = new Label("Direccion");
        
        Button btagregar = new Button("Agregar");
        btagregar.setOnAction(ev->{
            nuevo=true;
            bp.setBottom(tip4);
            tip4.setExpanded(true);
            tip4.setVisible(true);
        });
        
        Button edit = new Button("Editar");
        edit.setOnAction(ev ->{
            nuevo=false;
            suc = lis.Devolver();    
            if(alm!=null){
                txClaS.setText(suc.getIdSucursal());
                txTel.setText(suc.getTelefono());
                txDir.setText(suc.getDireccion());
                bp.setBottom(tip4);
                tip4.setExpanded(true);
                tip4.setVisible(true);
            } 
        });
        
        Button elim = new Button("Eliminar");
        elim.setOnAction(ev ->{
            nuevo=false;
            suc = lis.Devolver();
            if(suc!=null){
                Alert dial = new Alert(Alert.AlertType.CONFIRMATION);
                dial.setTitle("Eliminar");
                dial.setHeaderText("Eliminar almacen");
                dial.setContentText("Desea eliminar almacen?");
                Optional<ButtonType> respuesta = dial.showAndWait();
                if(respuesta.get() == ButtonType.OK){
                    listaZap.listaSucursal.Eliminar(suc);
                }
            }
        });
        botEspe.getChildren().clear();
        botEspe.getChildren().addAll(btagregar,edit,elim);
        
        Button agre = new Button("Aceptar");
        agre.setOnAction(ev-> {
            if(nuevo==true){
                if(validaS()){
                    listaZap.listaSucursal.Agregar(suc);
                }
            }else{
                if(validaS()){
                    listaZap.listaSucursal.Modificar(suc);
                }
            }
            tip4.setExpanded(false);
            tip4.setVisible(false);
        });
        Button canc = new Button("Cancelar");
        canc.setOnAction(ev-> {
            tip4.setVisible(false);
            tip4.setExpanded(false);
            
        });
        
        gp.setVgap(4);
        gp.setHgap(4);
        gp.add(cod,0,0);
        gp.add(tel,0,1);
        gp.add(dir,0,2);
        gp.add(agre,0,3);
        gp.add(txClaS,1,0);
        gp.add(txTel,1,1);
        gp.add(txDir,1,2);
        gp.add(canc,1,3);
        
        tip4.setContent(gp);
    }
    
    public void Almacen(){
        tip3 = new TitledPane();
        tip3.setText("Datos Almacen");
        tip3.setExpanded(false);
        tip3.setVisible(false);
        GridPane gp = new GridPane();
        
        txClaA = new TextField();
        txUbi = new TextField();
        txNomb = new TextField();
        txInv = new TextField();
        txClaA.setPromptText("Clave de Almacen");
        txUbi.setPromptText("Ubicacion");
        txNomb.setPromptText("Nombre");
        txInv.setPromptText("Numero de Inventario");
        
        Label cod = new Label("Clave");
        Label ubi = new Label("Ubicacion");
        Label nom = new Label("Nombre");
        Label inv = new Label("Inventario");
        
        Button btagregar = new Button("Agregar");
        btagregar.setOnAction(ev->{
            nuevo=true;
            bp.setBottom(tip3);
            tip3.setExpanded(true);
            tip3.setVisible(true);
        });
        
        Button edit = new Button("Editar");
        edit.setOnAction(ev ->{
            nuevo=false;
            alm = lia.Devolver();    
            if(alm!=null){
                txClaA.setText(alm.getIdAlmacen());
                txUbi.setText(alm.getUbicacion());
                txNomb.setText(alm.getNombre());
                txInv.setText(alm.getInventario());
                bp.setBottom(tip3);
                tip3.setExpanded(true);
                tip3.setVisible(true);
            } 
        });
        
        Button elim = new Button("Eliminar");
        elim.setOnAction(ev ->{
            nuevo=false;
            alm = lia.Devolver();
            if(alm!=null){
                Alert dial = new Alert(Alert.AlertType.CONFIRMATION);
                dial.setTitle("Eliminar");
                dial.setHeaderText("Eliminar almacen");
                dial.setContentText("Desea eliminar almacen?");
                Optional<ButtonType> respuesta = dial.showAndWait();
                if(respuesta.get() == ButtonType.OK){
                    listaZap.listaAlmacen.Eliminar(alm);
                }
            }
        });
        botEspe.getChildren().clear();
        botEspe.getChildren().addAll(btagregar,edit,elim);
        
        Button agre = new Button("Aceptar");
        agre.setOnAction(ev-> {
            if(nuevo==true){
                if(validaA()){
                    listaZap.listaAlmacen.Agregar(alm);
                }
            }else{
                if(validaA()){
                    listaZap.listaAlmacen.Modificar(alm);
                }
            }
            tip3.setExpanded(false);
            tip3.setVisible(false);
        });
        Button canc = new Button("Cancelar");
        canc.setOnAction(ev-> {
            tip3.setVisible(false);
            tip3.setExpanded(false);
            
        });
        
        gp.setVgap(4);
        gp.setHgap(4);
        gp.add(cod,0,0);
        gp.add(ubi,0,1);
        gp.add(nom,0,2);
        gp.add(inv,0,3);
        gp.add(txClaA,1,0);
        gp.add(txUbi,1,1);
        gp.add(txNomb,1,2);
        gp.add(txInv,1,3);
        
        gp.add(agre,2,3);
        gp.add(canc,3,3);
        tip3.setContent(gp);
    }
    
    public void Ventas(){
        
        Button elim = new Button("Eliminar");
        elim.setOnAction(ev ->{
            nuevo=false;
            ven = liv.Devolver();
            if(ven!=null){
                Alert dial = new Alert(Alert.AlertType.CONFIRMATION);
                dial.setTitle("Eliminar");
                dial.setHeaderText("Eliminar venta");
                dial.setContentText("Desea eliminar venta?");
                Optional<ButtonType> respuesta = dial.showAndWait();
                if(respuesta.get() == ButtonType.OK){
                    listaZap.listaVent.Eliminar(ven);
                }
            }
        });
        botEspe.getChildren().clear();
        botEspe.getChildren().addAll(elim);

        
    }
    
}
