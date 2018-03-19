package ru.aleksandrorlov.test4.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
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

import ru.aleksandrorlov.test4.R;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by alex on 17.03.18.
 */

public class Dialog extends DialogFragment implements View.OnClickListener {
    private Button replaceButton, addButton;

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

        buttonBehavior();

        return view;
    }

    private void initViews(View view) {
        EditText searchEditText = (EditText) view.findViewById(R.id.yandex_picture_search);
        replaceButton = (Button) view.findViewById(R.id.replace_button);
        addButton = (Button) view.findViewById(R.id.add_button);

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

    private void buttonBehavior() {
        replaceButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.replace_button:

                break;
            case R.id.add_button:

                break;
        }
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

        Window window = getDialog().getWindow();
        window.setLayout(size.x, size.y);
        window.setGravity(Gravity.CENTER);
    }
}