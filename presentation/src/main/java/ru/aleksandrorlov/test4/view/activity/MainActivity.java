package ru.aleksandrorlov.test4.view.activity;


import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;

import ru.aleksandrorlov.test4.R;
import ru.aleksandrorlov.test4.view.activity.view.FloatingActionButton;
import ru.aleksandrorlov.test4.view.adapter.IRecyclerViewClickListener;
import ru.aleksandrorlov.test4.view.adapter.RecyclerViewDialogFragment;
import ru.aleksandrorlov.test4.view.adapter.RecyclerViewTouchListener;
import ru.aleksandrorlov.test4.view.fragment.Dialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFAB();
        FABBehavior();
        initRecyclerView();
    }

    private void initFAB() {
        fab = new FloatingActionButton.Builder(this)
                .withDrawable(getResources().getDrawable(R.drawable.ic_add_black_24dp))
                .withButtonColor(Color.WHITE)
                .withGravity(Gravity.BOTTOM | Gravity.RIGHT)
                .withMargins(0, 0, 16, 16)
                .create();
    }

    private void FABBehavior() {
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startDialog();
    }

    private void startDialog() {
        DialogFragment dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), null);
    }

    private void initRecyclerView() {
        RecyclerViewDialogFragment adapter = new RecyclerViewDialogFragment(this,
                null,
                getScreenSize());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(this, recyclerView,
                new IRecyclerViewClickListener() {
                    @Override
                    public void onClick(View view, int position) {

                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));
    }

    private Point getScreenSize() {
        DisplayMetrics metrics;
        metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.heightPixels;
        int height = metrics.widthPixels;

        boolean isLandscape = width > height;

        if (!isLandscape) {
            width = metrics.widthPixels;
            height = metrics.heightPixels;
        }
        return new Point(width, height);
    }
}
