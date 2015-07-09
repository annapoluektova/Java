package datastructures_isayenka_poluektova;

public class Passenger extends Person {
    int age;
    double fare;
    public double GetFare() {
        return (age >= 10) ? fare : ((age < 5) ? fare * 0.25 : fare * 0.75);
    }
    
    public Passenger(String firstName, String lastName, int age, double fare) {
        super(firstName, lastName);
        this.age = age;
        this.fare = fare;
    }
}