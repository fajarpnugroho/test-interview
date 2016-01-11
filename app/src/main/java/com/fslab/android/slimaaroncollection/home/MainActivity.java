package com.fslab.android.slimaaroncollection.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.GridView;
import android.widget.Toast;

import com.fslab.android.slimaaroncollection.BaseActivity;
import com.fslab.android.slimaaroncollection.R;
import com.fslab.android.slimaaroncollection.model.response.Images;
import com.fslab.android.slimaaroncollection.util.Constant;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView,
        SwipeRefreshLayout.OnRefreshListener {

    public static final String EXTRA_IMAGES = "extra_images";

    @Bind(R.id.swipe_refresh_layout) SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.grid_view) GridView contentView;

    private Images images;
    private MainPresenter presenter;
    private GridImagesAdapter adapter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        swipeRefreshLayout.setOnRefreshListener(this);

        adapter = new GridImagesAdapter(this);

        presenter = new MainPresenterImp();
        presenter.setView(this);

        if (savedInstanceState != null) {
            String jsonImages = savedInstanceState.getString(MainActivity.EXTRA_IMAGES);
            this.images = Constant.GSON.fromJson(jsonImages, Images.class);
            hideLoading();
            showImageContent(images);
        } else {
            presenter.fetchImages();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (images != null) {
            outState.putString(EXTRA_IMAGES, Constant.GSON.toJson(images));
        }
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showImageContent(Images images) {
        this.images = images;
        adapter.clear();
        adapter.addAll(images.images);

        contentView.setAdapter(adapter);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Fail to get images", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        presenter.fetchImages();
    }
}
