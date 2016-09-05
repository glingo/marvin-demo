package marvin.demo;

import com.marvin.bundle.javafx.JavaFXApplication;
import com.marvin.component.kernel.Kernel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import marvin.demo.app.AppKernel;


/**
 *
 * @author Dr.Who
 */
public class RunJavaFX extends Application {
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Kernel kernel = new AppKernel(true);
        JavaFXApplication app = new JavaFXApplication(kernel);
//        app.display(stage, "test");
    }
}
