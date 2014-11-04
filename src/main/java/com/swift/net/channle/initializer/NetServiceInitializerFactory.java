package com.swift.net.channle.initializer;

import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.HashMap;
import java.util.Map;

import com.swift.net.NetServiceType;

/**
 * 网络服务初始化器工厂
 * @ClassName: NetworkServerInitializerFactory
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月18日 下午7:29:22
 *
 */
public final class NetServiceInitializerFactory {
	
	
	private static class SingletonClassInstance {
		static final NetServiceInitializerFactory INSTANCE = new NetServiceInitializerFactory();
	}
	
	/**
	 * 读取单例
	 * @Title: getInstance
	 * @Description: TODO
	 * @param @return
	 * @return NetworkServerInitializerFactory
	 */
	public static NetServiceInitializerFactory getInstance() {
		return SingletonClassInstance.INSTANCE;
	}
	
	/**
	 * 网络服务初始化器容器
	 */
	private Map<Integer, Map<NetServiceType, NetChannleInitializer<? extends ChannelInboundHandlerAdapter>>> serviceInitializerMap;
	
	private NetServiceInitializerFactory() {
		this.serviceInitializerMap = new HashMap<>();
	}
	
	/**
	 * 添加网络服务初始化器
	 * @param <CHANNEL_HANDLER>
	 * @Title: addInitializer
	 * @Description: TODO
	 * @param netServiceTag 网络服务标识
	 * @param initializer 初始化器
	 * @return void
	 */
	public void addInitializer(int netServiceTag, NetChannleInitializer<? extends ChannelInboundHandlerAdapter> initializer) {
		Map<NetServiceType, NetChannleInitializer<?>> initializerMap = this.serviceInitializerMap.get(netServiceTag);
		
		if (initializerMap == null) {
			initializerMap = new HashMap<>();
			this.serviceInitializerMap.put(netServiceTag, initializerMap);
		}
		
		NetServiceType type = initializer.getType();
		
		if (initializerMap.containsKey(type) ) {
			throw new RuntimeException("网络服务标识：" + netServiceTag + " 列表中已存在 " + type.getName() + " 服务！");
		}
		
		initializerMap.put(type, initializer);
	}

	/**
	 * 获取网络服务初始化器
	 * @param <CHANNEL_HANDLER>
	 * @Title: getInitializer
	 * @Description: TODO
	 * @param type 网络服务类型
	 * @return Map<NetworkServiceType, NetworkChannleInitializer>
	 */
	public final Map<NetServiceType, NetChannleInitializer<? extends ChannelInboundHandlerAdapter>> getInitializerMap(Integer networkServiceTag) {
		return this.serviceInitializerMap.get(networkServiceTag);
	}
	
	/**
	 * 获取网络服务初始化器
	 * @Title: getInitializer
	 * @Description: TODO
	 * @param networkServiceTag 网络服务标签
	 * @param type 网络服务类型
	 * @return NetworkChannleInitializer
	 */
	public final NetChannleInitializer<? extends ChannelInboundHandlerAdapter> getInitializer(Integer networkServiceTag, NetServiceType type) {
		Map<NetServiceType, NetChannleInitializer<? extends ChannelInboundHandlerAdapter>> initializerMap = this.getInitializerMap(networkServiceTag);
		
		NetChannleInitializer<? extends ChannelInboundHandlerAdapter> initializer = null;
		
		if (initializerMap != null) {
			initializer = initializerMap.get(type);
		}
		
		return initializer.copy();
	}
	
}
