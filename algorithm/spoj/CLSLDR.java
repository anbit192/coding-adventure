package spoj;

import java.io.DataInputStream;
import java.io.IOException;

public class CLSLDR {

    Node head;
    int size;

    public CLSLDR() {
        this.head = null;
        this.size = 0;
    }

    public static void main(String[] args) throws IOException {
        Reader scan = new Reader();
        int numberOfTests = scan.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfTests; i++) {
            CLSLDR clsldr = new CLSLDR();
            clsldr.generate(scan);
            sb.append(clsldr.findLeader(scan)).append("\n");
        }

        System.out.println(sb);


    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public void generate(Reader scan) throws IOException {
        int numberOfStudents = scan.nextInt();
        for (int i = 1; i <= numberOfStudents; i++) {
            this.add(i);
        }

        this.get(numberOfStudents - 1).setNextNode(this.head);
    }

    public int findLeader(Reader scan) throws IOException {
        int currentStudent = scan.nextInt();
        int interval = scan.nextInt();

        Node student = this.get(currentStudent - 1);

        while (this.size > 1) {
            int count = 0;

            while (count < interval) {
                student = student.nextNode;
                count++;
            }
            this.print();
            this.remove(student.getData());
        }

        return this.get(0).getData();
    }

    public void print() {

        for (int i = 0; i < this.size; i++) {
            System.out.print(this.get(i).getData() + " ");
        }
        System.out.println("size:" + this.size);
    }

    public Node get(int index) {
        Node currentNode = this.head;

        for (int i = 0; i <= index - 1; i++) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    public void add(int data, int index) {
        if (index == 0) {
            Node newHeadNode = new Node(data, this.head);
            this.head = newHeadNode;
        } else {
            Node currentNode = get(index - 1);
            Node nextNode = new Node(data, currentNode.getNextNode());
            currentNode.setNextNode(nextNode);
        }

        this.size++;
    }

    public void add(int data) {
        if (this.size == 0) {
            this.add(data, 0);
        } else {
            this.add(data, this.size);
        }
    }

    public int removeTop() {

        Node removedNode = this.head;

        if (this.size < 1) {
            this.head = null;

            this.size--;
            return removedNode.getData();
        }

        this.head = this.head.nextNode;

        get(this.size - 1).nextNode = this.head;

        //this.size--;

        return removedNode.getData();
    }

    public void removeIndex(int index) {
        Node currentNode = get(index - 1);

        if (index == 0) {
            System.out.println("Removed Head: " + this.head.data);
            this.removeTop();
            System.out.println("New head: " + this.head.data);

            return;
        }

        currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        this.size--;
    }

    public void remove(int data) {

        for (int i = 0; i < this.size; i++) {
            if (this.get(i).getData() == data) {
                this.removeIndex(i);
            }
        }
    }



    class Node {
        int data;
        Node nextNode;

        public Node(int data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }


        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
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
