package com.acasema.wikiweeb.iu.review;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.data.modelos.Articulo;
import com.acasema.wikiweeb.data.modelos.Etiqueta;
import com.acasema.wikiweeb.data.modelos.Review;
import com.acasema.wikiweeb.data.modelos.Tipo;
import com.acasema.wikiweeb.data.modelos.Usuario;
import com.acasema.wikiweeb.utils.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class ReviewAddFragment extends Fragment  implements ReviewAddContract.View{
    public static final String TAG = "DependencyManageFragment";


    private EditText etPuntuacion, etOpinion;
    private Spinner spArticuloTipo;
    private AutoCompleteTextView actvArticuloNombre;

    private FloatingActionButton fad;
    private ReviewAddContract.Presenter presenter;

    public static Fragment newInstance(/*Bundle bundle*/) {

        return new ReviewAddFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_review_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fad = view.findViewById(R.id.fab);
        intFad();
        etPuntuacion= view.findViewById(R.id.etPuntuacion);
        etOpinion = view.findViewById(R.id.etOpinion);
        spArticuloTipo = view.findViewById(R.id.spArticuloTipo);
        actvArticuloNombre = view.findViewById(R.id.actvArticuloNombre);


        ArrayAdapter<Tipo> comboAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item, Tipo.toStringAray());
        //Cargo el spinner con los datos
        spArticuloTipo.setAdapter(comboAdapter);

    }

    private void intFad() {
        fad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidSections())
                presenter.validadteReview(getReview());

            }
        });
    }

    public boolean isValidSections(){
        if (actvArticuloNombre.getText().toString().isEmpty()){
            showErrorThis(getResources().getString(R.string.errNameEmpty));
            return false;
        }
        if (etOpinion.getText().toString().isEmpty()){
            showErrorThis(getResources().getString(R.string.errOpinionEmpty));
            return false;
        }
        if (etPuntuacion.getText().toString().isEmpty()){
            showErrorThis(getResources().getString(R.string.errPuntuacionEmpty));
            return false;
        }

        try {
            Integer.parseInt(etPuntuacion.getText().toString());
        }catch (Exception e){

            showErrorThis(getResources().getString(R.string.errPuntuacionNotInt));
            return false;
        }

        return true;
    }

    private void showErrorThis(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    public Review getReview() {
        Review review = new Review();
        review.setArticulo(new Articulo(actvArticuloNombre.getText().toString(),(Tipo) spArticuloTipo.getSelectedItem(),"", new ArrayList<Etiqueta>()));
        review.setopinion(etOpinion.getText().toString());
        review.setPuntuacion(Integer.parseInt(etPuntuacion.getText().toString()));
        review.setUsuario(new Usuario(User.getUser()));
        return review;
    }

    //region metodos que vienen del contraro DependencyManageContract.View
    @Override
    public void setPresente(ReviewAddContract.Presenter presente) {
        this.presenter = presente;
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        getActivity().onBackPressed();
    }


    @Override
    public void onSuccessValidate() {
        Review review = getReview();
        presenter.add(review);
    }
    //endregion
}
