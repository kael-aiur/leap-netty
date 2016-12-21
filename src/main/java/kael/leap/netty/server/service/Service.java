package kael.leap.netty.server.service;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

/**
 * Created by kael on 2016/12/21.
 */
public interface Service {
    HttpResponse service(ChannelHandlerContext ctx,HttpRequest request);
    boolean match(HttpRequest request);
}
