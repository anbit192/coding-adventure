package spoj;

import java.io.DataInputStream;
import java.io.IOException;

public class INVCNT {
    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int numberOfTests = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfTests; i++) {
            int[] array = generate(scan);
            sb.append(inversionCount(array)).append("\n");
        }
        scan.close();

        System.out.println(sb);

    }

    public static int[] generate(Reader scan) throws IOException {
        int size = scan.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            int number;
            do {
                number = scan.nextInt();

            } while (isContain(array, number));

            array[i] = number;
        }

        return array;
    }

    public static boolean isContain(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return true;
            }
        }

        return false;
    }

    public static int inversionCount(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }

        return count;
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
