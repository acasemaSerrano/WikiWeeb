package com.acasema.wikiweeb.data.modelos;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public enum Tipo {
    NOBELA_WEB, NOBELA_LIGERA, ANIME, MANGA;

    @NonNull
    @Override
    public String toString() {
        return super.toString().toLowerCase().replace("_", " " );
    }
    public static List<Tipo> toStringAray() {
        List<Tipo> list = new ArrayList<>();

        list.add(Tipo.NOBELA_WEB);
        list.add(Tipo.NOBELA_LIGERA);
        list.add(Tipo.ANIME);
        list.add(Tipo.MANGA);

        return list;

    }

}
