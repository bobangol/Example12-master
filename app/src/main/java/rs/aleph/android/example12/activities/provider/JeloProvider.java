package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Jelo;
import rs.aleph.android.example12.activities.model.Kategorija;
import rs.aleph.android.example12.activities.model.Sastojak;

public class JeloProvider {
    public static List<Jelo> getJelo() {

        Kategorija rostilj = new Kategorija(0, "Rostilj");
        Kategorija gotovoJelo = new Kategorija(1, "Gotova jela");
        Kategorija pizza = new Kategorija(2, "Pizza");

        Jelo cevapi = new Jelo(0, "cevapi.jpg", "Cevapi", "111111", rostilj, null, 1000, 750);
        List<Sastojak> sastojci1 = new ArrayList<Sastojak>();
        Sastojak s1 = new Sastojak(0, "meso",cevapi );
        sastojci1.add(s1);
        Sastojak s2 = new Sastojak(1, "luk",cevapi );
        sastojci1.add(s2);
        cevapi.setSastojci(sastojci1);

        Jelo karadjordjeva = new Jelo(1, "karadjordjeva.jpeg", "Kara", "222222", gotovoJelo, null, 1200, 100 );
        List<Sastojak> sastojci2 = new ArrayList<Sastojak>();
        Sastojak s3 = new Sastojak(0, "meso111",karadjordjeva );
        sastojci2.add(s3);
        Sastojak s4 = new Sastojak(1, "luk1111",karadjordjeva );
        sastojci2.add(s4);
        cevapi.setSastojci(sastojci2);


        List<Jelo> jela = new ArrayList<>();
        jela.add(cevapi);
        jela.add(karadjordjeva);
        return jela;
    }

    public static List<String> getJeloImena() {

        List<String> names = new ArrayList<>();
        names.add("Cevapi");
        names.add("Karadjordjeva");
        return names;
    }

    public static Jelo getJeloById(int id) {

        Kategorija rostilj = new Kategorija(0, "Rostilj");
        Kategorija gotovoJelo = new Kategorija(1, "Gotova jela");
        Kategorija pizza = new Kategorija(2, "Pizza");

        switch (id) {
            case 0:
                return new Jelo(0, "cevapi.jpg", "Cevapi", "111111", rostilj, null, 1000, 750);
            case 1:
                return new Jelo(1, "karadjordjeva.jpeg", "Kara", "222222", gotovoJelo, null, 1200, 100);
            default:
                return null;
        }
    }
}
