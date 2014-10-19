package com.swift.net.channle.initializer;

import com.swift.net.NetworkServiceType;
import com.swift.net.channle.handler.ServerChannelHandler;

/**
 * 服务端网络通道初始化器
 * @ClassName: NetworkChannleInitializer
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月19日 下午4:17:04
 *
 */
public class ServerChannleInitializer extends NetworkChannleInitializer {

	/**
	 * 服务端网络通道初始化器
	 * @Title: TODO
	 * @Description: TODO
	 * 
	 * @param type 网络服务类型
	 * @param channelHandler 通道处理
	 */
	public ServerChannleInitializer(NetworkServiceType type, ServerChannelHandler channelHandler) {
		super(type, channelHandler);
	}
}
