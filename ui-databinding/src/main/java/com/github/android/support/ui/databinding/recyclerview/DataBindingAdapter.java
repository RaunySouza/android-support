package com.github.android.support.ui.databinding.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.List;

/**
 * @author raunysouza
 */
public abstract class DataBindingAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter<DataBindingViewHolder<B>> {

    private Context mContext;
    private List<T> mItems;
    @LayoutRes
    private int mLayoutRes;

    public DataBindingAdapter(Context context, List<T> items, @LayoutRes int layoutRes) {
        this.mContext = context;
        this.mItems = items;
        this.mLayoutRes = layoutRes;
    }

    @Override
    public DataBindingViewHolder<B> onCreateViewHolder(ViewGroup parent, int viewType) {
        B binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), mLayoutRes, parent, false);
        return new DataBindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(DataBindingViewHolder<B> holder, int position) {
        T item = mItems.get(position);
        onAttachBinding(holder.getBinding(), item);
    }

    protected abstract void onAttachBinding(B binding, T item);

    @Override
    public int getItemCount() {
        if (mItems == null) {
            return 0;
        }
        return mItems.size();
    }

    @Nullable
    public List<T> getItems() {
        return mItems;
    }

    public void setItems(List<T> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public void addItem(T item) {
        if (mItems != null) {
            int index = mItems.size();
            mItems.add(item);
            notifyItemInserted(index);
        }
    }

    public void addAll(Collection<T> items) {
        if (mItems != null) {
            int index = mItems.size();
            mItems.addAll(items);
            notifyItemRangeInserted(index, items.size());
        }
    }

    public void removeItem(T item) {
        if (mItems != null) {
            int index = mItems.indexOf(item);
            mItems.remove(index);
            notifyItemRemoved(index);
        }
    }
}
