package com.chen.login.message.req;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;

import com.chen.message.Message;
/**
 * 客户端登陆请求消息1001
 * @author chen
 *
 */
public class ReqLoginMessage extends Message
{
	private int serverId;
	private String name;
	private String password;
	public byte authType;
	@Override
	public int getId() {
		return 1001;
	}
	public int getServerId() {
		return serverId;
	}
	public void setServerId(int serverId) {
		this.serverId = serverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getQueue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getServer() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void read(ByteBuffer buf) 
	{
		super.read(buf);
		this.name = readString(this.messageUnpacker);
		this.password = readString(this.messageUnpacker);
		this.serverId = readInt(this.messageUnpacker);
		this.authType = readByte(this.messageUnpacker);
	}
	@Override
	public void write(IoBuffer buf) {
		
	}
}
