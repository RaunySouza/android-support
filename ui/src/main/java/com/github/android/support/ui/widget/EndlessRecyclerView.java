package com.github.android.support.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

import com.github.android.support.ui.recyclerview.EndlessScrollListener;

/**
 * @author rauny.souza
 */
public class EndlessRecyclerView extends RecyclerView {

    private EndlessScrollListener mListener;

    public EndlessRecyclerView(Context context) {
        this(context, null);
    }

    public EndlessRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EndlessRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (getLayoutManager() instanceof StaggeredGridLayoutManager) {
            addOnScrollListener(mListener = new EndlessScrollListener((StaggeredGridLayoutManager) getLayoutManager()));
        } else if (getLayoutManager() instanceof LinearLayoutManager) {
            addOnScrollListener(mListener = new EndlessScrollListener((LinearLayoutManager) getLayoutManager()));
        } else if (getLayoutManager() instanceof GridLayoutManager) {
            addOnScrollListener(mListener = new EndlessScrollListener((GridLayoutManager) getLayoutManager()));
        }
    }

    public void setOnLoadMoreListener(EndlessScrollListener.OnLoadMoreListener onLoadMoreListener) {
        mListener.setOnLoadMoreListener(onLoadMoreListener);
    }

    public void reset() {
        mListener.resetState();
    }
}
