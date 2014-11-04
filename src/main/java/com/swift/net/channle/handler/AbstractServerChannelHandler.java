package com.swift.net.channle.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 抽象：服务端通道处理
 * 
 * @ClassName: ChannelHandler
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月19日 下午4:52:14
 *
 */
public abstract class AbstractServerChannelHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 异常捕获
	 * 
	 * @param cause
	 *            异常
	 * @author shenpeihui
	 */
	public abstract void exceptionCaught(Throwable cause);

	/**
	 * 接收消息
	 * 
	 * @param msg
	 *            接收到的消息
	 * @author shenpeihui
	 */
	public abstract void receive(ByteBuf rcvData);

	/**
	 * 注册链接通道
	 * 
	 * @author shenpeihui
	 */
	public abstract void registered();

	/**
	 * 激活链接通道
	 * 
	 * @author shenpeihui
	 */
	public abstract void active();

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();

		exceptionCaught(cause);

		cause.printStackTrace();// 捕捉异常信息
		ctx.close();// 出现异常时关闭channel
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf rcvData = (ByteBuf) msg;

		receive(rcvData);

		rcvData.release();

		ctx.write(msg); // 写回数据
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelReadComplete(ctx);

		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER) // flush掉所有写回的数据
				.addListener(ChannelFutureListener.CLOSE); // 当flush完成后关闭channel

	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		super.channelRegistered(ctx);
		System.out.println("进来一个客户端 : channelRegistered");

		registered();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		System.out.println("进来一个客户端 : channelActive");

		active();
	}
}
