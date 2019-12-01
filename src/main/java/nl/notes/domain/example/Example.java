package nl.notes.domain.example;

/**
 * A simple Domain class: Example.
 * It only contains a title (a string).
 */
public class Example {
    private String title;

    public Example(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
