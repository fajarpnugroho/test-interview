package com.fslab.android.slimaaroncollection.home;

import com.fslab.android.slimaaroncollection.BasePresenter;
import com.fslab.android.slimaaroncollection.BaseView;

public interface MainPresenter<V extends BaseView> extends BasePresenter<V> {
    void fetchImages();
}
