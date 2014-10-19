package com.swift.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swift.net.channle.initializer.NetworkServiceInitializerFactory;

/**
 * 实现：网络服务
 * 
 * @ClassName: NetworkServiceImpl
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月18日 下午6:53:53
 *
 */
public class NetworkServiceImpl implements NetworkService {

	/**
	 * Log4j
	 */
	static Logger logger = LoggerFactory.getLogger(NetworkService.class);

	/**
	 * 网络服务标签
	 */
	private Integer networkServiceTag;

	/**
	 * 网络服务类型
	 */
	private NetworkServiceType networkServiceType;

	/**
	 * 监听主机
	 */
	private String host;

	/**
	 * 监听端口
	 */
	private int port;

	/**
	 * 网络服务器
	 * 
	 * @Title: TODO
	 * @Description: TODO
	 * 
	 * @param networkServiceTag
	 *            网络服务标签
	 * @param networkServiceType
	 *            网络服务类型
	 * @param host
	 *            监听主机
	 * @param port
	 *            监听端口
	 */
	public NetworkServiceImpl(Integer networkServiceTag, NetworkServiceType networkServiceType, String host, int port) {
		super();
		this.networkServiceTag = networkServiceTag;
		this.networkServiceType = networkServiceType;
		this.host = host;
		this.port = port;
	}

	public void listening() throws InterruptedException {

		switch (this.networkServiceType) {
		case SOCKET:
		case HTTP:
			this.runSocket();
			break;

		default:
			break;
		}

		// 输出网络服务信息
		StringBuffer buffer = new StringBuffer();

		buffer.append("运行 ")
			.append(this.networkServiceType.getName())
			.append(" 网络服务成功，监听主机：")
			.append(this.host)
			.append(" ， 端口：")
			.append(this.port)
			.append(" ！");

		System.out.println(buffer.toString());
	}

	private void runSocket() throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		ServerBootstrap bootstrap = new ServerBootstrap();

		ChannelInitializer<SocketChannel> initializer = NetworkServiceInitializerFactory.getInstance().getInitializer(
				this.networkServiceTag, this.networkServiceType);
		
		bootstrap.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(initializer)
			.option(ChannelOption.SO_BACKLOG, 1024)
			.childOption(ChannelOption.SO_KEEPALIVE, true);

		bootstrap.bind(this.host, this.port).sync();
	}
}
