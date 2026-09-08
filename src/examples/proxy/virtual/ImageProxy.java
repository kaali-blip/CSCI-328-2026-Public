package examples.proxy.virtual;

public class ImageProxy implements ImageInterface {
    private LargeImage image;

    @Override
    public void displayImage(){
        if (image == null){
            image = new LargeImage();
        }

        image.displayImage();
    }
}
