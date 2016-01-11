package com.fslab.android.slimaaroncollection.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.fslab.android.slimaaroncollection.R;
import com.fslab.android.slimaaroncollection.model.response.ImageEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GridImagesAdapter extends BaseAdapter {

    private List<ImageEntity> images = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public GridImagesAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void addAll(List<ImageEntity> images) {
        this.images.addAll(images);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public ImageEntity getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.view_item_image_grid, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.bind(parent.getContext(), getItem(position).url);
        return convertView;
    }

    public void clear() {
        images.clear();
    }

    static class ViewHolder {

        @Bind(R.id.image_view) ImageView imageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void bind(Context context, String image) {
            Picasso.with(context)
                    .load(image)
                    .resize(150, 150)
                    .into(imageView);
        }
    }
}
