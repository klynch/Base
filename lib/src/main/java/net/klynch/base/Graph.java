package net.klynch.base;

import android.app.Activity;

import dagger.ObjectGraph;

public class Graph {

    public static ObjectGraph from(Activity activity) {
        BaseApplication application = (BaseApplication) activity.getApplication();
        return application.getGraph();
    }
}