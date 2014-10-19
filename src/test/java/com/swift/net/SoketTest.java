package com.swift.net;

import org.junit.Test;

import com.swift.net.channle.handler.ServerChannelHandler;
import com.swift.net.channle.initializer.NetworkServiceInitializerFactory;
import com.swift.net.channle.initializer.ServerChannleInitializer;

public class SoketTest {

	public static void main(String[] agrs) throws InterruptedException {
		
		ServerChannelHandler channelHandler = new ServerChannelHandler() {
			
			@Override
			public void exceptionCaught(Throwable cause) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void channelRegistered() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void channelRead(Object msg) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void channelActive() {
				// TODO Auto-generated method stub
				
			}
		};
		
		ServerChannleInitializer channleInitializer = new ServerChannleInitializer(NetworkServiceType.SOCKET, channelHandler);
		
		NetworkServiceInitializerFactory.getInstance().addInitializer(1, channleInitializer);
		
		NetworkService service = new NetworkServiceImpl(1, NetworkServiceType.SOCKET, "127.0.0.1", 90);

		service.listening();
	}

	@Test
	public void socketServer() throws InterruptedException {
//		NetworkService service = new NetworkServiceImpl(NetworkServiceType.SOCKET, "127.0.0.1", 90);

//		service.listening();
	}
}
