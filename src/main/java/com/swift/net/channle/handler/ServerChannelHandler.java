package com.swift.net.channle.handler;

import io.netty.channel.ChannelHandlerContext;

import java.net.SocketAddress;


/**
 * 抽象：服务端通道处理
 * @ClassName: ChannelHandler
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月19日 下午4:52:14
 *
 */
public abstract class ServerChannelHandler extends ChannelHandler {

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		super.channelRegistered(ctx);
		SocketAddress socketAddress = ctx.channel().localAddress();
		System.out.println("进来一个客户端：channelRegistered : " + socketAddress.toString());
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		System.out.println("进来一个客户端：channelActive");
	}
}
