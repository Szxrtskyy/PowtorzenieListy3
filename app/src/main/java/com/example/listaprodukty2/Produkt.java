package com.example.listaprodukty2;

public class Produkt {
    String nazwa;
    Double cena ;
    String kategoria;

    public Produkt(String kategoria , String nazwa, Double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return kategoria + "\n" +
                nazwa +
                cena;
    }
}
