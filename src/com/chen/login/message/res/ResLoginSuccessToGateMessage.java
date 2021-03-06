package com.chen.login.message.res;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;

import com.chen.message.Message;
/**
 *游戏服务器通知网关服务器登陆成功消息 
 * @author chen
 *
 */
public class ResLoginSuccessToGateMessage extends Message
{
	private int serverId;
	private int createServerId;
	private String userId;
	private long playerId;
	
	
	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public int getCreateServerId() {
		return createServerId;
	}

	public void setCreateServerId(int createServerId) {
		this.createServerId = createServerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 10008;
	}

	@Override
	public String getQueue() {
		// TODO Auto-generated method stub
		return "Local";
	}

	@Override
	public String getServer() {
		return null;
	}

	@Override
	public void read(ByteBuffer buf) 
	{
		super.read(buf);
		this.serverId = readInt(this.messageUnpacker);
		this.createServerId = readInt(this.messageUnpacker);
		this.userId = readString(this.messageUnpacker);
		this.playerId = readLong(this.messageUnpacker);
	}

	@Override
	public void write(IoBuffer buf)
	{
		writeInt(this.messagePack, serverId);
		writeInt(this.messagePack, createServerId);
		writeString(this.messagePack, userId);
		writeLong(this.messagePack, playerId);
		super.write(buf);
	}
}
