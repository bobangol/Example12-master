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

        Jelo cevapi = new Jelo(0, "cevapi.jpg", "Cevapi", "Sarajevski cevapi sa lukom u domacem somunu.", rostilj, null, 1000, 750);
        /*List<Sastojak> sastojci1 = new ArrayList<Sastojak>();
        Sastojak s1 = new Sastojak(0, "Junece meso",cevapi );
        sastojci1.add(s1);
        Sastojak s2 = new Sastojak(1, "Crni luk",cevapi );
        sastojci1.add(s2);
        Sastojak s3 = new Sastojak(2, "Domaci somun",cevapi );
        sastojci1.add(s3);
        cevapi.setSastojci(sastojci1);*/

        Jelo karadjordjeva = new Jelo(1, "karadjordjeva.jpeg", "Karadjordjeva", "Karadjordjeva snicla sa pomfritom i prilozima.", gotovoJelo, null, 1200, 1000 );
        /*List<Sastojak> sastojci2 = new ArrayList<Sastojak>();
        Sastojak s4 = new Sastojak(0, "Svinjsko meso",karadjordjeva );
        sastojci2.add(s4);
        Sastojak s5 = new Sastojak(1, "Kackavalj",karadjordjeva );
        sastojci2.add(s5);
        Sastojak s6 = new Sastojak(2, "Pomfrit",karadjordjeva );
        sastojci2.add(s6);
        cevapi.setSastojci(sastojci2);*/

        Jelo pizza1 = new Jelo(2, "pizza.jpeg", "Pizza", "Pizza a la Italia", pizza, null, 1100, 600 );
        /*List<Sastojak> sastojci3 = new ArrayList<Sastojak>();
        Sastojak s7 = new Sastojak(0, "Testo",pizza1 );
        sastojci3.add(s7);
        Sastojak s8 = new Sastojak(1, "Sir",pizza1 );
        sastojci3.add(s8);
        Sastojak s9 = new Sastojak(2, "Pelat",pizza1 );
        sastojci3.add(s9);
        pizza1.setSastojci(sastojci3);*/


        List<Jelo> jela = new ArrayList<>();
        jela.add(cevapi);
        jela.add(karadjordjeva);
        jela.add(pizza1);
        return jela;
    }


    public static List<String> getJeloImena() {

        List<String> names = new ArrayList<>();
        names.add("Cevapi");
        names.add("Karadjordjeva");
        names.add("Pizza");
        return names;
    }


    public static Jelo getJeloById(int id) {

        Kategorija rostilj = new Kategorija(0, "Rostilj");
        Kategorija gotovoJelo = new Kategorija(1, "Gotova jela");
        Kategorija pizza = new Kategorija(2, "Pizza");

        switch (id) {
            case 0:
                return new Jelo(0, "cevapi.jpg", "Cevapi", "Sarajevski cevapi sa lukom u domacem somunu.", rostilj, "Sastojci: junece meso, luk, domaci somun.", 1000, 750);
            case 1:
                return new Jelo(1, "karadjordjeva.jpeg", "Karadjordjeva", "Karadjordjeva snicla sa pomfritom i prilozima.", gotovoJelo,"Sastojci: svinjsko meso, kackavalj, pomfrit, domaci somun.", 1200, 1000);
            case 2:
                return new Jelo(2, "pizza.jpeg", "Pizza", "Pizza a la Italia", pizza, "Sastojci: testo, sir, pelat.", 1100, 600);
            default:
                return null;
        }
    }
}
