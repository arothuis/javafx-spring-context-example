package nl.notes;

import javafx.application.Application;
import javafx.stage.Stage;
import nl.notes.infrastructure.configuration.AppConfig;
import nl.notes.infrastructure.gui.SceneManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * You can not simply run "start" from your IDE.
 *
 * We are using the JavaFX plugin to circumvent the need for
 * module-info.java. You need to use maven, your terminal (cli)
 * or your IDE to run: mvn clean javafx:run
 *
 */
public class Main extends Application {
    public void start(Stage stage) throws IOException {
        // Setup Spring Context for dependency injection (DI)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Configure and wire up Beans in AppConfig
        context.register(AppConfig.class);
        context.refresh();

        // Configure and boot up GUI through SceneManager
        SceneManager.start(context, stage);
    }
}