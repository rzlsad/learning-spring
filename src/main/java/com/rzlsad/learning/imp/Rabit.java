package com.rzlsad.learning.imp;

public class Rabit {


    private boolean adult;
    private Rabit parent;

    public Rabit(Rabit parent) {
        adult = false;
        this.parent = parent;
    }

    public Rabit giveBirth(Rabit parent){
        return new Rabit(parent);
    }

    public boolean isAdult() {
        if (adult){
            return true;
        }else {
            adult=true;
            return false;
        }
    }


    public Rabit getParent() {
        return parent;
    }
}
