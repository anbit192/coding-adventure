package spoj;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class STACKEZ {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        query(stack);
    }

    public static void query(Stack<Integer> stack) throws IOException {
        Reader scan = new Reader();
        StringBuilder sb = new StringBuilder();
        int numberOfQuerries = scan.nextInt();

        for (int i = 0; i < numberOfQuerries; i++) {
            int query = scan.nextInt();
            switch (query) {
                case 1:
                    stack.push(scan.nextInt());
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case 3:
                    if (stack.isEmpty()) {
                        sb.append("Empty!\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
            }

        }

        System.out.println(sb);
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
  
        public int nextInt() throws IOException{
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
