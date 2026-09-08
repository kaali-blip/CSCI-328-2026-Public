package assignments.decorator_pattern;

public class HtmlTagTest {
    public static void main(String[] args) {
        HtmlString helloWorld = new HtmlString("Hello World");
        HtmlString boldText = new HtmlString("Bold");
        HtmlString italicsText = new HtmlString("Italics");
        HtmlString boldItalicsText = new HtmlString("Bold and Italics");

        /*TODO:
            - Add the ability to add certain html tags to the base string
            - ex: Hello World should become <b>Hello World</b>
            - need to add tags for the following HTML
                - Bold      
                    - <b></b>
                - Italics   
                    - <i></i>
                - Strikethrough 
                    - <s></s>
                - Superscript
                    - <sup></sup>

            - Add examples of the rest
        */

        System.out.println(helloWorld);
        System.out.println(boldText);
        System.out.println(italicsText);
        System.out.println(boldItalicsText);



    }

}
