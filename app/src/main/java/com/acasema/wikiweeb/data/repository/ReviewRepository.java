package com.acasema.wikiweeb.data.repository;

import com.acasema.wikiweeb.data.modelos.Articulo;
import com.acasema.wikiweeb.data.modelos.Etiqueta;
import com.acasema.wikiweeb.data.modelos.Review;
import com.acasema.wikiweeb.data.modelos.Tipo;
import com.acasema.wikiweeb.data.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepository extends Repository {

    private static ReviewRepository reviewRepository;

    static {
        reviewRepository = new ReviewRepository();
    }

    public static ReviewRepository getInstance() {
        return reviewRepository;
    }

    protected ReviewRepository() {
        super();
        iniciar();
    }

    private void iniciar(){
        String s = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec pharetra luctus ex. Aliquam eu nunc ut sapien efficitur semper et auctor enim. Vestibulum gravida tortor sapien, a consequat nisi vulputate nec. Phasellus sagittis vel nisl eget faucibus.";
        List<Etiqueta> etiquetaList = new ArrayList<>();
        etiquetaList.add(new Etiqueta("protagonista op"));
        etiquetaList.add(new Etiqueta("overlord"));
        etiquetaList.add(new Etiqueta("fantasia"));

        String n = "La historia da comienzo cuando Yggdrasil, un popular juego online, es cerrado un día sin previo aviso. Sin embargo, el protagonista, Momonga, decide no salir del juego. Momonga así se transforma y se convierte en “el mago más poderoso”. El mundo sigue cambiando con él dentro, y los NPCs comienzan a sentir emociones. Sin familia, amigos ni lugar en la sociedad, Momonga tendrá que luchar por adaptarse al nuevo mundo en el que se ha convertido el juego.";

        Articulo a = new Articulo("overlord", Tipo.NOBELA_WEB,n,etiquetaList);

        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
        getList().add(new Review(a, new Usuario("acasema"), 10, s));
    }
}
