package Main;

public class Comics implements java.io.Serializable {
    private static final long serialVersionUID = 4L;

    String comic;
    String genre;
    int year;
    String language;
    double rating;
    double price;
    String publisher;
    int stock;

    public Comics(String comic, String genre, int year, String language, double rating, double price, String publisher, int stock) {
        this.comic = comic;
        this.genre = genre;
        this.year = year;
        this.language = language;
        this.rating = rating;
        this.price = price;
        this.publisher = publisher;
        this.stock = stock;
    }

    void buy(int odrNumber) {
        if (odrNumber <= 0) {
            System.out.println("Please enter a positive number to buy.");
            return;
        }
        if (odrNumber > stock) {
            System.out.println("Stock Out!!! Available: " + stock);
        } else {
            System.out.println("Thanks for Buying This Comic. Hope you will enjoy it.");
            stock -= odrNumber;
        }
    }

    void changePrice(double pre) {
        if (pre < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }
        price = pre;
    }

    void display() {
        System.out.println("Comic Name : " + comic + "\nGenre : " + genre + "\nYear : " + year + "\nLanguage : " + language + "\nRating : " + rating + "\nPublisher : " + publisher + "\nPrice : " + price + " BDT");
        System.out.println("Stock : " + stock);
        System.out.println("***************************************\n");
    }
}