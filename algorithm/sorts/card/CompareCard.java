package sorts.card;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getSuit() == c2.getSuit()) {
            if (c1.getRank() > c2.getRank()) {
                return 1;
            } else if (c1.getRank() < c2.getRank()){
                return -1;
            }

        } else if (c1.getSuit() < c2.getSuit()){
            if (c1.getRank() > c2.getRank()) {
                return 1;
            } else if (c1.getRank() == c2.getRank()) {
                return 1;
            } else {
                return -1;
            }

        } else {
            if (c1.getRank() > c2.getRank()) {
                return 1;
            } else if (c1.getRank() == c2.getRank()) {
                return -1;
            } else {
                return -1;
            }
        }

        return 0;
    }
}
