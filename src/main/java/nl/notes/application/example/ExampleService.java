package nl.notes.application.example;

import nl.notes.domain.example.Example;
import nl.notes.domain.example.port.ExampleStorage;

import java.util.Collection;

/**
 * The goal of this application service is to
 * orchestrate infrastructural and other application services.
 *
 * In this example, it is merely an intermediary between the
 * high level abstractions (domain) and low level abstractions (infrastructure).
 */
public class ExampleService implements ExampleServiceInterface {
    private ExampleStorage storage;

    public ExampleService(ExampleStorage storage) {
        this.storage = storage;
    }

    @Override
    public void save(Example example) {
        this.storage.save(example);
    }

    @Override
    public void remove(Example example) {
        this.storage.remove(example);
    }

    @Override
    public Collection<Example> listExamples() {
        return this.storage.list();
    }
}
