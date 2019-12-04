package com.acasema.wikiweeb.iu.review;

import android.os.AsyncTask;

import com.acasema.wikiweeb.data.modelos.Review;
import com.acasema.wikiweeb.data.repository.ReviewRepository;

import java.util.List;

public class ReviewListPresenter implements ReviewListContract.Presenter {
    private ReviewListContract.View view;

    public ReviewListPresenter(ReviewListContract.View view){
        this.view = view;
    }

    @Override
    public void load() {
        new LoadDataTast().execute();
    }

    private class LoadDataTast extends AsyncTask<Void,Void, List<Review>> {

        @Override
        protected List<Review> doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ReviewRepository.getInstance().getList();
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (!view.hasData())
                view.hideImagenNoData();
            view.showProgress();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(List<Review> sectionsList) {
            super.onPostExecute(sectionsList);
            view.hideProgress();
            if(sectionsList.isEmpty())
                view.showImagenNoData();
            else {
                //view.showData(dependencyList);
                if(!view.hasData())
                    view.hideImagenNoData();

                view.onSuccess(sectionsList);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

}
