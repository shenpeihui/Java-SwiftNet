package com.swift.net.channle.initializer;

import java.util.HashMap;
import java.util.Map;

import com.swift.net.NetworkServiceType;

/**
 * 网络服务初始化器工厂
 * @ClassName: NetworkServerInitializerFactory
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月18日 下午7:29:22
 *
 */
public final class NetworkServiceInitializerFactory {
	
	
	private static class SingletonClassInstance {
		static final NetworkServiceInitializerFactory INSTANCE = new NetworkServiceInitializerFactory();
	}
	
	/**
	 * 读取单例
	 * @Title: getInstance
	 * @Description: TODO
	 * @param @return
	 * @return NetworkServerInitializerFactory
	 */
	public static NetworkServiceInitializerFactory getInstance() {
		return SingletonClassInstance.INSTANCE;
	}
	
	/**
	 * 网络服务初始化器容器
	 */
	private Map<Integer, Map<NetworkServiceType, NetworkChannleInitializer>> serviceInitializerMap;
	
	private NetworkServiceInitializerFactory() {
		this.serviceInitializerMap = new HashMap<>();
	}
	
	/**
	 * 添加网络服务初始化器
	 * @Title: addInitializer
	 * @Description: TODO
	 * @param type 网络服务类型
	 * @param initializer 初始化器
	 * @return void
	 */
	public void addInitializer(Integer networkServiceTag, NetworkChannleInitializer initializer) {
		Map<NetworkServiceType, NetworkChannleInitializer> initializerMap = this.serviceInitializerMap.get(networkServiceTag);
		
		if (initializerMap == null) {
			initializerMap = new HashMap<>();
			this.serviceInitializerMap.put(networkServiceTag, initializerMap);
		}

		initializerMap.put(initializer.getType(), initializer);
	}

	/**
	 * 获取网络服务初始化器
	 * @Title: getInitializer
	 * @Description: TODO
	 * @param type 网络服务类型
	 * @return Map<NetworkServiceType, NetworkChannleInitializer>
	 */
	public final Map<NetworkServiceType, NetworkChannleInitializer> getInitializerMap(Integer networkServiceTag) {
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
	public final NetworkChannleInitializer getInitializer(Integer networkServiceTag, NetworkServiceType type) {
		Map<NetworkServiceType, NetworkChannleInitializer> initializerMap = this.getInitializerMap(networkServiceTag);
		
		if (initializerMap == null) {
			return null;
		} else {
			return initializerMap.get(type);
		}
	}
	
}
