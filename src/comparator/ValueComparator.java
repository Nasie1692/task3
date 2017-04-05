package comparator;

import java.util.Comparator;
import domain.Gem;

public class ValueComparator implements Comparator<Gem> {

    @Override
    public int compare(Gem o1, Gem o2) {
        if (o1.getValue() < o2.getValue()) {
            return -1;
        } else if (o1.getValue() > o2.getValue()) {
            return 1;
        } else {
            return 0;
        }
    }

}
