package net.klynch.base;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import dagger.ObjectGraph;

public abstract class BaseApplication extends Application implements Injectable {

    /**
     * The application's object graph.
     */
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();

        List<Object> modules = new ArrayList<Object>();
        modules.add(new ApplicationModule());
        modules.addAll(getApplicationModules());

        graph = ObjectGraph.create(modules.toArray());

        graph.inject(this);
    }

    protected abstract List<Object> getApplicationModules();

    @Override
    public final void inject(Object object) {
        graph.inject(object);
    }

    @Override
    public final ObjectGraph getGraph() {
        return graph;
    }
}
