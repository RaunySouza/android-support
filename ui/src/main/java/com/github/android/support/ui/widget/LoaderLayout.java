package com.github.android.support.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.android.support.ui.R;
import com.github.android.support.ui.util.ViewUtils;

/**
 * @author rauny.souza
 */
public class LoaderLayout extends RelativeLayout {

    public static final int STATE_LOADED = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_ERROR = 2;

    private TextView mMessageTextView;
    private Button mActionButton;
    private ProgressBar mProgressBar;
    private View mContainer;

    private int mState;
    private boolean mShowActionButton;

    public LoaderLayout(Context context) {
        this(context, null);
    }

    public LoaderLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoaderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoaderLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr, defStyleRes);
    }

    private void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.LoaderLayout, defStyleAttr, defStyleRes);

        inflate(getContext(), R.layout.view_loader_layout, this);
        mMessageTextView = ViewUtils.findById(this, R.id.loader_message);
        mActionButton = ViewUtils.findById(this, R.id.loader_action);
        mProgressBar = ViewUtils.findById(this, R.id.loader_progress_bar);
        mContainer = ViewUtils.findById(this, R.id.loader_container);

        String message = "";
        if (typedArray.hasValue(R.styleable.LoaderLayout_loader_message)) {
            message = typedArray.getString(R.styleable.LoaderLayout_loader_message);
        }

        String actionButtonText = typedArray.getString(R.styleable.LoaderLayout_loader_actionButtonText);
        mShowActionButton = typedArray.getBoolean(R.styleable.LoaderLayout_loader_showActionButton, true);
        mState = typedArray.getInt(R.styleable.LoaderLayout_loader_state, STATE_LOADED);

        mMessageTextView.setText(message);
        if (actionButtonText != null) {
            mActionButton.setText(actionButtonText);
        }
        if (!mShowActionButton) {
            mActionButton.setVisibility(GONE);
        }

        typedArray.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 3) {
            throw new IllegalStateException("LoaderLayout can host only one direct child");
        }
        applyState();
    }

    private void applyState() {
        switch (mState) {
            case STATE_LOADED:
                for (int i = 0; i < getChildCount(); i++) {
                    View child = getChildAt(i);
                    if (isInternalChild(child.getId())) {
                        child.setVisibility(GONE);
                    } else {
                        child.setVisibility(VISIBLE);
                    }
                }
                break;
            case STATE_LOADING:
                for (int i = 0; i < getChildCount(); i++) {
                    View child = getChildAt(i);
                    if (isInternalChild(child.getId())) {
                        mProgressBar.setVisibility(VISIBLE);
                        mMessageTextView.setVisibility(VISIBLE);
                        mContainer.setVisibility(VISIBLE);
                        mActionButton.setVisibility(GONE);
                    } else {
                        child.setVisibility(GONE);
                    }
                }
                break;
            case STATE_ERROR:
                for (int i = 0; i < getChildCount(); i++) {
                    View child = getChildAt(i);
                    if (isInternalChild(child.getId())) {
                        mProgressBar.setVisibility(GONE);
                        mMessageTextView.setVisibility(VISIBLE);
                        mContainer.setVisibility(VISIBLE);
                        if (mShowActionButton) {
                            mActionButton.setVisibility(VISIBLE);
                        }
                    } else {
                        child.setVisibility(GONE);
                    }
                }
                break;
        }
    }

    private boolean isInternalChild(int id) {
        return id == R.id.loader_action ||
                id == R.id.loader_message ||
                id == R.id.loader_container ||
                id == R.id.loader_progress_bar;
    }

    public int getState() {
        return mState;
    }

    public void setState(int state) {
        if (state != mState) {
            mState = state;
            applyState();
        }
    }

    public void setAction(OnClickListener action) {
        mActionButton.setOnClickListener(action);
    }

    public void setActionButtonText(CharSequence text) {
        mActionButton.setText(text);
    }

    public void setMessage(CharSequence text) {
        mMessageTextView.setText(text);
    }

    public void setShowActionButton(boolean value) {
        mShowActionButton = value;
        applyState();
    }
}
