package com.github.android.support.ui.animation;

import android.view.animation.Animation;

/**
 * @author rauny.souza
 */
public abstract class AnimationListenerAdapter implements Animation.AnimationListener {
    @Override
    public void onAnimationStart(Animation animation) {}

    @Override
    public void onAnimationEnd(Animation animation) {}

    @Override
    public void onAnimationRepeat(Animation animation) {}
}
