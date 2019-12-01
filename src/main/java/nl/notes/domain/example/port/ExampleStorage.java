package nl.notes.domain.example.port;

import nl.notes.domain.example.Example;

import java.util.Collection;

/**
 * Our domain is abstract and only requires that
 * Examples need to be stored somewhere.
 *
 * The actual implementation is done
 * as part of the (concrete) infrastructure.
 */
public interface ExampleStorage {
    void save(Example example);
    void remove(Example example);
    Collection<Example> list();
}
