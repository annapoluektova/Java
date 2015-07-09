/*
 *    Natallia Isayenka
 *    Anna Poluektova     
 */

package datastructures_isayenka_poluektova;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class DataStructures_Isayenka_Poluektova {
    public static void main(String[] args) {
         JOptionPane.showMessageDialog(null, "Cruise ship booking system\n\n"
                   + "Natallia Isayenka \nAnna Poluektova");
        do {
            CreateReservation();
        } while(JOptionPane.showConfirmDialog(null, "Would you like to create another reservation?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    public static void CreateReservation() {
        int vesselNo = promptInt("Cruise Ship Number:", 0);
        String cruiseName = promptString("Cruise name:");
        String sourceCity = promptString("Source city:");
        String destinationCity = promptString("Destination City:");
        Date departureDate = promptDate("Departure date:", new Date());
        Date arrivalDate = promptDate("Arrival date:", departureDate);
        int cruiseLength = promptInt("Cruise length (in miles):", 100);
        Cruise cruise = new Cruise(vesselNo, cruiseName, sourceCity, destinationCity, departureDate, arrivalDate, cruiseLength);

        String fName = promptString("First name:");
        String lName = promptString("Last name:");
        int age = promptInt("Age:", 1);
        int fqNo = promptInt("Your frequent passenger number:", 1);
        double farePerTrip = 99.50; // Fare per trip [promptDouble("Fare:")]
        int points = 500; // Points collected per trip [promptInt("Points collected:")]
        FrequentPassenger frequentpassenger = new FrequentPassenger(fName, lName, age, farePerTrip, fqNo, points);

        double cmp = Math.round((frequentpassenger.GetFare() / cruise.length)*100)/100.0d;
        
        JOptionPane.showMessageDialog(null, cruise.toString() + "\n" + frequentpassenger.toString() + 
                "\nCost Per Mile: " + cmp + "$");
    }
    
    public static int promptInt(String message, int minValue) 
    {
         do {
            try {
                String ans = JOptionPane.showInputDialog(message);
                if (ans == null) { 
                    JOptionPane.showMessageDialog(null, "Application Exit"); 
                    System.exit(0); 
                }
                int answer = Integer.parseInt(ans);
                if (answer < minValue) {
                    JOptionPane.showMessageDialog(null, "Integer value is too low.\nTry again.");
                } else {
                    return answer;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Incorrect number format.\nTry again.");
            }
        } while(true);
    }
   
    public static double promptDouble(String message) 
    {
         do {
            try {
                String ans = JOptionPane.showInputDialog(message);
                if (ans == null) { 
                    JOptionPane.showMessageDialog(null, "Application Exit"); 
                    System.exit(0); 
                }
                double answer = Double.parseDouble(ans);
                return answer;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Incorrect number format.\nTry again.");
            }
        } while(true);
    }
    
    public static String promptString(String message) 
    {
         do {
            String ans = JOptionPane.showInputDialog(message);
            if (ans == null) { 
                JOptionPane.showMessageDialog(null, "Application Exit"); 
                System.exit(0); 
            } else if ("".equals(ans)) {
                JOptionPane.showMessageDialog(null, "This value cannot be empty.\nTry again."); 
            } else {
                return ans;
            }
        } while(true);
    }
    
    public static Date promptDate(String message, Date minValue) 
    {
         do {
            String ans = JOptionPane.showInputDialog(message + "    (YYYY-MM-DD format)");
           
            try {
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter1.parse(ans);
                String formattedDate = formatter1.format(date);
                System.out.println("yyyy-MM-dd date is ==>"+formattedDate);
                
               if (date.before(minValue)) {
                    JOptionPane.showMessageDialog(null, "Date is too early.\nTry again.");
               } else {
                   return date;
               }
                
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Incorrect date format.\nTry again.");
            }
        } while(true);
    }   

}