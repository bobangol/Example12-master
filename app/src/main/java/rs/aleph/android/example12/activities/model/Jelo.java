package rs.aleph.android.example12.activities.model;

import java.util.List;

public class Jelo {

    private int id;
    private String image;
    private String name;
    private String opis;
    private Kategorija kategorija;
    private String sastojci;
    private int kalorijskaVrednost;
    private double cena;

    public Jelo(){

    }

    public Jelo(int id, String image, String name, String opis, Kategorija kategorija, String sastojci, int kalorijskaVrednost, double cena) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.opis = opis;
        this.kategorija = kategorija;
        this.sastojci = sastojci;
        this.kalorijskaVrednost = kalorijskaVrednost;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public String getSastojci() {
        return sastojci;
    }

    public void setSastojci(String sastojci) {
        this.sastojci = sastojci;
    }

    public int getKalorijskaVrednost() {
        return kalorijskaVrednost;
    }

    public void setKalorijskaVrednost(int kalorijskaVrednost) {
        this.kalorijskaVrednost = kalorijskaVrednost;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Jelo{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", opis='" + opis + '\'' +
                ", kategorija=" + kategorija +
                ", sastojci=" + sastojci +
                ", kalorijskaVrednost=" + kalorijskaVrednost +
                ", cena=" + cena +
                '}';
    }
}
