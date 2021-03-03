import com.srpc.api.HelloService;
import com.srpc.api.NotHelloService;
import com.srpc.core.server.RpcServer;
import com.srpc.server.HelloServiceImpl;
import com.srpc.server.NotOnlyHelloService;
import org.junit.Test;

public class TestServer {
    @Test
    public void testServer() {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }

    @Test
    public void testServer2() {
        RpcServer rpcServer = new RpcServer();
        NotHelloService notHelloService = new NotOnlyHelloService();
        rpcServer.register(notHelloService, 9001);
    }
}
