package com.example.tema1workoutplan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface PersonVipDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertAll(PersonVIP...persoanaVIP);

    @Delete
    void Delete(PersonVIP persoanaVIP);

    @Query("SELECT * FROM persoanaVIP")
    List<PersonVIP> getAll();

    @Query("SELECT * FROM PERSOANAVIP WHERE codAcces > :cod ")
    List<PersonVIP> getCod(int cod);

    @Query("SELECT * from persoanaVIP where email like '%yahoo%'")
    List<PersonVIP> getEmail();

}
