package oops.car;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarManagement {


    public static ArrayList<Car> readData(String fileName) {

        ArrayList<Car> cars = new ArrayList<>();

        int n;
        int typeOfCar;
        String id;
        String name;
        String manufacturer;
        double hours;
        double pricePerHour;
        double fee;
        double tax;


        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            n = Integer.parseInt(scan.nextLine());

            for (int i = 0; i<n; i++) {

                typeOfCar = Integer.parseInt(scan.nextLine());
                id = scan.nextLine();
                name = scan.nextLine();
                manufacturer = scan.nextLine();
                hours = Double.parseDouble(scan.nextLine());
                pricePerHour = Double.parseDouble(scan.nextLine());

                if (typeOfCar == 0) {

                    fee = Double.parseDouble(scan.nextLine());

                    ServiceCar serviceCar = new ServiceCar(id, name, manufacturer, hours, pricePerHour, fee);
                    cars.add(serviceCar);
                } else if (typeOfCar == 1) {

                    tax = Double.parseDouble(scan.nextLine());

                    SportCar sportCar = new SportCar(id, name, manufacturer, hours, pricePerHour, tax);
                    cars.add(sportCar);
                }
            }

            scan.close();
            return cars;
        }

        catch (FileNotFoundException fnfe) {

            return cars;
        }

    }

    public static void printCarsInfo(ArrayList<Car> cars) {

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }


    public static ArrayList<Car> findCars(ArrayList<Car> cars, String manu) {

        ArrayList<Car> manufacturerList = new ArrayList<>();

        for (Car car : cars) {

            if (car.getManufacturer().equals(manu)) {

                manufacturerList.add(car);
            }
        }

        return manufacturerList;
    }


    public static ArrayList<Car> findMaxAmountOfTypes(ArrayList<Car> cars, String typeOfCar) {

        ArrayList<Car> maxAmountOfTypes = new ArrayList<>();

        double max = cars.get(0).getAmount();

        for (Car car : cars) {

            if (car.getAmount() > max && car.getClass().getName().equals(typeOfCar)) {
                max = car.getAmount();
            }
        }

        for (Car car : cars) {

            if ((car.getClass().getName().equals(typeOfCar)) && (car.getAmount() == max)) {

                maxAmountOfTypes.add(car);
            }
        }

        return maxAmountOfTypes;

    }


    public static void sortCarsByAmount(ArrayList<Car> cars) {

        Car temp;
        boolean check = false;

        while (check == false) {
            check = true;

            for (int i = 0; i < cars.size() - 1; i++) {

                if (cars.get(i).getAmount() < cars.get(i + 1).getAmount()) {

                    check = false;
                    temp = cars.get(i);
                    cars.set(i, cars.get(i+1));
                    cars.set(i + 1, temp);

                }
            }
        }
    }


    public static void main(String[] args) {

        ArrayList<Car> cars = readData("C:\\Users\\minha\\Desktop\\Tai lieu hoc tap\\THJava\\oops\\car\\data.txt.txt");

        System.out.println("Original cars list: ");
        printCarsInfo(cars);
        System.out.println("======================================");

        System.out.println("Honda cars: ");
        ArrayList<Car> manufacturerList = findCars(cars, "honda");
        printCarsInfo(manufacturerList);
        System.out.println("======================================");

        System.out.println("Expensive Sport cars: ");
        ArrayList<Car> maxAmountOfType = findMaxAmountOfTypes(cars, "oops.car.SportCar");
        printCarsInfo(maxAmountOfType);
        System.out.println("======================================");

        System.out.println("Sorted cars list:");
        sortCarsByAmount(cars);
        printCarsInfo(cars);
    }
}
