package ru.aleksandrorlov.test4.view.adapter;

import android.view.View;

/**
 * Created by alex on 17.03.18.
 */

public interface IRecyclerViewClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
