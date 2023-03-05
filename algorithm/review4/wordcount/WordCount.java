package review4.wordcount;

public class WordCount {

    private String word;
    private int count;

    public WordCount() {

    }

    public WordCount(String word) {
        this.word = word;
        this.count = 1;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        this.count++;
    }


    @Override
    public String toString() {
        return String.format("%s : %d", this.getWord(), this.getCount());
    }
}
