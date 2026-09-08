package examples.proxy.virtual;

public class LargeImage implements ImageInterface {
    public LargeImage(){
        System.out.println("Loading image from disk");
    }

    @Override
    public void displayImage(){
        System.out.println("                _     ");
        System.out.println("    __   ___.--'_`.   ");
        System.out.println("    ( _`.'. -   'o` )  ");
        System.out.println("    _\\.'_'      _.-'   ");
        System.out.println("    ( \\`. )    //\\`     ");
        System.out.println("    \\_`-'`---'\\\\__,    ");
        System.out.println("    \\`        `-\\     ");
        System.out.println("    `                ");
    }
}
