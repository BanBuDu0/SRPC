import com.srpc.api.HelloObject;
import com.srpc.api.HelloService;
import com.srpc.api.NotHelloService;
import com.srpc.core.client.RpcClientProxy;
import org.junit.Test;

public class TestClient {
    @Test
    public void testClient() {
        RpcClientProxy rpcClientProxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject helloObject = new HelloObject(12, "Message for test!!");
        String res = helloService.sayHello(helloObject);
        System.out.println(res);
        String ss = helloService.sayString("123123");
        System.out.println(ss);

        RpcClientProxy rpcClientProxy1 = new RpcClientProxy("127.0.0.1", 9001);
        NotHelloService notHelloService = rpcClientProxy1.getProxy(NotHelloService.class);
        System.out.println(notHelloService.notOnlySayHello(2));
    }
}
