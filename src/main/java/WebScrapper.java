import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.net.URLEncoder;
import java.util.List;

public class WebScrapper {

    private static final String searchQuery = "guitar";
    private static final String baseUrl = "https://chicago.craigslist.org/d/for-sale/search/sss?sort=rel&query=";


    public static void main(String[] args) {

        WebClient webClient = new WebClient();
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setUseInsecureSSL(true);

        try{
            HtmlPage htmlPage = webClient.getPage(baseUrl + URLEncoder.encode(searchQuery,"UTF-8"));
            @SuppressWarnings("unchecked")
            List<HtmlElement> listOfItems = (List<HtmlElement>) htmlPage.getByXPath("//li[@class='result-row']");
            if(listOfItems.isEmpty()){
                System.out.println("No items found");
            }else{
                for(HtmlElement htmlItem : listOfItems){
                    HtmlAnchor itemAnchor = htmlItem.getFirstByXPath(".//div[@class='result-info']/h3/a");
                    HtmlElement spanPrice = htmlItem.getFirstByXPath(".//div/span/span[@class='result-price']");

                    String itemPrice = spanPrice == null ? "0.0": spanPrice.asText();

                    Items item = new Items();
                    item.setTitle(itemAnchor.asText());
                    item.setUrl(baseUrl + itemAnchor.getHrefAttribute());

                    //item.setPrice(new String(itemPrice.replace("$",""))); without $ dollar sign
                    item.setPrice(itemPrice);

                    ObjectMapper mapper = new ObjectMapper();
                    String jsonString = mapper.writeValueAsString((item));

                    System.out.println(jsonString);
                }

            }
            //System.out.println(htmlPage.asXml());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

