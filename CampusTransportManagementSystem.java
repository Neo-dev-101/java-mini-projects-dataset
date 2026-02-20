import java.util.Scanner;

public class CampusTransportManagementSystem {

    // ===================================================
    // INTERFACES (Multiple Inheritance)
    // ===================================================

    interface GPS {
        String trackLocation(); // GPS tracking
    }

    interface FareCalculator {
        double calculateFare(double distance); // Fare calculation
    }

    // ===================================================
    // BASE CLASS — Vehicle (Parent of all)
    // ===================================================

    static class Vehicle {
        String registrationNo;
        double speed;

        // Parameterized Constructor
        Vehicle(String registrationNo, double speed) {
            this.registrationNo = registrationNo;
            this.speed          = speed;
        }

        // Common display method
        void displayBasicDetails() {
            System.out.println("Registration No : " + this.registrationNo);
            System.out.println("Speed           : " + (int) this.speed + " km/hr");
        }
    }

    // ===================================================
    // A) SINGLE INHERITANCE — Vehicle → Bus
    // B) HIERARCHICAL INHERITANCE — Vehicle → Bus
    // C) MULTIPLE INHERITANCE — Bus implements GPS, FareCalculator
    // ===================================================

    static class Bus extends Vehicle implements GPS, FareCalculator {
        int seats;

        Bus(String registrationNo, double speed, int seats) {
            super(registrationNo, speed); // calling Vehicle constructor
            this.seats = seats;
        }

        // GPS Interface Method
        @Override
        public String trackLocation() {
            return "Bus location tracked";
        }

        // FareCalculator Interface Method (₹5 per km)
        @Override
        public double calculateFare(double distance) {
            return distance * 5.0;
        }

        void displayDetails(double distance) {
            System.out.println("\n--- BUS DETAILS ---");
            displayBasicDetails();
            System.out.println("Seats           : " + this.seats);
            System.out.println("GPS Status      : " + trackLocation());
            System.out.println("Fare            : ₹" + calculateFare(distance));
        }
    }

    // ===================================================
    // B) HIERARCHICAL INHERITANCE — Vehicle → Bike
    // ===================================================

    static class Bike extends Vehicle {
        boolean helmetRequired;

        Bike(String registrationNo, double speed, boolean helmetRequired) {
            super(registrationNo, speed); // calling Vehicle constructor
            this.helmetRequired = helmetRequired;
        }

        void displayDetails() {
            System.out.println("\n--- BIKE DETAILS ---");
            displayBasicDetails();
            System.out.println("Helmet Required : " + this.helmetRequired);
        }
    }

    // ===================================================
    // B) HIERARCHICAL INHERITANCE — Vehicle → Ambulance
    // ===================================================

    static class Ambulance extends Vehicle {
        boolean emergencyMode;

        Ambulance(String registrationNo, double speed, boolean emergencyMode) {
            super(registrationNo, speed);
            this.emergencyMode = emergencyMode;
        }

        void displayDetails() {
            System.out.println("\n--- AMBULANCE DETAILS ---");
            displayBasicDetails();
            System.out.println("Emergency Mode  : " + this.emergencyMode);
        }
    }

    // ===================================================
    // C) MULTILEVEL INHERITANCE — Vehicle → Car
    // ===================================================

    static class Car extends Vehicle {
        String fuelType;

        Car(String registrationNo, double speed, String fuelType) {
            super(registrationNo, speed); // calling Vehicle constructor
            this.fuelType = fuelType;
        }

        void displayCarDetails() {
            displayBasicDetails();
            System.out.println("Fuel Type       : " + this.fuelType);
        }
    }

    // ===================================================
    // D) MULTILEVEL INHERITANCE     — Vehicle → Car → ElectricCar
    // E) HYBRID INHERITANCE         — ElectricCar also implements GPS, FareCalculator
    // ===================================================

    static class ElectricCar extends Car implements GPS, FareCalculator {
        int batteryPercentage;

        ElectricCar(String registrationNo, double speed, String fuelType, int batteryPercentage) {
            super(registrationNo, speed, fuelType); // calling Car constructor
            this.batteryPercentage = batteryPercentage;
        }

        // GPS Interface Method
        @Override
        public String trackLocation() {
            return "Electric car tracked";
        }

        // FareCalculator Interface Method (₹8 per km)
        @Override
        public double calculateFare(double distance) {
            return distance * 8.0;
        }

        void displayDetails(double distance) {
            System.out.println("\n--- ELECTRIC CAR DETAILS ---");
            displayCarDetails();
            System.out.println("Battery         : " + this.batteryPercentage + "%");
            System.out.println("GPS Status      : " + trackLocation());
            System.out.println("Fare            : ₹" + calculateFare(distance));
        }
    }

    // ===================================================
    // MAIN METHOD
    // ===================================================

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CAMPUS TRANSPORT MANAGEMENT SYSTEM =====");
        System.out.println("1. Bus");
        System.out.println("2. Bike");
        System.out.println("3. Electric Car");
        System.out.println("4. Ambulance");
        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {

            // ===== Case 1: BUS =====
            case 1:
                System.out.print("Enter Vehicle Registration No: ");
                String busReg = sc.nextLine();

                System.out.print("Enter Speed (km/hr): ");
                double busSpeed = sc.nextDouble();

                System.out.print("Enter Number of Seats: ");
                int seats = sc.nextInt();

                System.out.print("Enter Distance (km): ");
                double busDistance = sc.nextDouble();

                Bus bus = new Bus(busReg, busSpeed, seats);
                bus.displayDetails(busDistance);
                break;

            // ===== Case 2: BIKE =====
            case 2:
                System.out.print("Enter Vehicle Registration No: ");
                String bikeReg = sc.nextLine();

                System.out.print("Enter Speed (km/hr): ");
                double bikeSpeed = sc.nextDouble();

                System.out.print("Helmet Required (true/false): ");
                boolean helmet = sc.nextBoolean();

                Bike bike = new Bike(bikeReg, bikeSpeed, helmet);
                bike.displayDetails();
                break;

            // ===== Case 3: ELECTRIC CAR =====
            case 3:
                System.out.print("Enter Vehicle Registration No: ");
                String carReg = sc.nextLine();

                System.out.print("Enter Speed (km/hr): ");
                double carSpeed = sc.nextDouble();
                sc.nextLine(); // consume newline

                System.out.print("Enter Fuel Type: ");
                String fuelType = sc.nextLine();

                System.out.print("Enter Battery Percentage: ");
                int battery = sc.nextInt();

                System.out.print("Enter Distance (km): ");
                double carDistance = sc.nextDouble();

                ElectricCar electricCar = new ElectricCar(carReg, carSpeed, fuelType, battery);
                electricCar.displayDetails(carDistance);
                break;

            // ===== Case 4: AMBULANCE =====
            case 4:
                System.out.print("Enter Vehicle Registration No: ");
                String ambReg = sc.nextLine();

                System.out.print("Enter Speed (km/hr): ");
                double ambSpeed = sc.nextDouble();

                System.out.print("Emergency Mode (true/false): ");
                boolean emergency = sc.nextBoolean();

                Ambulance ambulance = new Ambulance(ambReg, ambSpeed, emergency);
                ambulance.displayDetails();
                break;

            default:
                System.out.println("Invalid choice! Please enter between 1 and 4.");
        }

        sc.close();
    }
}