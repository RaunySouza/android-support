package com.github.android.support.ui.databinding.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author raunysouza
 */
public abstract class DataBindingAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter<DataBindingViewHolder<B>> {

    private Context mContext;
    private List<T> mItems = new ArrayList<>();
    @LayoutRes
    private int mLayoutRes;

    public DataBindingAdapter(Context context, List<T> items, @LayoutRes int layoutRes) {
        this(context, layoutRes);
        mItems = items;
    }

    public DataBindingAdapter(Context context, @LayoutRes int layoutRes) {
        this.mContext = context;
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
    public long getItemId(int position) {
        return getItemIdSupplier(mItems.get(position));
    }

    protected long getItemIdSupplier(T item) {
        return RecyclerView.NO_ID;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public boolean isEmpty() {
        return mItems.isEmpty();
    }

    public List<T> getItems() {
        return mItems;
    }

    public void setItems(@NonNull List<T> items) {
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

    @NonNull
    protected Context getContext() {
        return mContext;
    }
}
