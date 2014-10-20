package com.swift.net.event;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;


public class GameEventPoolableFactory<MESSAGE> extends BasePooledObjectFactory<NetEventPoolable<MESSAGE>> {

	@Override
	public NetEventPoolable<MESSAGE> create() throws Exception {
		return new NetEventPoolable<MESSAGE>();
	}

	@Override
	public PooledObject<NetEventPoolable<MESSAGE>> wrap(
			NetEventPoolable<MESSAGE> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
