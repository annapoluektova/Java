package datastructures_isayenka_poluektova;

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