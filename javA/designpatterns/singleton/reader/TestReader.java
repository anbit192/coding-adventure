package designpatterns.singleton.reader;

import java.io.BufferedReader;

public class TestReader {
    public static void main(String[] args) {
        BufferedReader reader1 = Reader.getInstance();
        BufferedReader reader2 = Reader.getInstance();

        System.out.println(reader1);
        System.out.println(reader2);

    }
}
