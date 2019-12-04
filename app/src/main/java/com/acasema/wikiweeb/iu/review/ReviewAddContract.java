package com.acasema.wikiweeb.iu.review;

import com.acasema.inventory.iu.base.BaseView;
import com.acasema.wikiweeb.data.modelos.Review;

public interface ReviewAddContract {

    interface View extends BaseView<Presenter> {
        void onSuccessValidate();
    }

    interface Presenter {
        void validadteReview(Review review);
        void add(Review review);
    }
}
