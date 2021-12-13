package com.example.tema1workoutplan;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        writeToDataBase();

    }

    public void writeToDataBase() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        PersonVIP pers1 = new PersonVIP("Maria", "maria@yahoo.com", 654);
        PersonVIP pers2 = new PersonVIP("Miruna", "miruna@gmail.com", 321);
        PersonVIP pers3 = new PersonVIP("Mihai", "mihai@yahoo.com", 108);
        myRef.setValue(pers1);
        myRef.setValue(pers2);
        myRef.setValue(pers3);

    }

    public void readFromDataBase() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("message");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                PersonVIP value = dataSnapshot.getValue(PersonVIP.class);
                Log.d(TAG, "Value is: " + value.toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


}