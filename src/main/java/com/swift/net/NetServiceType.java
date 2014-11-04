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
public enum NetServiceType {

	/**
	 * Socket
	 */
	SOCKET("socket", SocketMessageEncode.class, SocketMessageDecode.class),

	/**
	 * Http
	 */
	HTTP("http", HttpMessageEncode.class, HttpMessageDecode.class);

	/**
	 * 名称
	 */
	private final String name;

	/**
	 * 消息编码器.class
	 */
	private final Class<? extends MessageEncode> encodeClass;

	/**
	 * 消息解码器.class
	 */
	private final Class<? extends MessageDecode> decodeClass;

	/**
	 * @param <T>
	 * @Title: TODO
	 * @Description: TODO
	 * 
	 * @param name
	 */
	private <T extends ChannelHandlerAdapter> NetServiceType(String name, Class<? extends MessageEncode> encodeClass,
			Class<? extends MessageDecode> decodeClass) {
		this.name = name;
		this.encodeClass = encodeClass;
		this.decodeClass = decodeClass;
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
	 * 
	 * @return MessageEncode
	 */
	public final MessageEncode getEncode() {
		try {
			return encodeClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取消息解码器
	 * 
	 * @return MessageDecode
	 */
	public final MessageDecode getDecode() {
		try {
			return decodeClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
