package nl.notes.application.example;

import nl.notes.domain.example.Example;

import java.util.Collection;

/**
 * This interface could be left out.
 *
 * Its only use case would be when swapping
 * out the actual service when testing dependent units.
 */
public interface ExampleServiceInterface {
    void save(Example example);
    void remove(Example example);
    Collection<Example> listExamples();
}
