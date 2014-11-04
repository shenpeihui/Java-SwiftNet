package com.test.swift.net;

import com.swift.net.NetServiceType;
import com.swift.net.channle.initializer.ClientChannleInitializer;
import com.swift.net.channle.initializer.NetServiceInitializerFactory;
import com.swift.net.channle.initializer.ServerChannleInitializer;
import com.swift.net.service.ClientNetService;
import com.swift.net.service.NetService;
import com.swift.net.service.ServerNetService;
import com.test.swift.net.client.ClientChannelHandler;
import com.test.swift.net.server.ServerChannelHandler;



public class SoketTest {

	public static void main(String[] agrs) throws InterruptedException {
		
//		ServerTest serverTest = new ServerTest();
//		
//		serverTest.start();
//		
//		
//		ClientTest clientTest1 = new ClientTest("客户端1", -1);
//		
//		clientTest1.start();
//		
//		
//		ClientTest clientTest2 = new ClientTest("客户端2", -2);
//		
//		clientTest2.start();
		
		// 服务端
		ServerChannleInitializer<ServerChannelHandler> channleInitializer = new ServerChannleInitializer<ServerChannelHandler>(NetServiceType.SOCKET, ServerChannelHandler.class);
		
		NetServiceInitializerFactory.getInstance().addInitializer(1, channleInitializer);
		
		NetService serverService = new ServerNetService("服务端", 1, NetServiceType.SOCKET, "127.0.0.1", 90);
			
		serverService.start();
		
		
		// 客户端1
		ClientChannleInitializer<ClientChannelHandler> channleInitializer1 = new ClientChannleInitializer<ClientChannelHandler>(NetServiceType.SOCKET, ClientChannelHandler.class);
		
		NetServiceInitializerFactory.getInstance().addInitializer(-1, channleInitializer1);
		
		NetService clientService1 = new ClientNetService("客户端1", -1, NetServiceType.SOCKET, "127.0.0.1", 90);

		clientService1.start();
		
		
		// 客户端1
		ClientChannleInitializer<ClientChannelHandler> channleInitializer2 = new ClientChannleInitializer<ClientChannelHandler>(NetServiceType.SOCKET, ClientChannelHandler.class);
		
		NetServiceInitializerFactory.getInstance().addInitializer(-2, channleInitializer2);
		
		NetService clientService2 = new ClientNetService("客户端2", -2, NetServiceType.SOCKET, "127.0.0.1", 90);
		
		clientService2.start();
		
	}

}
