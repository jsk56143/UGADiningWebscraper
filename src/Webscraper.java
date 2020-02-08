import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Webscraper {

    private static final String url = "https://dining.uga.edu/locations/build-your-plate";
    private static final Logger[] PINNED_LOGGERS;
    static {
        System.setProperty("org.apache.commons.logging.simplelog.defaultlog", "fatal");
        PINNED_LOGGERS = new Logger[]{
                Logger.getLogger("com.gargoylesoftware.htmlunit"),
                Logger.getLogger("org.apache.http")
        };

        for (Logger l : PINNED_LOGGERS) {
            l.setLevel(Level.OFF);
        }
    }
    public static void main(String[] args) {
        //WebClient client = new WebClient();
        //client.getOptions().setJavaScriptEnabled(true);
        //client.getOptions().setCssEnabled(false);
        //client.getOptions().setUseInsecureSSL(false);
        try {
            //HtmlPage page = client.getPage(url);
            //System.out.println(page.asXml());
            final WebClient webClient = new WebClient(BrowserVersion.CHROME);
            webClient.getOptions().setJavaScriptEnabled(true);
            final HtmlPage page = webClient.getPage("https://dining.uga.edu");
            //final HtmlDivision div = (HtmlDivision) page.getByXPath("//div[@name='ui-datepicker-calendar']").get(0);
            if (page != null) {
                final HtmlTable table = (HtmlTable) page.getByXPath("//table[@class='ui-datepicker-calendar']").get(0);//getHtmlElementById("loginform");
                System.out.println("Cell (2,1)=" + table.getCellAt(2, 1));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
    //test
}
