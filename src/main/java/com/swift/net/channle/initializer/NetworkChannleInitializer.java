package com.swift.net.channle.initializer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import com.swift.net.NetworkServiceType;
import com.swift.net.channle.handler.ChannelHandler;

/**
 * 网络通道初始化器
 * @ClassName: NetworkChannleInitializer
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月19日 下午4:17:04
 *
 */
public abstract class NetworkChannleInitializer extends ChannelInitializer<SocketChannel> {

	/**
	 * 网络服务类型
	 */
	private NetworkServiceType type;
	
	/**
	 * 通道处理
	 */
	private ChannelHandler channelHandler;

	/**
	 * 网络通道初始化器
	 * @Title: TODO
	 * @Description: TODO
	 * 
	 * @param type 网络服务类型
	 * @param channelHandler 通道处理
	 */
	public NetworkChannleInitializer(NetworkServiceType type, ChannelHandler channelHandler) {
		super();
		this.type = type;
		this.channelHandler = channelHandler;
	}
	
	/**
	 * 获取网络服务类型
	 * @return NetworkServiceType
	 */
	public final NetworkServiceType getType() {
		return type;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast(this.type.getEncode());
		pipeline.addLast(this.type.getDecode());
		pipeline.addLast(channelHandler);
	}
}
