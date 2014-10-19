package com.swift.net.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Socket服务处理器
 * @ClassName: SocketServerHandler
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月19日 上午8:00:32
 *
 */
public class HttpServerHandler extends ChannelInboundHandlerAdapter  {

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		((ByteBuf) msg).release();
	}

}
