package examples.composite;

public class FileSystemTest {
    public static void main(String[] args) {
        MyDirectory root = new MyDirectory("root");
        root.add(new MyFile("readme.txt"));
        MyDirectory src = new MyDirectory("src");
        root.add(src);

        root.show();
    }
}
