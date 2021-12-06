package com.example.tema1workoutplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PersonVipDAO personVipDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonVIP p1 = new PersonVIP("Ana", "ana@yahoo.com", 100);
        PersonVIP p2 = new PersonVIP("Ioana", "ioana@gmail.com", 250);
        PersonVIP p3 = new PersonVIP("Andrei", "andrei@yahoo.com", 189);
        PersonVIP p4 = new PersonVIP("Sergiu", "sergiu@yahoo.com", 21);

        personVipDAO = DatabaseAcces.getInstance(this).getDatabase().personVipDAO();

        personVipDAO.InsertAll(p1,p2,p3,p4);

        List<PersonVIP> listaPers = personVipDAO.getAll();
        List<PersonVIP> listaCod = personVipDAO.getCod(150);
        personVipDAO.Delete(p4);
        List<PersonVIP> listaEmail = personVipDAO.getEmail();

        Log.v("opDB", listaPers.toString());
        Log.v("opDB", listaCod.toString());
        Log.v("opDB", listaEmail.toString());


    }
}