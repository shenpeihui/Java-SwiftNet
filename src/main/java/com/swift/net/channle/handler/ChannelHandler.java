package com.swift.net.channle.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 抽象：通道处理
 * @ClassName: ChannelHandler
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月19日 下午4:52:14
 *
 */
public abstract class ChannelHandler extends ChannelInboundHandlerAdapter {
	
	
	public abstract void exceptionCaught(Throwable cause);
	
	public abstract void channelRead(Object msg);
	
	public abstract void channelRegistered();
	
	public abstract void channelActive();

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		((ByteBuf) msg).release();
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		super.channelRegistered(ctx);
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}
}
