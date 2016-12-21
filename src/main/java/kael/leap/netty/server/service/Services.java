package kael.leap.netty.server.service;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import leap.core.annotation.Inject;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created by kael on 2016/12/21.
 */
public class Services {
    @Inject
    private Service[] services;

    public HttpResponse service(ChannelHandlerContext ctx, HttpRequest request){
        for(Service service : services){
            if(service.match(request)){
                return service.service(ctx,request);
            }
        }
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, HttpResponseStatus.NOT_FOUND,
                Unpooled.wrappedBuffer("service not found".getBytes()));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN);
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        return response;
    }

}
