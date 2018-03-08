package com.chen.login.message.req;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;

import com.chen.message.Message;

public class ReqSelectCharacterMessage extends Message
{
	public long playerId;
	@Override
	public int getId()
	{		
		return 1006;
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
	public void read(ByteBuffer buffer) {
		super.read(buffer);
		this.playerId = readLong(this.messageUnpacker);
	}

	@Override
	public void write(IoBuffer buffer)
	{
		writeLong(this.messagePack, playerId);
		super.write(buffer);
	}
}
