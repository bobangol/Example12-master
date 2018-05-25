package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Kategorija;
import rs.aleph.android.example12.activities.model.Sastojak;

public class SastojciProvider {


    public static List<String> getSastojci1() {
        List<String> sastojci1 = new ArrayList<>();
        sastojci1.add("Junece meso");
        sastojci1.add("Crni luk");
        sastojci1.add("Domaci somun");
        return sastojci1;
    }


}
