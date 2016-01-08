package com.fslab.android.slimaaroncollection.model.async;

import android.os.AsyncTask;

import com.fslab.android.slimaaroncollection.model.response.ImageEntity;
import com.fslab.android.slimaaroncollection.model.response.Images;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import timber.log.Timber;

public class ParseImageFromHtml extends AsyncTask<String, Void, Images> {

    private ParseImageCallback callback;

    public ParseImageFromHtml(ParseImageCallback callback) {
        this.callback = callback;
    }

    @Override
    protected Images doInBackground(String... params) {
        Images images = new Images(new ArrayList<ImageEntity>());

        try {
            Document doc = Jsoup.connect(params[0]).get();
            Elements relatedWraper = doc.select("div.exhibitionrepeater");
            Elements relatedImages = relatedWraper.select("img");

            for (Element image : relatedImages) {
                String imageUrl = ImageEntity.BASE_URL + image.attr("src");
                ImageEntity imageEntity = new ImageEntity(imageUrl);
                images.images.add(imageEntity);
                Timber.i("Fetch image " + imageUrl);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return images;
    }

    @Override
    protected void onPostExecute(Images images) {
        super.onPostExecute(images);
        if (callback != null) {
            callback.fetchImageDone(images);
        }
    }

    public interface ParseImageCallback {
        void fetchImageDone(Images images);
    }
}
