package com.example.tema1workoutplan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProgramAdapter extends BaseAdapter {

    private List<Program> listaProgram = new ArrayList<>();

    public ProgramAdapter(List<Program> lista) {
        listaProgram = lista;
    }

    @Override
    public int getCount() {
        return listaProgram.size();
    }

    @Override
    public Program getItem(int i) {
        return listaProgram.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.item_program, viewGroup, false);
        TextView tZi = v.findViewById(R.id.zi);
        TextView tExercitiu = v.findViewById(R.id.exercitiu);
        TextView tSet = v.findViewById(R.id.seturi);
        TextView tTimp = v.findViewById(R.id.timp);

        Program p = listaProgram.get(position);
        tZi.setText(p.getZi());
        tExercitiu.setText(p.getExercitiu());
        tSet.setText(p.getSet() + "");
        tTimp.setText(p.getTimp() + "");

        return v;
    }

    public void updateList(List<Program> lista) {
        listaProgram.clear();
        listaProgram.addAll(lista);

        notifyDataSetChanged();
    }
}
