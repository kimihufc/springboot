package com.hjl.transport;

import com.alibaba.dubbo.common.json.JSON;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-12
 * Time: 下午7:19
 * Description:
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String result="";
        //接收到完成的http请求
        FullHttpRequest httpRequest = (FullHttpRequest)msg;

        try{
            String path = httpRequest.uri();
            String body = httpRequest.content().toString(CharsetUtil.UTF_8);
            HttpMethod method = httpRequest.method();
            if(!"/test".equalsIgnoreCase(path)){
                result = "非法请求："+path;
                send(result,ctx,HttpResponseStatus.BAD_REQUEST);
                return;
            }

            //处理http GET请求
            if(HttpMethod.GET.equals(method)){
                System.out.println("body:"+body);
                result="Get request,Response=";
                send(result,ctx,HttpResponseStatus.OK);
            }

            //处理http POST请求
            if(HttpMethod.POST.equals(method)){
                //.....

            }

        }catch(Exception e){
            System.out.println("处理请求失败!");
            e.printStackTrace();
        }finally{
            httpRequest.release();
        }
        ctx.writeAndFlush("hello");
    }
    private void send(String content, ChannelHandlerContext ctx,
                      HttpResponseStatus status){
        FullHttpResponse response =
                new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,status,
                        Unpooled.copiedBuffer(content,CharsetUtil.UTF_8));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE,
                "text/plain;charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);

    }
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("******complate******");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("***********");
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("begfin");
    }
}
