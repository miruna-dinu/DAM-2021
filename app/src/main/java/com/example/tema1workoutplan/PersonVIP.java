package com.example.tema1workoutplan;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "persoanaVIP")
public class PersonVIP {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "nume")
    private  String nume;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="codAcces")
    private Integer codAcces;

    public PersonVIP() {
    }

    public PersonVIP(String nume, String email, Integer codAcces) {
        this.nume = nume;
        this.email = email;
        this.codAcces = codAcces;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCodAcces() {
        return codAcces;
    }

    public void setCodAcces(Integer codAcces) {
        this.codAcces = codAcces;
    }

    @Override
    public String toString() {
        return "PersonVIP{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                ", codAcces=" + codAcces +
                '}';
    }
}
