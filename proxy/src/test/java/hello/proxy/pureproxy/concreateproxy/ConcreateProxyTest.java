package hello.proxy.pureproxy.concreateproxy;

import hello.proxy.pureproxy.concreateproxy.code.ConcreateClient;
import hello.proxy.pureproxy.concreateproxy.code.ConcreateLogic;
import org.junit.jupiter.api.Test;

public class ConcreateProxyTest {
    @Test
    void noProxy() {
        ConcreateLogic concreateLogic = new ConcreateLogic();
        ConcreateClient client = new ConcreateClient(concreateLogic);
        client.execute();
    }
}
