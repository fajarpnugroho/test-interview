package com.fslab.android.slimaaroncollection.home;

import com.fslab.android.slimaaroncollection.model.async.ParseImageFromHtml;
import com.fslab.android.slimaaroncollection.model.response.Images;

public class MainPresenterImp implements MainPresenter, ParseImageFromHtml.ParseImageCallback {

    public static final String IMAGES_SOURCE_URL =
            "http://www.gettyimagesgallery.com/collections/archive/slim-aarons.aspx";

    private MainView view;
    private MainInteractor interactor;

    public MainPresenterImp(MainView view) {
        this.view = view;
        this.interactor = new MainInteractorImp();
    }

    @Override
    public void fetchImages() {
        view.showLoading();

        interactor.parseImageFromHtml(IMAGES_SOURCE_URL, this);
    }

    @Override
    public void fetchImageDone(Images images) {
        view.hideLoading();
        if (images != null) {
            view.showImageContent(images);
        } else {
            view.showError();
        }
    }
}
