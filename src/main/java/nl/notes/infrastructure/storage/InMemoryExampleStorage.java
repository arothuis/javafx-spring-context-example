package nl.notes.infrastructure.storage;

import nl.notes.domain.example.Example;
import nl.notes.domain.example.port.ExampleStorage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete implementation for a storage.
 */
public class InMemoryExampleStorage implements ExampleStorage {
    private Map<String, Example> notes = new HashMap<>();

    @Override
    public void save(Example example) {
        this.notes.put(example.getTitle(), example);
    }

    @Override
    public void remove(Example example) {
        this.notes.remove(example.getTitle());
    }

    @Override
    public Collection<Example> list() {
        return this.notes.values();
    }
}
