package assignments.decorator_pattern;

public class HtmlString {
    private String htmlString;

    public HtmlString(String htmlString){
        this.htmlString = htmlString;
    }

    public String toString(){
        return htmlString;
    }

}
