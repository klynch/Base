package net.klynch.base;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * The application module provides a {@link com.squareup.otto.Bus} to be shared across the application
 */
@Module(
        complete = false,
        library = true,
        injects = {})
public class ApplicationModule {

    /**
     * Provides an event bus for the entire application.
     *
     * @return An event bus used across the entire application.
     */
    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }
}
