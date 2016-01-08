package com.fslab.android.slimaaroncollection;

import com.fslab.android.slimaaroncollection.model.response.ImageEntity;
import com.fslab.android.slimaaroncollection.model.response.Images;

import java.util.List;

public interface BaseLoadingContentView extends BaseView {
    void showLoading();

    void hideLoading();

    void showImageContent(Images images);
}
