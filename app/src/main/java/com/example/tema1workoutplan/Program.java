package com.example.tema1workoutplan;

public class Program {
    private String zi, exercitiu;
    private int set;
    private float timp;

    public Program(String zi, String exercitiu, int set, float timp) {
        this.zi = zi;
        this.exercitiu = exercitiu;
        this.set = set;
        this.timp = timp;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public String getExercitiu() {
        return exercitiu;
    }

    public void setExercitiu(String exercitiu) {
        this.exercitiu = exercitiu;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public float getTimp() {
        return timp;
    }

    public void setTimp(float timp) {
        this.timp = timp;
    }

    @Override
    public String toString() {
        return "Program{" +
                "zi='" + zi + '\'' +
                ", exercitiu='" + exercitiu + '\'' +
                ", set=" + set +
                ", timp=" + timp +
                '}';
    }
}
