package com.acasema.wikiweeb.iu.review;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.adapter.ReviewAdapter;
import com.acasema.wikiweeb.data.modelos.Review;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ReviewListFragment extends Fragment implements ReviewListContract.View{

        public static final String TAG = "SectionsListFragment";
    public static final int CODE_DELETE = 300;
    private final int SPAN_COUNT = 3;

    private OnManageReviewListener listener;
    private ReviewAdapter.OnManageReviewListener listenerAdapter;

    private ReviewAdapter adapter;
    private ReviewListContract.Presenter presente;

    private FloatingActionButton fab;
    private RecyclerView rvReview;
    private ImageView imgNodata;
    private ConstraintLayout progress;


    public interface OnManageReviewListener {
        void onAddReview();
        void onViewReview(Review review);
    }

    //region Metodos del ciclo de vida
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnManageReviewListener) context;

        } catch (ClassCastException e) {
            throw new  ClassCastException(context.toString() + "must implenment OnManageReviewListener");
        }
    }

    public static Fragment newInstance(Bundle bundle){
        ReviewListFragment fragment = new ReviewListFragment();
        if (bundle != null)
        {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_review_list, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progress = view.findViewById(R.id.ipd);
        rvReview = view.findViewById(R.id.tvItens);
        initListReview();

        fab = view.findViewById(R.id.fabAdd);
        intFab();

        imgNodata = view.findViewById(R.id.imgNodata);

    }

    //se solicita una carga de datos al presentador
    @Override
    public void onResume() {
        super.onResume();
        adapter.clear();
        presente.load();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    //endregion
    //region Metodos de inicializacion
    private void intFab() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddReview();
            }
        });
    }

    /*
        METODO QIE INICIA EL RECICLE REVIEW
     */
    private void initListReview() {

        initListenerAdapter();
        adapter = new ReviewAdapter();
        adapter.setOnManageReviewListener(listenerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        rvReview.setLayoutManager(linearLayoutManager);
        rvReview.setAdapter(adapter);
    }

    /**
     * Metodo que inicializa el lisener que analiza eventos del adapter
     */
    private void initListenerAdapter() {
        listenerAdapter = new ReviewAdapter.OnManageReviewListener() {
            @Override
            public void onEditReview(Review review) {
                listener.onViewReview(review);
            }
        };

    }

    //endregion
    //region Metodos SectionsListContract.View
    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);

    }

    @Override
    public void showImagenNoData() {
        imgNodata.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideImagenNoData() {
        imgNodata.setVisibility(View.GONE);
    }

    @Override
    public boolean hasData(){

        return imgNodata.getVisibility() == View.GONE;
    }

    @Override
    public void setPresente(ReviewListContract.Presenter presente) {
        this.presente = presente;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onSuccess(List<Review> reviewList) {
        adapter.clear();
        adapter.load(reviewList);
        //se dedevi llamar al metodo notifydataChanged del adaptar
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess() {

    }


    //endregion
}


