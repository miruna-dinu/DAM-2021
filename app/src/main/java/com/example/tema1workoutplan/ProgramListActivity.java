package com.example.tema1workoutplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProgramListActivity extends AppCompatActivity {

    private ListView lv;
    private ProgramAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list);

        lv = findViewById(R.id.exercisesLv);

        adapter = new ProgramAdapter(getList());

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.updateList(getList2());
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Program p = adapter.getItem(position);

                Toast.makeText(ProgramListActivity.this,"Ati efectuat exercituul cu succes!", Toast.LENGTH_LONG).show();

                return false;
            }
        });


    }

    private List<Program> getList() {
        ArrayList<Program> list = new ArrayList<>();

        Program p1 = new Program("Luni", "Genoflexiuni", 50, 3.50F);
        Program p2 = new Program("Miercuri", "Abdomene", 80, 10F);
        Program p3 = new Program("Joi", "Flotari", 20, 5.20F);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        return list;
    }

    private List<Program> getList2() {
        ArrayList<Program> list = new ArrayList<>();

        Program p1 = new Program("Marti", "Bicicleta", 60, 5F);
        Program p2 = new Program("Vineri", "Tractiuni", 20, 2.40F);
        Program p3 = new Program("Sambata", "Fandari", 80, 10F);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        return list;
    }
}