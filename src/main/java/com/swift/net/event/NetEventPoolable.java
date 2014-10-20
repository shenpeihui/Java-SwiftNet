package com.swift.net.event;

import com.swift.net.client.ClientLink;

/**
 * 适配器：网络事件
 * @author shenpeihui
 *
 */
public class NetEventPoolable<MESSAGE> implements NetEvent<MESSAGE> {

	/**
	 * 事件id
	 */
	private short id;
	
	/**
	 * 事件优先级
	 * @author shenpeihui
	 */
	private int priority;
	
	/**
	 * 事件处理消息序号
	 */
	private int sequence;
	
	/**
	 * 事件开始处理时间（毫秒）
	 */
	private long beginHandleMillis;
	
	/**
	 * 事件处理结束时间（毫秒）
	 */
	private long endHandleMillis;
	
	/**
	 * 事件消息到达时间（毫秒）
	 */
	private long arrivedMillis;
	
	/**
	 * 活动时间（毫秒）
	 */
	private long actionMillis;
	
	/**
	 * 事件消息
	 */
	private MESSAGE message;
	
	/**
	 * 客户端链路
	 */
	private ClientLink link;
	
	/**
	 * 是否管理员
	 */
	private boolean admin;

	@Override
	public short getId() {
		return id;
	}

	@Override
	public int getSequence() {
		return sequence;
	}

	@Override
	public MESSAGE getMessage() {
		return message;
	}

	@Override
	public void doHandle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPriority() {
		return priority;
	}

	@Override
	public ClientLink getLink() {
		return link;
	}

	@Override
	public void setLink(ClientLink link) {
		this.link = link;
	}

	@Override
	public long getBeginHandleMillis() {
		return beginHandleMillis;
	}

	@Override
	public void setBeginHandleMillis(long beginHandleMillis) {
		this.beginHandleMillis = beginHandleMillis;
	}

	@Override
	public long getEndHandleMillis() {
		return endHandleMillis;
	}

	@Override
	public void setEndHandleMillis(long endHandleMillis) {
		this.endHandleMillis = endHandleMillis;
	}

	@Override
	public long getArrivedMillis() {
		return arrivedMillis;
	}

	@Override
	public boolean isAdminEvent() {
		return admin;
	}

	@Override
	public void setAdminEvent(boolean admin) {
		this.admin = admin;
	}

	@Override
	public long getActionMillis() {
		return actionMillis;
	}

	@Override
	public void setActionMillis(long actionMillis) {
		this.actionMillis = actionMillis;
	}
	
	
}
