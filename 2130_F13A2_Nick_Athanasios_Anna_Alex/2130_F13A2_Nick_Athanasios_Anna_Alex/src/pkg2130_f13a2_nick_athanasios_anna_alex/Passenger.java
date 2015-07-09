package pkg2130_f13a2_nick_athanasios_anna_alex;

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
