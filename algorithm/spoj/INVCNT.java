package spoj;


import java.io.DataInputStream;
import java.io.FileInputStream;
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
            int number = scan.nextInt();

            array[i] = number;
        }

        return array;
    }

    public static long inversionCount(int[] array) {
        int[] temp = new int[array.length];
        return mergeSort(array, temp, 0, array.length - 1);
    }

    private static long mergeSort(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        long inversions = 0;
        inversions += mergeSort(array, temp, left, mid);
        inversions += mergeSort(array, temp, mid + 1, right);
        inversions += merge(array, temp, left, mid, right);
        return inversions;
    }

    private static long merge(int[] array, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long inversions = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                // Count inversions here
                inversions += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, left, array, left, right - left + 1);
        return inversions;
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }


}
