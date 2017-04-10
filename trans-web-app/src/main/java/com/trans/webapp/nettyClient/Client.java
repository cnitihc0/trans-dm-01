package com.trans.webapp.nettyClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;


/**
 * @author mashaobo
 * @date 17/3/9
 * @blog http://blog.csdn.net/cnitihc0
 * @email cnitihc0@163.com
 */
public class Client {

    public static void bind() {

    }

    public static void main(String[] args) {
        int port = 8000;
        String host = "127.0.0.1";
        try {
            new Client().connect(port, host);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connect(int port, String host) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();

            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });

            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();

            // 等待客户端链路关闭
            f.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully();
        }
    }

}
