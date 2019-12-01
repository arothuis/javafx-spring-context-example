package nl.notes.infrastructure.gui.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import nl.notes.application.example.ExampleServiceInterface;
import nl.notes.domain.example.Example;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class OverviewScene {
    private ExampleServiceInterface service;

    @FXML
    private TextField inputTitle;

    @FXML
    private ListView<String> exampleList;

    public OverviewScene(ExampleServiceInterface service) {
        this.service = service;
    }

    public void initialize() {
        this.loadExamples();
    }

    private void loadExamples() {
        ObservableList<String> items = this.exampleList.getItems();

        // Clear items
        items.clear();

        // Add examples as items
        Collection<Example> examples = this.service.listExamples();
        for (Example example : examples) {
            items.add(example.getTitle());
        }
    }

    public void handleDelete() {
        String selection = this.exampleList
                .getSelectionModel()
                .getSelectedItem();

        if (selection == null) {
            return;
        }

        this.service.remove(new Example(selection));
        this.loadExamples();
    }

    public void handleAdd() {
        String title = this.inputTitle
                .getCharacters()
                .toString();

        if (title.isBlank()) {
            return;
        }

        this.service.save(new Example(title));
        this.loadExamples();
    }
}
