package pkg2130_f13a2_nick_athanasios_anna_alex;

public class FrequentPassenger extends Passenger {
    int frequentPassengerNumber, pointsCollected;
    
    public FrequentPassenger(String firstName, String lastName, int age, double fare, int frequentPassengerNumber, int pointsCollected) {
        super(firstName, lastName, age, fare);
        this.pointsCollected = pointsCollected;
    }
    
    @Override public String toString() {
        return "Passenger's name: " + firstName + " " + lastName + 
                "\nAge: " + age +
                "\nFare: " + GetFare() + 
                "\nPoints collected: " + pointsCollected;
    }
}
