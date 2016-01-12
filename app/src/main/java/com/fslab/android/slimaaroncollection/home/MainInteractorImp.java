package com.fslab.android.slimaaroncollection.home;

import com.fslab.android.slimaaroncollection.model.async.ParseImageFromHtml;

public class MainInteractorImp implements MainInteractor {

    @Override
    public void parseImageFromHtml(String url, ParseImageFromHtml.ParseImageCallback callback) {
        new ParseImageFromHtml(callback).execute(url);
    }
}
