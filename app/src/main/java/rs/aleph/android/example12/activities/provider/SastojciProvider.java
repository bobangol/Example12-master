package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Kategorija;
import rs.aleph.android.example12.activities.model.Sastojak;

public class SastojciProvider {


    public static List<String> getSastojci() {
        List<String> sastojci1 = new ArrayList<>();
        sastojci1.add("Meso");
        sastojci1.add("Crni luk");
        sastojci1.add("Domaci somun");

        List<String> sastojci2 = new ArrayList<>();
        sastojci2.add("234");
        sastojci2.add("223");
        sastojci2.add("3322");

        List<String> sastojci = new ArrayList<>();
        sastojci.addAll(sastojci1);
        sastojci.addAll(sastojci2);
        return sastojci;
    }


}
