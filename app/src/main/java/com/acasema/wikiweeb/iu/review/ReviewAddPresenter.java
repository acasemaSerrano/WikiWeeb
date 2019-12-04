package com.acasema.wikiweeb.iu.review;


import com.acasema.wikiweeb.data.modelos.Review;
import com.acasema.wikiweeb.data.repository.ReviewRepository;

public class ReviewAddPresenter implements ReviewAddContract.Presenter {

    private ReviewAddContract.View view;

    public ReviewAddPresenter(ReviewAddContract.View view){
        this.view = view;
    }

    @Override
    public void validadteReview(Review review) {
        view.onSuccessValidate();
    }

    @Override
    public void add(Review review) {
        if(!ReviewRepository.getInstance().add(review)){
            view.showError("ya esiste el nombre corto");
            return;
        }
        view.onSuccess();
    }

}
