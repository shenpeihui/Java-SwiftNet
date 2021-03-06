package com.swift.net.channle.initializer;

import io.netty.channel.ChannelInboundHandlerAdapter;

import com.swift.net.NetServiceType;

/**
 * 服务端网络通道初始化器
 * @ClassName: NetworkChannleInitializer
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月19日 下午4:17:04
 *
 */
public class ServerChannleInitializer<CHANNEL_HANDLER extends ChannelInboundHandlerAdapter> extends NetChannleInitializer<CHANNEL_HANDLER> {

	/**
	 * 服务端网络通道初始化器
	 * @Title: TODO
	 * @Description: TODO
	 * 
	 * @param type 网络服务类型
	 * @param channelHandlerClass 通道处理.Class
	 */
	public ServerChannleInitializer(NetServiceType type, Class<? extends CHANNEL_HANDLER> channelHandlerClass) {
		super(type, channelHandlerClass);
	}

	@Override
	protected void clone(NetChannleInitializer<CHANNEL_HANDLER> initializer) {
		// TODO Auto-generated method stub
		
	}
}
