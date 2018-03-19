package ru.aleksandrorlov.test4.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import static ru.aleksandrorlov.test4.Constant.EXCEPTION_NULL_LIST;

/**
 * Created by alex on 17.03.18.
 */

public class YandexPictureAdapter extends
        RecyclerView.Adapter<YandexPictureAdapter.ViewHolder> {

    private final String TAG = this.getClass().getSimpleName();

    public interface OnItemLongClickListener {
        void onViewItemLongClicked(long yandexPictureId);
    }

    private final Context context;

    private List<YandexPictureModel> yandexPictureModelList;

    private OnItemLongClickListener onItemLongClickListener;

    @Inject
    public YandexPictureAdapter(Context context) {
        this.context = context;
        this.yandexPictureModelList = Collections.emptyList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final YandexPictureModel yandexPictureModel = yandexPictureModelList.get(position);

        holder.textViewRequest.setText(yandexPictureModel.getRequest());

        String url = yandexPictureModel.getUrl();
        if (url.equals("")) {
            url = Integer.toString(R.drawable.error_download_image);
        }

        Picasso.get()
                .load(url)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.error_download_image)
                .into(holder.imageView);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (YandexPictureAdapter.this.onItemLongClickListener != null) {
                    long l = yandexPictureModel.getYandexPictureId();
                    Log.d(TAG, "onLongClick: " + yandexPictureModel.toString());

                    YandexPictureAdapter.this.onItemLongClickListener.
                            onViewItemLongClicked(yandexPictureModel.getYandexPictureId());

                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (yandexPictureModelList == null) ? 0 : yandexPictureModelList.size();
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

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
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
