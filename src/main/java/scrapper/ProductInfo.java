package scrapper;

import java.math.BigDecimal;

public class ProductInfo {
    private String title;
    private String url;
    private BigDecimal price;

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
