import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Webscraper {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://apps.auxiliary.uga.edu/Dining/BuildYourPlate/index.php/nutrition").get();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if (doc != null){
            System.out.println("It works!");
        }

    }
    //test
}
