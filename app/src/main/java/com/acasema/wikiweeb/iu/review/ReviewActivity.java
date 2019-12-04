package com.acasema.wikiweeb.iu.review;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.data.modelos.Review;

public class ReviewActivity extends AppCompatActivity implements ReviewListFragment.OnManageReviewListener {
//acticiti que controla los fragment

    private ReviewListFragment reviewListFragment;
    private ReviewListPresenter reviewListPresenter;
    private ReviewAddFragment reviewAddFragment;
    private ReviewAddPresenter reviewAddPresenter;
    private ReviewViewFragment reviewViewFragment;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        showListFragment();
    }

    private void showListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        reviewListFragment = (ReviewListFragment) fragmentManager.findFragmentByTag(ReviewListFragment.TAG);
        if (reviewListFragment == null)
        {
            reviewListFragment = (ReviewListFragment) ReviewListFragment.newInstance(null);
            fragmentManager.beginTransaction().add(android.R.id.content, reviewListFragment, ReviewListFragment.TAG).commit();
        }
        reviewListPresenter =new ReviewListPresenter(reviewListFragment);
        reviewListFragment.setPresente(reviewListPresenter);
    }
    private void showAddFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        reviewAddFragment = (ReviewAddFragment) getSupportFragmentManager().findFragmentByTag(ReviewAddFragment.TAG);
        if (reviewAddFragment == null){
            reviewAddFragment = (ReviewAddFragment) ReviewAddFragment.newInstance();
            //region contrato Fragment-Presenter
            //despues de crear la vista siampre se crea el presenter
            reviewAddPresenter = new ReviewAddPresenter(reviewAddFragment);
            reviewAddFragment.setPresente(reviewAddPresenter);
            //endregion
            fragmentTransaction.replace(android.R.id.content, reviewAddFragment, ReviewAddFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    private void showViewFragment(Review review) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        reviewViewFragment = (ReviewViewFragment) getSupportFragmentManager().findFragmentByTag(ReviewAddFragment.TAG);
        if (reviewViewFragment == null){
            Bundle bundle = null;
            if (review != null){
                bundle = new Bundle();
                //bundle.putParcelable(Dependency.TAG, sections);
                bundle.putSerializable(Review.TAG, review);
            }
            reviewViewFragment = (ReviewViewFragment) ReviewViewFragment.newInstance(bundle);
            //endregion
            fragmentTransaction.replace(android.R.id.content, reviewViewFragment, ReviewAddFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        showAddFragment();
    }

    @Override
    public void onAddReview() {
        showAddFragment();
    }

    @Override
    public void onViewReview(Review review) {
        showViewFragment(review);
    }
}
