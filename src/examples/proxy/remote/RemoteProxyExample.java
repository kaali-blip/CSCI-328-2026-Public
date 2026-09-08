package examples.proxy.remote;

public class RemoteProxyExample {
    public static void main(String[] args) {
        RemoteService service = new RemoteProxy(new RemoteServiceObject());

        System.out.println(service.fetchData());
    }
}
