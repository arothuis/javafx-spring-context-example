package nl.notes.infrastructure.configuration;

import nl.notes.application.example.ExampleService;
import nl.notes.application.example.ExampleServiceInterface;
import nl.notes.domain.example.Example;
import nl.notes.domain.example.port.ExampleStorage;
import nl.notes.infrastructure.gui.controller.OverviewScene;
import nl.notes.infrastructure.gui.controller.WelcomeScene;
import nl.notes.infrastructure.storage.InMemoryExampleStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * The AppConfig uses Spring's Context annotations.
 *
 * These create classes for us and (automatically) wires
 * up the required dependencies.
 */
@Configuration
public class AppConfig {
    @Bean
    public ExampleStorage exampleStorage() {
        ExampleStorage storage = new InMemoryExampleStorage();

        // Prepopulate in memory storage to fake persistence
        storage.save(new Example("Hello world"));
        storage.save(new Example("Hey there"));
        storage.save(new Example("Bye"));

        return storage;
    }

    @Bean
    public ExampleServiceInterface exampleService(ExampleStorage storage) {
        return new ExampleService(storage);
    }

    @Bean
    @Scope("prototype")
    public WelcomeScene welcome() {
        return new WelcomeScene();
    }

    @Bean
    @Scope("prototype")
    public OverviewScene overview(ExampleServiceInterface service) {
        return new OverviewScene(service);
    }
}

