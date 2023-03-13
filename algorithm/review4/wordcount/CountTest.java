package review4.wordcount;

import review4.list.SimpleArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountTest {

    SimpleArrayList<String> list = new SimpleArrayList<>();
    SimpleArrayList<WordCount> words = new SimpleArrayList<>();


    public static void main(String[] args) {

        CountTest test = new CountTest();
        test.readFile("C:\\Users\\ADMIN\\Desktop\\study\\algorithm\\review4\\wordcount\\text.txt");

        test.count();
        System.out.println(test.list);

        System.out.println(test.words);


    }

    public static SimpleArrayList<String> splitLine(String line) {
        SimpleArrayList<String> newList = new SimpleArrayList<>();

        String[] splittedString = line.split("\\s+");
        for (String str : splittedString) {
            str = str.replaceAll("[(-+=^.'\"\\s:,)]", "");
            if (!str.equals("")) {
                newList.add(str);
            }
        }

        return newList;
    }

    public void count() {
        for (String str : this.list) {
            if (!this.words.isContain(find(str))) {
                this.words.add(new WordCount(str));
            } else {
                this.find(str).increment();
            }
        }
    }

    public WordCount find(String word) {
        for (int index = 0; index < words.size(); index++) {
            if (words.get(index).getWord().equals(word)) {
                return words.get(index);
            }
        }

        return null;

    }

    public void readFile(String file) {
        try {
            File myFile = new File(file);
            Scanner scan = new Scanner(myFile);

            while (scan.hasNextLine()) {
                SimpleArrayList<String> lineList = splitLine(scan.nextLine());
                for (String string : lineList) {
                    list.add(string);
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

}
