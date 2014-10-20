package com.swift.net.event;

import com.swift.net.client.ClientLink;

/**
 * 接口：事件
 * @author shenpeihui
 *
 */
public interface NetEvent<MESSAGE> {

	/**
	 * 事件id
	 * @author shenpeihui
	 * @return
	 */
	short getId();
	
	/**
	 * 当前处理消息序号
	 * @author shenpeihui
	 * @return
	 */
	int getSequence();
	
	/**
	 * 读取事件消息体
	 * @author shenpeihui
	 * @return
	 */
	MESSAGE getMessage();
	
	/**
	 * 开始处理消息
	 * @author shenpeihui
	 */
	void doHandle();
	
	/**
	 * 释放消息
	 * @author shenpeihui
	 */
	void release();
	
	/**
	 * 优先级
	 * @author shenpeihui
	 * @return
	 */
	int getPriority();
	
	/**
	 * 读取客户端链路
	 * @author shenpeihui
	 * @return
	 */
	ClientLink getLink();
	
	/**
	 * 设置客户端会话
	 * @author shenpeihui
	 * @param link
	 */
	void setLink(ClientLink link);
	
	/**
	 * 读取事件开始处理时间（毫秒）
	 * @author shenpeihui
	 * @return
	 */
	long getBeginHandleMillis();
	
	/**
	 * 设置事件开始处理时间（毫秒）
	 * @author shenpeihui
	 * @param beginHandleMillis
	 */
	void setBeginHandleMillis(long beginHandleMillis);

	/**
	 * 读取事件处理结束时间（毫秒）
	 * @author shenpeihui
	 * @return
	 */
	long getEndHandleMillis();

	/**
	 * 设置事件处理结束时间（毫秒）
	 * @author shenpeihui
	 * @param endHandleMillis
	 */
	void setEndHandleMillis(long endHandleMillis);

	/**
	 * 读取事件消息到达时间（毫秒）
	 * @author shenpeihui
	 * @return
	 */
	long getArrivedMillis();
	
	/**
	 * 是否管理员事件
	 * @author shenpeihui
	 * @return
	 */
	boolean isAdminEvent();
	
	/**
	 * 设置是否管理员事件
	 * @author shenpeihui
	 * @param admin
	 */
	void setAdminEvent(boolean admin) ;
	
	/**
	 * 读取活动时间（毫秒）
	 * @author shenpeihui
	 * @return
	 */
	long getActionMillis();
	
	/**
	 * 设置活动时间（毫秒）
	 * @author shenpeihui
	 * @param actionMillis
	 */
	void setActionMillis(long actionMillis);
	
}
