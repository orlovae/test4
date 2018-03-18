package ru.aleksandrorlov.test4.view.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import ru.aleksandrorlov.test4.R;
import ru.aleksandrorlov.test4.model.YandexPictureModel;

import static ru.aleksandrorlov.test4.Constant.COMPRESSION_PICTURE;
import static ru.aleksandrorlov.test4.Constant.EXCEPTION_NULL_LIST;

/**
 * Created by alex on 17.03.18.
 */

public class YandexPictureAdapter extends
        RecyclerView.Adapter<YandexPictureAdapter.ViewHolder> {

    private final Context context;

    private Point screenSize;
    private List<YandexPictureModel> yandexPictureModelList;

    @Inject
    public YandexPictureAdapter(Context context) {
        this.context = context;
        this.yandexPictureModelList = Collections.emptyList();
        this.screenSize = null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        YandexPictureModel yandexPictureModel = yandexPictureModelList.get(position);

        holder.textViewRequest.setText(yandexPictureModel.getRequest());

        String url = yandexPictureModel.getUrl();
        if (url.equals("")) {
            url = Integer.toString(R.drawable.error_download_image);
        }

        Picasso.with(context)
                .load(url)
                .resize((int)Math.round(screenSize.x * COMPRESSION_PICTURE),
                        (int)Math.round(screenSize.y * COMPRESSION_PICTURE))
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_download_image)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (yandexPictureModelList == null) ? 0 : yandexPictureModelList.size();
    }

    public void setScreenSize(Point screenSize) {
        this.screenSize = screenSize;
    }

    public void setYandexPictureModelCollection(Collection<YandexPictureModel> yandexPictureModelCollection) {
        this.validateUsersCollection(yandexPictureModelCollection);
        this.yandexPictureModelList = (List<YandexPictureModel>) yandexPictureModelCollection;
        this.notifyDataSetChanged();
    }

    private void validateUsersCollection(Collection<YandexPictureModel> yandexPictureModelCollection) {
        if (yandexPictureModelCollection == null) {
            throw new IllegalArgumentException(EXCEPTION_NULL_LIST);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRequest;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            textViewRequest = (TextView) itemView.findViewById(R.id.text_view_request);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}
