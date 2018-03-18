package ru.aleksandrorlov.test4.contarct;

import java.util.List;

import ru.aleksandrorlov.test4.presenter.IPresenter;
import ru.aleksandrorlov.test4.view.activity.IView;

/**
 * Created by alex on 17.03.18.
 */

public interface MainActivityContract {
    interface View extends IView {
        void draw(List<TextInRectBase> textInRectBaseList);
        void showMessage(int messageResId);
        UserModel getUserModel();
    }

    interface Presenter extends IPresenter<View> {
        void setBirthday(long birthday);
        void setCountryFlag(int countryFlag);
        void setSex(String sex);
    }
}
