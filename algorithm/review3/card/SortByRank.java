package review3.card;

import java.util.Comparator;

public class SortByRank implements Comparator<Card> {


    @Override
    public int compare(Card c1, Card c2) {
        return c1.getRank() - c2.getRank();
    }
}
