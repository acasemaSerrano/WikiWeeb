package com.acasema.wikiweeb.iu.review;


import com.acasema.wikiweeb.data.modelos.Review;

import java.util.List;

public interface ReviewListContract {
    interface  View extends com.acasema.inventory.iu.base.BaseView<Presenter> {
        void showProgress();
        void hideProgress();
        void showImagenNoData();
        boolean hasData();
        void hideImagenNoData();
        void onSuccess(List<Review> List);

    }
    interface Presenter{
        void load();
    }
}
