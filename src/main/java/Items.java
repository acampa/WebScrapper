import java.math.BigDecimal;

public class Items {
    private String title;
    private BigDecimal price;
    private String Url;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public String getUrl(){
        return Url;
    }
    public void setUrl(String Url){
        this.Url = Url;
    }
}