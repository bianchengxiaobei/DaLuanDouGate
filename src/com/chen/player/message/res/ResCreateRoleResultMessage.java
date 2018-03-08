package com.chen.player.message.res;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;

import com.chen.message.Message;
/**
 * 服务器发送给客户端创建角色失败的消息
 * @author Administrator
 *
 */
public class ResCreateRoleResultMessage extends Message
{
	public int errCode;
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 1005;
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
	public void read(ByteBuffer buffer) 
	{
		super.read(buffer);
		this.errCode = readInt(this.messageUnpacker);		
	}

	@Override
	public void write(IoBuffer buffer) 
	{
		writeInt(this.messagePack, errCode);
		super.write(buffer);
	}
	
}
