package com.swift.net;

import io.netty.channel.ChannelHandlerAdapter;

import com.swift.net.coder.MessageDecode;
import com.swift.net.coder.MessageEncode;
import com.swift.net.http.coder.HttpMessageDecode;
import com.swift.net.http.coder.HttpMessageEncode;
import com.swift.net.socket.coder.SocketMessageDecode;
import com.swift.net.socket.coder.SocketMessageEncode;

/**
 * 网络服务类型
 * 
 * @ClassName: NetworkServiceType
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月18日 下午6:44:16
 *
 */
public enum NetworkServiceType {

	/**
	 * Socket
	 */
	SOCKET("socket", new SocketMessageEncode(), new SocketMessageDecode()),

	/**
	 * Http
	 */
	HTTP("http", new HttpMessageEncode(), new HttpMessageDecode());

	/**
	 * 名称
	 */
	private final String name;

	/**
	 * 消息编码器
	 */
	private final MessageEncode encode;

	/**
	 * 消息解码器
	 */
	private final MessageDecode decode;

	/**
	 * @param <T>
	 * @Title: TODO
	 * @Description: TODO
	 * 
	 * @param name
	 */
	private <T extends ChannelHandlerAdapter> NetworkServiceType(String name, MessageEncode encode, MessageDecode decode) {
		this.name = name;
		this.encode = encode;
		this.decode = decode;
	}

	/**
	 * 获取名称
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 获取消息编码器
	 * @return MessageEncode
	 */
	public final MessageEncode getEncode() {
		return encode;
	}

	/**
	 * 获取消息解码器
	 * @return MessageDecode
	 */
	public final MessageDecode getDecode() {
		return decode;
	}


	// /**
	// * Socket
	// */
	// SOCKET("socket"),
	//
	// /**
	// * Http
	// */
	// HTTP("http");
	//
	// /**
	// * 名称
	// */
	// private final String name;
	//
	// /**
	// * @param <T>
	// * @Title: TODO
	// * @Description: TODO
	// *
	// * @param name
	// */
	// private <T extends ChannelHandlerAdapter> NetworkServiceType(String name)
	// {
	// this.name = name;
	// }
	//
	// /**
	// * 获取名称
	// *
	// * @return String
	// */
	// public String getName() {
	// return name;
	// }

}
