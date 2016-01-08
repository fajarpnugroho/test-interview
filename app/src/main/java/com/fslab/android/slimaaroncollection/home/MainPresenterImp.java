package com.fslab.android.slimaaroncollection.home;

import com.fslab.android.slimaaroncollection.model.async.ParseImageFromHtml;
import com.fslab.android.slimaaroncollection.model.response.Images;

public class MainPresenterImp<V extends MainView> implements MainPresenter<V>,
        ParseImageFromHtml.ParseImageCallback {

    public static final String IMAGES_SOURCE_URL =
            "http://www.gettyimagesgallery.com/collections/archive/slim-aarons.aspx";

    private V view;

    public MainPresenterImp() {}

    @Override
    public void setView(V view) {
        this.view = view;
    }

    @Override
    public V getView() {
        return view;
    }

    @Override
    public void fetchImages() {
        if (getView() == null) {
            throw new IllegalStateException("View still null.");
        }

        getView().showLoading();

        new ParseImageFromHtml(this).execute(IMAGES_SOURCE_URL);
    }

    @Override
    public void fetchImageDone(Images images) {
        getView().hideLoading();
        if (images.images.size() > 0) {
            getView().showImageContent(images);
        }
    }
}
