package com.chen.login.message.req;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;

import com.chen.message.Message;

/**
 * 客户端向网关服务器发送创建角色请求消息1004
 * @author chen
 *
 */
public class ReqCreateCharacterMessage extends Message
{
	public String name;
	public int icon;
	public byte sex;
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 1004;
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
		this.icon = readInt(this.messageUnpacker);
		this.sex = readByte(this.messageUnpacker);
		readEnd();
	}
	@Override
	public void write(IoBuffer buf) 
	{
		writeString(this.messagePack, name);
		writeInt(this.messagePack, icon);
		writeByte(this.messagePack, this.sex);
		write(buf);
	}
}
