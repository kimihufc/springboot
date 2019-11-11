package com.hjl.transport;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-12
 * Time: 下午6:56
 * Description:
 */
public class NettyServer {

    public static void main(String[] args) throws Exception{
//        EventLoopGroup bootgroup = new NioEventLoopGroup(1);
//        EventLoopGroup workgroup = new NioEventLoopGroup();
//        ServerBootstrap server = new ServerBootstrap()
//                .group(bootgroup,workgroup)
//                .channel(NioServerSocketChannel.class)
//                .option(ChannelOption.SO_BACKLOG, 128)
//                .childHandler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        socketChannel.pipeline()
//                                .addLast("encode",new ByteArrayDecoder())
//                                .addLast("decode",new ByteArrayEncoder())
//                                .addLast(new ServerHandler());
//                    }
//                });
//        ChannelFuture channelFuture = server.bind(8081).sync();
//        System.out.println(channelFuture.isSuccess());
//        channelFuture.channel().closeFuture().sync();
    EventLoopGroup boot = new NioEventLoopGroup(1);
    EventLoopGroup worker = new NioEventLoopGroup();
    ServerBootstrap server = new ServerBootstrap();
    server.group(boot,worker)
            .channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(new ChannelInboundHandler() {
                        @Override
                        public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
                            System.out.println("register one");
                        }

                        @Override
                        public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {

                        }

                        @Override
                        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {

                        }

                        @Override
                        public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {

                        }

                        @Override
                        public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
                            System.out.println(o.toString());
                        }

                        @Override
                        public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {

                        }

                        @Override
                        public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

                        }

                        @Override
                        public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {

                        }

                        @Override
                        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

                        }

                        @Override
                        public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {

                        }

                        @Override
                        public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

                        }
                    });
                }
            }).bind(8081).sync();
    }

}
