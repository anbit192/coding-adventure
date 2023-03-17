package sorts.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardUtility {

    List<Card> cards;

    public CardUtility() {
        cards = new ArrayList<>();
    }

    public static void main(String[] args) {
        CardUtility c = new CardUtility();
        c.generateDeck();

        Card c1 = c.getCard(4, 9);
        Card c2 = c.getCard(2, 9);

        CompareCard compare = new CompareCard();

        System.out.println(compare.compare(c1, c2));
        System.out.println(compare.compare(c1, c1));
        System.out.println(compare.compare(c2, c1));

        c.cards.sort(new CompareCard());
        Collections.sort(c.cards, new SortByRank());


        c.printDeck();
    }

    private static boolean exist(ArrayList<Integer> array, int number) {
        for (Integer integer : array) {
            if (number == integer) {
                return true;
            }
        }

        return false;
    }

    private static void print(ArrayList<Integer> list) {
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public void generateDeck() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(i, j);
                cards.add(card);
            }
        }
    }

    public void printDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public Card getCard(int suit, int rank) {

        for (int i = 0; i < 52; i++) {
            if (cards.get(i).getSuit() == suit && cards.get(i).getRank() == rank) {
                return cards.get(i);
            }
        }

        return null;
    }

    public ArrayList<Integer> createRandomInts(int boundary) {
        Random random = new Random();
        ArrayList<Integer> randomInts = new ArrayList<>();
        randomInts.add(random.nextInt(boundary));

        while (randomInts.size() < boundary) {
            int number = random.nextInt(boundary);
            if (!exist(randomInts, number)) {
                randomInts.add(number);
            }
        }

        return randomInts;
    }

    public void shuffleDeck() {
        ArrayList<Integer> numbers = createRandomInts(this.cards.size());

        for (int i = 0; i < this.cards.size(); i++) {
            Card temp = cards.get(i);
            cards.set(i, cards.get(numbers.get(i)));
            cards.set(numbers.get(i), temp);
        }

    }
}
