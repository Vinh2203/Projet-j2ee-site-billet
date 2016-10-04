package com.projet.model;

public class Comparator implements java.util.Comparator<Ville> {

    public int compare(Ville v, Ville c) {
        return v.getNomVille().compareTo(c.getNomVille());
    }

}