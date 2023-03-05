package review3.card;

import java.util.Comparator;

public class Card {
    private int suit;
    private int rank;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    private String getRealSuit() {
        if (this.suit == 1) {
            return "HEART";
        } else if (this.suit == 2) {
            return "DIAMOND";
        } else if (this.suit == 3) {
            return "CLUB";
        } else {
            return "SPADE";
        }
    }

    private String getRealRank() {
        if (this.rank <= 10 && this.rank != 1) {
            return String.valueOf(this.rank);
        } else if (this.rank == 1) {
            return "A";
        } else if (this.rank == 11) {
            return "J";
        } else if (this.rank == 12) {
            return "Q";
        } else {
            return "K";
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getRealRank(), this.getRealSuit());
    }

}
