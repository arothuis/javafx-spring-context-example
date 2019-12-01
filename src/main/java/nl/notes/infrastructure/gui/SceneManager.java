package nl.notes.infrastructure.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.URL;

/**
 * This class is highly static.
 * Perhaps there should be only one of it.
 *
 * It is responsible for configuring the stage
 * and showing a certain scene on the stage.
 */
public class SceneManager {
    private static final String OVERVIEW_SCENE = "overview";
    private static final String WELCOME_PAGE = "welcome";

    private static ApplicationContext context;
    private static Scene scene;

    public static void start(ApplicationContext ctx, Stage stage) throws IOException {
        // Setup Spring Context for dependency injection
        context = ctx;

        // Start on the welcome scene
        scene = new Scene(loadFXML(WELCOME_PAGE));
        stage.setScene(scene);

        // Set values for window (stage) and show it
        stage.setTitle("Notes");
        stage.setMinWidth(640);
        stage.setMinHeight(480);
        stage.show();
    }

    public static void showOverview() throws IOException {
        scene.setRoot(loadFXML(OVERVIEW_SCENE));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        // Find the FXML in the resources directory matching the location of this class
        URL resource = SceneManager.class.getResource(fxml + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(resource);

        // Use the Spring dependency injection container for Beans
        fxmlLoader.setControllerFactory(context::getBean);

        return fxmlLoader.load();
    }
}
