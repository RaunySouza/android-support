package com.github.android.support.ui.util;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.CheckResult;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * @author raunysouza
 */
public final class ViewUtils {
    private ViewUtils() {}

    @CheckResult
    @SuppressWarnings({ "unchecked", "UnusedDeclaration" })
    public static <T extends View> T findById(@NonNull Activity activity, @IdRes int idRes) {
        return (T) activity.findViewById(idRes);
    }

    @CheckResult
    @SuppressWarnings({ "unchecked", "UnusedDeclaration" })
    public static <T extends View> T findById(@NonNull View view, @IdRes int idRes) {
        return (T) view.findViewById(idRes);
    }

    @CheckResult
    @SuppressWarnings({ "unchecked", "UnusedDeclaration" })
    public static <T extends View> T findById(@NonNull Dialog dialog, @IdRes int idRes) {
        return (T) dialog.findViewById(idRes);
    }
}
