package com.swift.net.channle.initializer;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import com.swift.net.NetServiceType;

/**
 * 网络通道初始化器
 * @ClassName: NetworkChannleInitializer
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月19日 下午4:17:04
 *
 */
public abstract class NetChannleInitializer<CHANNEL_HANDLER extends ChannelInboundHandlerAdapter> extends ChannelInitializer<SocketChannel> implements Cloneable {

	/**
	 * 网络服务类型
	 */
	private NetServiceType type;
	
	/**
	 * 通道处理.Class
	 */
	private Class<? extends CHANNEL_HANDLER> channelHandlerClass;

	/**
	 * 网络通道初始化器
	 * @Title: TODO
	 * @Description: TODO
	 * 
	 * @param type 网络服务类型
	 * @param channelHandler 通道处理.Class
	 */
	public NetChannleInitializer(NetServiceType type, Class<? extends CHANNEL_HANDLER> channelHandlerClass) {
		super();
		this.type = type;
		this.channelHandlerClass = channelHandlerClass;
	}
	
	/**
	 * 获取网络服务类型
	 * @return NetworkServiceType
	 */
	public final NetServiceType getType() {
		return type;
	}
	
	@SuppressWarnings("unchecked")
	public NetChannleInitializer<CHANNEL_HANDLER> copy() {
		NetChannleInitializer<CHANNEL_HANDLER> initializer = null;
		try {
			initializer = (NetChannleInitializer<CHANNEL_HANDLER>) clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return initializer;
	}

	/**
	 * 克隆处理
	 * @param initializer
	 * @author shenpeihui
	 */
	protected abstract void clone(NetChannleInitializer<CHANNEL_HANDLER> initializer);
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		pipeline.addLast(this.type.getEncode());
		pipeline.addLast(this.type.getDecode());
		pipeline.addLast(channelHandlerClass.newInstance());
	}
}
