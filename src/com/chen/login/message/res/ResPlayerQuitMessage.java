package com.chen.login.message.res;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;

import com.chen.message.Message;
/**
 * 服务器发送给客户端玩家退出服务区消息
 * @author Administrator
 *
 */
public class ResPlayerQuitMessage extends Message
{
	public int bIsForced;
	@Override
	public int getId() {
		return 10035;
	}

	@Override
	public String getQueue() {
		return null;
	}

	@Override
	public String getServer() {
		return null;
	}

	@Override
	public void read(ByteBuffer buffer)
	{
		super.read(buffer);
		this.bIsForced = readInt(this.messageUnpacker);
	}

	@Override
	public void write(IoBuffer buffer)
	{
		writeInt(this.messagePack, bIsForced);		
		super.write(buffer);
	}

}
