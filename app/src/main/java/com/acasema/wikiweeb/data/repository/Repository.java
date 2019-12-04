package com.acasema.wikiweeb.data.repository;




import java.util.ArrayList;
import java.util.List;

class Repository<T> {
    private List<T> list;

    protected Repository(){
        list= new ArrayList<>();
    }

    public List<T> getList() {
        return list;
    }

    public boolean add(T t){
        return list.add(t);
    }

    public void edit(T t){ }

    public boolean remove(T t){
        return list.remove(t);
    }
}
