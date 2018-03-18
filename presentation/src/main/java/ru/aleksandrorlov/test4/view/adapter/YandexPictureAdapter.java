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

import java.util.List;

import ru.aleksandrorlov.test4.R;
import ru.aleksandrorlov.test4.model.YandexPictureModel;

import static ru.aleksandrorlov.test4.Constant.COMPRESSION_PICTURE;

/**
 * Created by alex on 17.03.18.
 */

public class RecyclerViewDialogFragment extends
        RecyclerView.Adapter<RecyclerViewDialogFragment.ViewHolder>
{
    private final Context context;
    private final List<YandexPictureModel> yandexPictureModelList;
    private final Point screenSize;

    public RecyclerViewDialogFragment(Context context,
                                      List<YandexPictureModel> yandexPictureModelList,
                                      Point screenSize) {
        this.context = context;
        this.yandexPictureModelList = yandexPictureModelList;
        this.screenSize = screenSize;
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

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRequest;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            textViewRequest = (TextView) itemView.findViewById(R.id.text_view_request);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);

        }
    }
}
