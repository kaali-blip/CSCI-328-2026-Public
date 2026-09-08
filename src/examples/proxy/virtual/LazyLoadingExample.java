package examples.proxy.virtual;

public class LazyLoadingExample {
    
    public static void main(String[] args) {
        ImageInterface image = new ImageProxy();
        image.displayImage();
    }
    
}
