package kael.leap.netty;

import kael.leap.netty.server.HttpServer;
import leap.core.AppContext;

/**
 * Created by kael on 2016/12/21.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AppContext context = AppContext.initStandalone();
        HttpServer server = new HttpServer(context);
        server.start(8080);
    }
}
