package com.chen.login.message.res;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;

import com.chen.message.Message;
/**
 * 服务器向客户端发送被顶替下线的消息
 * @author Administrator
 *
 */
public class ResSubstituteMessage extends Message
{
	//顶替者的ip地址
	private String ip;
	@Override
	public int getId() {	
		return 1039;
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
		this.ip = readString(this.messageUnpacker);
	}

	@Override
	public void write(IoBuffer buf) 
	{
		writeString(this.messagePack,ip);
		super.write(buf);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
