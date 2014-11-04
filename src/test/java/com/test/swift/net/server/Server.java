package com.test.swift.net.server;

import com.swift.net.NetServiceType;
import com.swift.net.channle.initializer.NetServiceInitializerFactory;
import com.swift.net.channle.initializer.ServerChannleInitializer;
import com.swift.net.service.NetService;
import com.swift.net.service.ServerNetService;

public class Server {

	public static void main(String[] agrs) throws Exception {
		
		ServerChannleInitializer<ServerChannelHandler> channleInitializer = new ServerChannleInitializer<ServerChannelHandler>(NetServiceType.SOCKET, ServerChannelHandler.class);
		
		NetServiceInitializerFactory.getInstance().addInitializer(1, channleInitializer);
		
		NetService service = new ServerNetService("服务端", 1, NetServiceType.SOCKET, "127.0.0.1", 90);

		service.listening();
		
	}
	
}
