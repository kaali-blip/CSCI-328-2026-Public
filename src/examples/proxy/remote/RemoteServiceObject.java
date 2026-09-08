package examples.proxy.remote;

public class RemoteServiceObject implements RemoteService{
    @Override
    public String fetchData(){
        return "Data from a remote server";
    }
}
