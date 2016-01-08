package com.fslab.android.slimaaroncollection.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.fslab.android.slimaaroncollection.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoadingView extends FrameLayout {

    @Bind(R.id.progress_bar) ProgressBar progressBar;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.view_loading, this);
        ButterKnife.bind(this);
    }

    public void show() {
        progressBar.setVisibility(VISIBLE);
    }

    public void hide() {
        progressBar.setVisibility(GONE);
    }
}
