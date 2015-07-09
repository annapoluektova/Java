package pkg2130_f13a2_nick_athanasios_anna_alex;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cruise {
    int vesselNo, length;
    String cruiseName, sourceCity, destinationCity;
    Date departureDate = new Date(), arrivalDate = new Date();
    
    public Cruise(int vesselNo, String cruiseName, String sourceCity, String destinationCity,
                  Date departureDate, Date arrivalDate, int length) {
        this.vesselNo = vesselNo;
        this.cruiseName = cruiseName;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.length = length;
    }
    
    @Override public String toString() {
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
        
        return "Vessel number: " + vesselNo + "\nName of cruise: " + cruiseName +
                "\nSource city: " + sourceCity + "\nDestination city: " + destinationCity
                 + "\nDeparture date: " + formatter1.format(departureDate)
                 + "\nArrival date: " + formatter1.format(arrivalDate);
    }
}
