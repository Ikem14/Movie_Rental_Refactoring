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
    	return price.getCharge(daysRented);
    }
    
    public int getFrequentRenterPoints(int daysRented) {
    	if (price.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
    		return 2;
    	}else return 1;
    }

}
