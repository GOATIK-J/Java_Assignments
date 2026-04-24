import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String brand;
    String model;
    int year;
    double price;

    public void setDetails(String vehicleNumber, String brand, String model, int year, double price) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price);
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
}

public class Main {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            vehicles[i] = new Vehicle();

            System.out.println("\nEnter details for Vehicle " + (i + 1));

            System.out.print("Vehicle Number: ");
            String number = sc.nextLine();

            System.out.print("Brand: ");
            String brand = sc.nextLine();

            System.out.print("Model: ");
            String model = sc.nextLine();

            System.out.print("Year: ");
            int year = sc.nextInt();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            vehicles[i].setDetails(number, brand, model, year, price);
        }

        System.out.println("\nVEHICLE DETAILS");
        for (Vehicle v : vehicles) {
            v.displayDetails();
        }

        double totalValue = 0;
        double maxPrice = vehicles[0].getPrice();
        int oldestYear = vehicles[0].getYear();

        for (Vehicle v : vehicles) {
            totalValue += v.getPrice();

            if (v.getPrice() > maxPrice)
                maxPrice = v.getPrice();

            if (v.getYear() < oldestYear)
                oldestYear = v.getYear();
        }

        System.out.println("SUMMARY REPORT");
        System.out.println("Total Vehicles: " + n);
        System.out.println("Total Value: " + totalValue);
        System.out.println("Average Price: " + (totalValue / n));
        System.out.println("Most Expensive Vehicle Price: " + maxPrice);
        System.out.println("Oldest Vehicle Year: " + oldestYear);

        sc.close();
    }
}
