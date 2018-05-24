package rs.aleph.android.example12.activities.model;

public class Sastojci {

    private int id;
    private String nazivSastojka;

    public Sastojci(){

    }

    public Sastojci(int id, String nazivSastojka) {
        this.id = id;
        this.nazivSastojka = nazivSastojka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivSastojka() {
        return nazivSastojka;
    }

    public void setNazivSastojka(String nazivSastojka) {
        this.nazivSastojka = nazivSastojka;
    }

    @Override
    public String toString() {
        return "Sastojci{" +
                "id=" + id +
                ", nazivSastojka='" + nazivSastojka + '\'' +
                '}';
    }
}
