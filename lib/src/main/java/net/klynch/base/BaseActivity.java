package net.klynch.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.List;

import dagger.ObjectGraph;

public abstract class BaseActivity extends Activity implements Injectable {

    /**
     * The activity's object graph.
     */
    private ObjectGraph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the activity graph by .plus-ing our modules onto the application graph.
        final Application app = getApplication();
        if (app instanceof Injectable) {
            final Injectable injectable = (Injectable) app;
            graph = injectable.getGraph().plus(geActivityModules().toArray());

            // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
            graph.inject(this);
        }

        BaseApplication application = (BaseApplication) getApplication();
    }

    @Override
    public void inject(Object object) {
        graph.inject(object);
    }

    @Override
    public ObjectGraph getGraph() {
        return graph;
    }

    /**
     * Provides a list of activity modules to be injected into the graph.
     *
     * @return a list of modules.
     */
    protected abstract List<Object> geActivityModules();
}
