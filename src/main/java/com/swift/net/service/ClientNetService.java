package com.swift.net.service;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

import com.swift.net.NetServiceType;
import com.swift.net.channle.initializer.NetServiceInitializerFactory;

/**
 * 客户端网络服务
 * @author shenpeihui
 *
 */
public class ClientNetService extends NetService {

	/**
	 * 客户端网络服务
	 * 
	 * @param serviceName 网络服务名
	 * @param netServiceTag 网络服务标签
	 * @param netServiceType 网络服务类型
	 * @param host 监听主机
	 * @param port 监听端口
	 * @author shenpeihui
	 */
	public ClientNetService(String serviceName, int netServiceTag, NetServiceType netServiceType, String host, int port) {
		super(serviceName, netServiceTag, netServiceType, host, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void runSocket() {
		// TODO Auto-generated method stub
		EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            
			ChannelInitializer<SocketChannel> initializer = NetServiceInitializerFactory.getInstance().getInitializer(super.netServiceTag, super.netServiceType);
            
			bootstrap.group(group);
			bootstrap.channel(NioSocketChannel.class);
			bootstrap.remoteAddress(new InetSocketAddress(host, port));
			bootstrap.handler(initializer);
			
			ChannelFuture f = bootstrap.connect().sync();
			
//			f.addListener(new ChannelFutureListener() {
//
//				public void operationComplete(ChannelFuture future) throws Exception {
//					if (future.isSuccess()) {
//						System.out.println("client connected");
//					} else {
//						System.out.println("server attemp failed");
//						future.cause().printStackTrace();
//					}
//
//				}
//			});
//			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } finally {
//            group.shutdownGracefully().sync();
        }
	}


}
