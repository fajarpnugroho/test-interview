package com.fslab.android.slimaaroncollection.home;

import com.fslab.android.slimaaroncollection.BasePresenter;
import com.fslab.android.slimaaroncollection.BaseView;

public interface MainPresenter extends BasePresenter {
    void setView(MainView view);

    MainView getView();

    void fetchImages();
}
