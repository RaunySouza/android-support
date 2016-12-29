package com.github.raunysouza.android.support.ui.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * @author raunysouza
 */
public abstract class EndlessScrollListener extends RecyclerView.OnScrollListener {

    /**
     * The total number of items in the dataset after the last load
     */
    private int mPreviousTotal;
    /**
     *  True if we are still waiting for the last set of data to load
     */
    private boolean mLoading = true;

    private int mCurrentPage = 1;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (!(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            throw new IllegalStateException("Unsupported LayoutManager");
        }

        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = linearLayoutManager.getItemCount();
        int firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

        if (mLoading) {
            if (totalItemCount != mPreviousTotal) {
                mLoading = false;
                mPreviousTotal = totalItemCount;
            }
        }

        if (!mLoading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + getVisibleThreshold())) {
            // End has been reached, loading more
            mCurrentPage++;
            mLoading = true;
            onLoadItems(mCurrentPage);
        }
    }

    public void reset() {
        mPreviousTotal = 0;
        mCurrentPage = 1;
    }

    /**
     * The minimum amount of items to have below your current scroll position before loading more
     */
    protected int getVisibleThreshold() {
        return 5;
    }

    public abstract void onLoadItems(int currentPage);
}
