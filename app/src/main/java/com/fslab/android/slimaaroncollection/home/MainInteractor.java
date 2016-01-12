package com.fslab.android.slimaaroncollection.home;

import com.fslab.android.slimaaroncollection.model.async.ParseImageFromHtml;

public interface MainInteractor {
    void parseImageFromHtml(String url, ParseImageFromHtml.ParseImageCallback callback);
}
