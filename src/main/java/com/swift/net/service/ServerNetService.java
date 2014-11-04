package com.swift.net.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import com.swift.net.NetServiceType;
import com.swift.net.channle.initializer.NetServiceInitializerFactory;

/**
 * 服务端网络服务
 * 
 * @ClassName: NetworkServiceImpl
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月18日 下午6:53:53
 *
 */
public class ServerNetService extends NetService {

	/**
	 * 服务端网络服务
	 * 
	 * @param serviceName 网络服务名
	 * @param netServiceTag 网络服务标签
	 * @param netServiceType 网络服务类型
	 * @param host 监听主机
	 * @param port 监听端口
	 */
	public ServerNetService(String serviceName, Integer netServiceTag, NetServiceType netServiceType, String host, int port) {
		super(serviceName, netServiceTag, netServiceType, host, port);
		// TODO Auto-generated constructor stub
	}

	protected void runSocket(){
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
	
			ServerBootstrap bootstrap = new ServerBootstrap();
	
			ChannelInitializer<SocketChannel> initializer = NetServiceInitializerFactory.getInstance().getInitializer(
					super.netServiceTag, super.netServiceType);
			
			bootstrap.group(bossGroup, workerGroup);
			bootstrap.channel(NioServerSocketChannel.class);
			bootstrap.childHandler(initializer);
			bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
			bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);

			bootstrap.bind(this.host, this.port).sync();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
