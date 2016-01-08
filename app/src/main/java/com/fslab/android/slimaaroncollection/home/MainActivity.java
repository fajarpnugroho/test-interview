package com.fslab.android.slimaaroncollection.home;

import android.os.Bundle;

import com.fslab.android.slimaaroncollection.BaseActivity;
import com.fslab.android.slimaaroncollection.R;
import com.fslab.android.slimaaroncollection.model.response.Images;
import com.fslab.android.slimaaroncollection.util.Constant;
import com.fslab.android.slimaaroncollection.view.LoadingGridContentView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity<V extends MainView> extends BaseActivity<V> implements MainView {

    public static final String EXTRA_IMAGES = "extra_images";

    @Bind(R.id.loading_grid_content_view) LoadingGridContentView contentView;

    private Images images;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        MainPresenter presenter = new MainPresenterImp();
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
        contentView.onLoading(true);
    }

    @Override
    public void hideLoading() {
        contentView.onLoading(false);
    }

    @Override
    public void showImageContent(Images images) {
        this.images = images;
        contentView.setAdapter(new GridImagesAdapter(this, images.images));
    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }
}
