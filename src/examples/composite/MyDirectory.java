package examples.composite;

import java.util.ArrayList;
import java.util.List;

public class MyDirectory implements FileSystemNode{
    private final String name;
    private final List<FileSystemNode> children = new ArrayList<>();

    public MyDirectory(String name) {
        this.name = name;
    }

    public void add(FileSystemNode node) {
        children.add(node);
    }

    @Override
    public void show() {
        System.out.println(name + "/");
        for (FileSystemNode node : children) {
            node.show();
        }
    }
}
