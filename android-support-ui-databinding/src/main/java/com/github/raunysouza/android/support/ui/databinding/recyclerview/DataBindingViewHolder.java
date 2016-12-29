package com.github.raunysouza.android.support.ui.databinding.recyclerview;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * @author raunysouza
 */
public class DataBindingViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private B mBinding;

    public DataBindingViewHolder(B binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public B getBinding() {
        return mBinding;
    }

}
