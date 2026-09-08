package examples.proxy.remote;

public class RemoteProxy implements RemoteService {
    // Final to make it immutable
    private final RemoteService service;

    public RemoteProxy(RemoteService service){
        this.service = service;
    }

    @Override
    public String fetchData(){
        System.out.println("Establishing network connection");
        System.out.println("Connecting...");
        System.out.println("Connecting...");
        System.out.println("Connected!");

        return service.fetchData();
    }
}
