package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Kategorija;
import rs.aleph.android.example12.activities.model.Sastojci;

public class SastojciProvider {
    public static List<Sastojci> getSastojci() {

        List<Sastojci> sastojci = new ArrayList<>();
        sastojci.add(new Sastojci(0, "Meso"));
        sastojci.add(new Sastojci(1, "Krompir"));
        sastojci.add(new Sastojci(2, "Sir"));
        sastojci.add(new Sastojci(3, "Lepinja"));
        sastojci.add(new Sastojci(4, "Sampinjoni"));
        return sastojci;
    }

    public static List<String> getNazivSastojka() {
        List<String> names = new ArrayList<>();
        names.add("Meso");
        names.add("Krompir");
        names.add("Sir");
        names.add("Lepinja");
        names.add("Sampinjoni");
        return names;
    }

    public static Sastojci getKategorijaById(int id) {
        switch (id) {
            case 0:
                return new Sastojci(0, "Meso");
            case 1:
                return new Sastojci(1, "Krompir");
            case 2:
                return new Sastojci(2, "Sir");
            case 3:
                return new Sastojci(3, "Lepinja");
            case 4:
                return new Sastojci(4, "Sampinjoni");
            default:
                return null;
        }
    }
}
