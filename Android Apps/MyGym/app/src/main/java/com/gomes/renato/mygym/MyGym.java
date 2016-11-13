package com.gomes.renato.mygym;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Renato on 16/08/2016.
 */
public class MyGym {
    private List<Muscle> listaMuscles;
    private List<Workout> listaWorkouts;
    private String Nome;

    public List<Muscle> getListaMuscles() {
        return listaMuscles;
    }

    public void setListaMuscles(List<Muscle> listaMuscles) {
        this.listaMuscles = listaMuscles;
    }

    public List<Workout> getListaWorkouts() {
        return listaWorkouts;
    }

    public void setListaWorkouts(List<Workout> listaWorkouts) {
        this.listaWorkouts = listaWorkouts;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public MyGym(String nome) {
        this.listaMuscles = new ArrayList<>();
        this.listaWorkouts = new ArrayList<>();
        Nome = nome;
    }
}
