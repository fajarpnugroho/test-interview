package com.fslab.android.slimaaroncollection;

public interface BasePresenter<V extends BaseView> {

    void setView(V view);

    V getView();
}
