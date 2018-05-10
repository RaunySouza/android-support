package com.github.android.support.ui.databinding.util;

import android.databinding.BindingAdapter;
import android.view.View;

import com.github.android.support.ui.widget.LoaderLayout;

/**
 * @author rauny.souza
 */
public class UiDataBindingAdapterUtils {
    private UiDataBindingAdapterUtils() {
        throw new UnsupportedOperationException("No instances!");
    }

    @BindingAdapter("loader_state")
    public static void loaderSetState(LoaderLayout loaderLayout, int state) {
        loaderLayout.setState(state);
    }

    @BindingAdapter("loader_message")
    public static void loaderSetMessage(LoaderLayout loaderLayout, CharSequence message) {
        loaderLayout.setMessage(message);
    }

    @BindingAdapter("loader_actionButtonText")
    public static void loaderSetActionButtonText(LoaderLayout loaderLayout, CharSequence text) {
        loaderLayout.setActionButtonText(text);
    }

    @BindingAdapter("loader_showActionButton")
    public static void loaderSetShowActionButton(LoaderLayout loaderLayout, boolean value) {
        loaderLayout.setShowActionButton(value);
    }

    @BindingAdapter("loader_buttonAction")
    public static void loaderSetAction(LoaderLayout loaderLayout, View.OnClickListener action) {
        if (action != null) {
            loaderLayout.setAction(action);
        }
    }
}
