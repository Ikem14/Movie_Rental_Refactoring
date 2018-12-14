package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }
    
    public String statement() {
        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            Rental each = rental;
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
    }
    
    public String htmlStatement() {
    	String result = "<h1>Rental record for <b>" + getName() + "</b></h1>\n";
    	for (Rental rental : rentals) {
            result += "<p>" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "</p>\n";
    	}
        result += "<p>Amount owed is <b>" + String.valueOf(getTotalCharge()) + "</b></p>\n";
        result += "<p>You earned <b>" + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points</b></p>";
        return result;
    }
    
    public double amountFor(final Rental aRental) {
    	 return aRental.getCharge();
    }
    
    public double getTotalCharge() {
		double total= 0;
    	for (Rental rental : rentals) {
            total += rental.getCharge();
        }
    	return total;
    }
    
    public int getTotalFrequentRenterPoints() {
    	int total = 0;
    	for (Rental rental : rentals) {
            total += rental.getFrequentRenterPoints();
        }
    	return total;
    }

}
