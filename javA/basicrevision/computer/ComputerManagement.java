package basicrevision.computer;

import java.util.Scanner;

public class ComputerManagement {

    private Computer[] computers;
    private int n;

    public void input(Scanner scan) {
        System.out.println("Enter size: ");
        this.n = Integer.parseInt(scan.nextLine());
        this.computers = new Computer[this.n];

        for (int i = 0; i < computers.length; i++) {
            System.out.println("Enter name: ");
            String name = scan.nextLine();
            System.out.println("Enter manu: ");
            String manu = scan.nextLine();
            System.out.println("Enter year");
            int year = Integer.parseInt(scan.nextLine());
            System.out.println("Enter detail: ");
            String detail = scan.nextLine();
            System.out.println("Enter price: ");
            Double price = Double.parseDouble(scan.nextLine());

            Computer computer = new Computer(name, manu, year, detail, price);
            this.computers[i] = computer;
        }
    }

    public void output() {
        for (Computer computer : this.computers) {
            System.out.println(computer.toString());
        }
    }

    public double getAvgPrice() {
        double sum = 0;
        for (Computer computer : this.computers) {
            sum += computer.getPrice();
        }

        return sum / (double) this.computers.length;
    }

    public void getMaxPrice() {

        double max = this.computers[0].getPrice();
        for (Computer computer : this.computers) {
            if (computer.getPrice()>max) {
                max = computer.getPrice();
            }
        }

        for (Computer computer : computers) {
            if (computer.getPrice() == max) {
                System.out.println(computer.toString());
            }
        }
    }

    public void getDell() {
        for (Computer computer : this.computers) {
            if (computer.getManu().equalsIgnoreCase("dell")) {
                System.out.println(computer.toString());
            }
        }
    }

    public void sort() {

        for (int i = 0; i<this.computers.length-1; i++) {
            for (int j = i+1; j<this.computers.length;j++) {

                if (this.computers[i].getPrice() < this.computers[j].getPrice()) {
                    Computer temp = this.computers[i];
                    this.computers[i] = this.computers[j];
                    this.computers[j] = temp;
                }
            }
        }

        this.output();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ComputerManagement manager = new ComputerManagement();

        manager.input(scan);

        System.out.println("Unsort: ");
        manager.output();

        System.out.println("Get avg price: ");
        System.out.println(manager.getAvgPrice());

        System.out.println("Max prices: ");
        manager.getMaxPrice();

        System.out.println("Dell: ");
        manager.getDell();

        System.out.println("Sort: ");

        manager.sort();


    }
}
