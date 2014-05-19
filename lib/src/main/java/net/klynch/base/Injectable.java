package net.klynch.base;

import dagger.ObjectGraph;

/**
 * Identifies
 */
public interface Injectable {
    public void inject(Object object);

    public ObjectGraph getGraph();
}
