package com.fslab.android.slimaaroncollection.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;

import com.fslab.android.slimaaroncollection.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoadingGridContentView extends FrameLayout {

    @Bind(R.id.loading_view) LoadingView loadingView;
    @Bind(R.id.grid_view) GridView gridView;

    public LoadingGridContentView(Context context) {
        this(context, null);
    }

    public LoadingGridContentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingGridContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater.from(context).inflate(R.layout.view_loading_grid_content, this);

        ButterKnife.bind(this);

        init();
    }

    private void init() {
        gridView.setVisibility(GONE);
    }

    public void onLoading(boolean loading) {
        if (loading) {
            loadingView.show();
        } else {
            loadingView.hide();
        }
    }

    public void setAdapter(BaseAdapter adapter) {
        gridView.setAdapter(adapter);
        gridView.setVisibility(VISIBLE);
    }
}
