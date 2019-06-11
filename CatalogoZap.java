
package catalogozap;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Selx
 */
public class CatalogoZap extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        CatalogoCliente cc = new CatalogoCliente();
        primaryStage = cc;
        
        primaryStage.setTitle("Zapateria");
        primaryStage.show();
    }
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
