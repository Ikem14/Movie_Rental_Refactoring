package bad.robot.refactoring.chapter1;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;


    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
		switch (priceCode) {
		    case CHILDREN:
		        price = new ChildrensPrice();
		        break;
		    case NEW_RELEASE:
		        price = new NewReleasePrice();
		        break;
		    case REGULAR:
		        price = new RegularPrice();
		        break;
		    default:
		        throw new IllegalArgumentException("invalid code");
		}
    }
    
    public double getCharge(int daysRented) {
    	double result = 0;
        switch (price.getPriceCode()) {
            case Movie.REGULAR:
           	 result += 2;
                if (daysRented > 2)
               	 result += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
           	 result += daysRented * 3;
                break;
            case Movie.CHILDREN:
           	 result += 1.5;
                if (daysRented > 3)
               	 result += (daysRented - 3) * 1.5;
                break;
        }
        return result; 
    }
    
    public int getFrequentRenterPoints(int daysRented) {
    	if (price.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
    		return 2;
    	}else return 1;
    }

}
