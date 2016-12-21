package kael.leap.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import kael.leap.netty.server.service.Services;
import leap.core.annotation.Inject;
import leap.core.annotation.M;

/**
 * Created by kael on 2016/12/21.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Inject
    @M
    private Services services;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof FullHttpRequest){
            FullHttpRequest request = (FullHttpRequest)msg;
            HttpResponse response = services.service(ctx,request);
            ctx.write(response);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}
