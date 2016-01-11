package com.fslab.android.slimaaroncollection;

import com.fslab.android.slimaaroncollection.model.response.Images;

public interface BaseLoadingContentView extends BaseView {
    void showLoading();

    void hideLoading();

    void showImageContent(Images images);

    void showError();
}
