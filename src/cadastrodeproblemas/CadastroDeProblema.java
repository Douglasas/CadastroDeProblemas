package cadastrodeproblemas;

import cadastrodeproblemas.visao.MenuInicial;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Douglas
 * @date 03/09/2016
 */
public class CadastroDeProblema extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MenuInicial.exibirMenuInicial();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane principal = FXMLLoader.load( getClass().getResource("visao/menu_principal.fxml") );
        Scene scene = new Scene(principal);
        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
    
}
