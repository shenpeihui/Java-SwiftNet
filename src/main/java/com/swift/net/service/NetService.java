package com.swift.net.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.swift.net.NetServiceType;

/**
 * 抽象：网络服务
 * @ClassName: NetService
 * @Description: TODO
 * @author shenpeihui
 * @date 2014年10月18日 下午6:53:10
 *
 */
public abstract class NetService extends Thread {
	
	/**
	 * Log4j
	 */
	protected static Logger logger = LoggerFactory.getLogger(NetService.class);

	/**
	 * 网络服务名
	 */
	protected final String serviceName;
	
	/**
	 * 网络服务标签
	 */
	protected final int netServiceTag;

	/**
	 * 网络服务类型
	 */
	protected final NetServiceType netServiceType;

	/**
	 * 监听主机
	 */
	protected final String host;

	/**
	 * 监听端口
	 */
	protected final int port;

	/**
	 * 网络服务器
	 * 
	 * @Title: TODO
	 * @Description: TODO
	 * 
	 * @param serviceName 网络服务名
	 * @param netServiceTag 网络服务标签
	 * @param netServiceType 网络服务类型
	 * @param host 监听主机
	 * @param port 监听端口
	 */
	public NetService(String serviceName, int netServiceTag, NetServiceType netServiceType, String host, int port) {
		super();
		this.serviceName = serviceName;
		this.netServiceTag = netServiceTag;
		this.netServiceType = netServiceType;
		this.host = host;
		this.port = port;
	}
	
	/**
	 * 生成运行日志
	 * 
	 * @author shenpeihui
	 */
	protected void generateRunLog() {
		// 输出网络服务信息
		StringBuffer buffer = new StringBuffer();

		buffer.append(serviceName);
		buffer.append(" service run success! ");
		buffer.append("Network service tag to ");
		buffer.append(netServiceTag);
		buffer.append(", ");
		buffer.append("service type to ");
		buffer.append(netServiceType.getName());
		buffer.append(", listen to host ");
		buffer.append(host);
		buffer.append(", port ");
		buffer.append(port);
		buffer.append(".");

		System.out.println(buffer.toString());
	}
	
	@Override
	public void run() {
		// TODO 运行处理
		switch (netServiceType) {
		case SOCKET:
		case HTTP:
			runSocket();
			break;

		default:
			break;
		}
		
		generateRunLog();
	}

	/**
	 * 
	 * @Title: 监听网络服务
	 * @Description: TODO
	 * @return void
	 * @throws InterruptedException
	 */
	public final void listening() throws InterruptedException {

		switch (netServiceType) {
		case SOCKET:
		case HTTP:
			runSocket();
			break;

		default:
			break;
		}

		// 输出网络服务信息
		StringBuffer buffer = new StringBuffer();

		buffer.append("运行 ")
			.append(netServiceType.getName())
			.append(" 网络服务成功，监听主机：")
			.append(host)
			.append(" ， 端口：")
			.append(port)
			.append(" ！");

		System.out.println(buffer.toString());
	}
	
	/**
	 * 运行socket
	 * @throws InterruptedException
	 * @author shenpeihui
	 */
	protected abstract void runSocket();
}
