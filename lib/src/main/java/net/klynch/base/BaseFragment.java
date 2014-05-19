package net.klynch.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * A fragment that automatically injects itself into the parent's {@link dagger.ObjectGraph}.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Activity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).inject(this);
        }
    }

    /**
     * Helper method to get the view automatically cast as type T
     *
     * @param id  The identifier of the view
     * @param <T> The type of the view
     *
     * @return The view case as the requested type
     */
    protected <T> T getView(int id) {
        return (T) getView().findViewById(id);
    }
}