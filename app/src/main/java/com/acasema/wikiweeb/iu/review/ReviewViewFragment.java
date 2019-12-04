package com.acasema.wikiweeb.iu.review;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.data.modelos.Review;

public class ReviewViewFragment extends Fragment {
    public static final String TAG = "ReviewViewFragment";
    private static Review review;

    private TextView tvTituloTex, tvOpinionTex, tvPuntuacionTex, tvUsuarioTex;


    //region Metodos del ciclo de vida

    public static Fragment newInstance(Bundle bundle){
        ReviewViewFragment fragment = new ReviewViewFragment();
        if (bundle != null)
        {
            fragment.setArguments(bundle);
            Review review = (Review) bundle.getSerializable(Review.TAG);

            fragment.review = review;
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

        View view = inflater.inflate(R.layout.fragment_review_view, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTituloTex = view.findViewById(R.id.tvTituloTex);
        tvOpinionTex = view.findViewById(R.id.tvOpinionTex);
        tvPuntuacionTex = view.findViewById(R.id.tvPuntuacionTex);
        tvUsuarioTex = view.findViewById(R.id.tvUsuarioTex);

        tvTituloTex.setText(review.getTitulo());
        tvOpinionTex.setText(review.getopinion());
        tvPuntuacionTex.setText(review.getLetraPk());
        tvUsuarioTex.setText(review.getUsuario().getNombre());

    }

    //endregion

}
