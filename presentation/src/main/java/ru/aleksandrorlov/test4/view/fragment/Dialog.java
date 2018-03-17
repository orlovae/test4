package ru.aleksandrorlov.test4.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import ru.aleksandrorlov.test4.R;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by alex on 17.03.18.
 */

public class Dialog extends DialogFragment {

    @Override
    public void onAttach(Context context) {
        Bundle bundle = getArguments();
        if (bundle != null) {
        }

        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setStyle(STYLE_NO_TITLE, 0);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment, null);

        initViews(view);

        return view;
    }

    private void initViews(View view) {
        EditText searchEditText = (EditText) view.findViewById(R.id.yandex_picture_search);
        Button replaceButton = (Button) view.findViewById(R.id.replace_button);
        Button addButton = (Button) view.findViewById(R.id.add_button);

        searchEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                search(s.toString());
            }
        });
    }

    private void search(String text) {

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();

        Point size = new Point();
        WindowManager windowManager = (WindowManager) getActivity().getSystemService(WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getSize(size);
        int widthScreen = size.x;
        int heightScreen = size.y;

        Window window = getDialog().getWindow();
        window.setLayout(widthScreen, heightScreen);
        window.setGravity(Gravity.CENTER);
    }
}