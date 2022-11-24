package designpatterns.singleton.reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reader {
    private static BufferedReader reader;

    private Reader() {
    }

    public static BufferedReader getInstance() {
        if (reader == null) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            return reader;
        }

        return reader;
    }
}
