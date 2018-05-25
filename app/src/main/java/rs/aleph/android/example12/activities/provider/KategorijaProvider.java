package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Kategorija;

public class KategorijaProvider {
    public static List<Kategorija> getCategories() {

        List<Kategorija> categories = new ArrayList<>();
        categories.add(new Kategorija(0, "Rostilj"));
        categories.add(new Kategorija(1, "Gotova jela"));
        categories.add(new Kategorija(2, "Pizza"));
        return categories;
    }

    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("Rostilj");
        names.add("Gotova Jela");
        names.add("Pizza");
        return names;
    }

    public static Kategorija getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Kategorija(0, "Rostilj");
            case 1:
                return new Kategorija(1, "Gotova jela");
            case 2:
                return new Kategorija(2, "Pizza");
            default:
                return null;
        }
    }
}
