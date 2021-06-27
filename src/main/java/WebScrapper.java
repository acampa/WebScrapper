import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.nodes.Document;
import java.net.URLEncoder;


public class WebScrapper {

    private static final String searchQuery = "women's socks";
    private static final String baseUrl = "https://www.aliexpress.com/wholesale?catId=0&initiative_id=&SearchText=";


    public static void main(String[] args) {

        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(5000);
        //webClient.getOptions().setCssEnabled(false);
        //webClient.getOptions().setUseInsecureSSL(true);


        try{
            HtmlPage htmlPage = webClient.getPage(baseUrl + URLEncoder.encode(searchQuery,"UTF-8"));
            @SuppressWarnings("unchecked")
            HtmlElement elementData = (HtmlElement) htmlPage.getByXPath("//script[@type='text/javascript']").get(2);
            System.out.println(elementData.asXml());
            if(elementData.asText().isEmpty()){
                System.out.println("No items found");
            }else{

            }
            //System.out.println(htmlPage.asXml());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

