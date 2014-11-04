package com.test.swift.net.client;

import com.swift.net.NetServiceType;
import com.swift.net.channle.initializer.ClientChannleInitializer;
import com.swift.net.channle.initializer.NetServiceInitializerFactory;
import com.swift.net.service.ClientNetService;
import com.swift.net.service.NetService;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ClientChannleInitializer<ClientChannelHandler> channleInitializer = new ClientChannleInitializer<ClientChannelHandler>(NetServiceType.SOCKET, ClientChannelHandler.class);
		
		NetServiceInitializerFactory.getInstance().addInitializer(-2, channleInitializer);
		
		NetService service = new ClientNetService("客户端", -2, NetServiceType.SOCKET, "127.0.0.1", 90);

		service.listening();
	}

}
