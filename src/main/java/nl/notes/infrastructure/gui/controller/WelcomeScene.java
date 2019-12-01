package nl.notes.infrastructure.gui.controller;

import javafx.fxml.FXML;
import nl.notes.infrastructure.gui.SceneManager;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class WelcomeScene {
    @FXML
    private void goToOverview() throws IOException {
        SceneManager.showOverview();
    }
}
