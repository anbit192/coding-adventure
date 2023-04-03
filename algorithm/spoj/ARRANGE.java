package spoj;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class ARRANGE {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        StringBuilder sb = new StringBuilder();


        int numberOfTests = scan.nextInt();

        for (int i = 0; i < numberOfTests; i++) {
            Integer[] array = input(scan);
            sb.append(arrange(array));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static String arrange(Integer[] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                sb.append(array[i]).append(" ");
            }
        }


        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1) {
                sb.append(array[i]).append(" ");
            }
        }

        return sb.toString();
    }

    public static Integer[] input(Reader scan) throws IOException {
        int numberOfItems = scan.nextInt();
        Integer[] array = new Integer[numberOfItems];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }

        Arrays.sort(array, Collections.reverseOrder());

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 3 && array[i+1] == 2) {
                array[i] = 2;
                array[i + 1] = 3;

                break;
            }
        }
        return array;
    }

    static final class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream dis;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader(){
            dis = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            do{
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            return ret;
        }

        private void fillBuffer() throws IOException{
            bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException{
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException{
            if (dis == null)
                return;
            dis.close();
        }
    }


}
