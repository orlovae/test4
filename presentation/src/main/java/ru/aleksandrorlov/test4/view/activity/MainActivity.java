package ru.aleksandrorlov.test4.view.activity;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Collection;

import javax.inject.Inject;

import ru.aleksandrorlov.test4.AndroidApplication;
import ru.aleksandrorlov.test4.R;
import ru.aleksandrorlov.test4.di.HasComponent;
import ru.aleksandrorlov.test4.di.components.ApplicationComponent;
import ru.aleksandrorlov.test4.di.components.DaggerYandexPictureComponent;
import ru.aleksandrorlov.test4.di.components.YandexPictureComponent;
import ru.aleksandrorlov.test4.di.modules.ActivityModule;
import ru.aleksandrorlov.test4.model.YandexPictureModel;
import ru.aleksandrorlov.test4.presenter.YandexPictureListPresenter;
import ru.aleksandrorlov.test4.view.YandexPictureListView;
import ru.aleksandrorlov.test4.view.activity.view.FloatingActionButton;
import ru.aleksandrorlov.test4.view.adapter.IRecyclerViewClickListener;
import ru.aleksandrorlov.test4.view.adapter.YandexPictureAdapter;
import ru.aleksandrorlov.test4.view.adapter.RecyclerViewTouchListener;
import ru.aleksandrorlov.test4.view.fragment.Dialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        YandexPictureListView, HasComponent<YandexPictureComponent> {

    private final String TAG = this.getClass().getSimpleName();
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private YandexPictureComponent yandexPictureComponent;

    @Inject
    YandexPictureListPresenter yandexPictureListPresenter;
    @Inject
    YandexPictureAdapter yandexPictureAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.yandexPictureComponent = DaggerYandexPictureComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

        this.getComponent().inject(this);

        initFAB();
        FABBehavior();
        initRecyclerView();

        Log.d(TAG, "onCreate: yandexPictureListPresenter" + yandexPictureListPresenter.toString());

        this.yandexPictureListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadYandexPictureList();
        }
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override public void onResume() {
        super.onResume();
        this.yandexPictureListPresenter.resume();
    }

    @Override public void onPause() {
        super.onPause();
        this.yandexPictureListPresenter.pause();
    }

    @Override public void onDestroy() {
        super.onDestroy();
        recyclerView.setAdapter(null);
        this.yandexPictureListPresenter.destroy();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getApplicationContext();
    }

    @Override
    public void renderYandexPictureList(Collection<YandexPictureModel> yandexPictureModelCollection) {
        if (yandexPictureModelCollection != null) {
            Log.d(TAG, "renderYandexPictureList: yandexPictureModelCollection "
             + yandexPictureModelCollection.size());
            this.yandexPictureAdapter.setYandexPictureModelCollection(yandexPictureModelCollection);
        }
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
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(yandexPictureAdapter);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(this, recyclerView,
                new IRecyclerViewClickListener() {
                    @Override
                    public void onClick(View view, int position) {

                    }

                    @Override
                    public void onLongClick(View view, int position) {
                        yandexPictureListPresenter.onLongPress(position);
                    }
                }));
    }

    private void loadYandexPictureList() {
        this.yandexPictureListPresenter.initialize();
    }

    @Override
    public YandexPictureComponent getComponent() {
        return yandexPictureComponent;
    }
}
