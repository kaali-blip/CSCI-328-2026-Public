package examples.composite;

public class MyFile implements FileSystemNode {

    private final String name;

    public MyFile(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(name);
    }
}
