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
        EventLoopGroup bootgroup = new NioEventLoopGroup(1);
        EventLoopGroup workgroup = new NioEventLoopGroup();
        ServerBootstrap server = new ServerBootstrap()
                .group(bootgroup,workgroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast("encode",new ByteArrayDecoder())
                                .addLast("decode",new ByteArrayEncoder())
                                .addLast(new ServerHandler());
                    }
                });
        ChannelFuture channelFuture = server.bind(8081).sync();
        System.out.println(channelFuture.isSuccess());
        channelFuture.channel().closeFuture().sync();
    }

}
