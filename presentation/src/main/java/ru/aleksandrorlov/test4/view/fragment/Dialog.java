package ru.aleksandrorlov.test4.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import ru.aleksandrorlov.test4.R;

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
        //TODO заменить хардкор на полный экран
        int width = getResources().getDimensionPixelSize(R.dimen.cp_dialog_width);
        int height = getResources().getDimensionPixelSize(R.dimen.cp_dialog_height);
        getDialog().getWindow().setLayout(width, height);

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
}