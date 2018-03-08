package com.chen.gm.message;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import com.chen.message.Message;

public class GMCommandToGateMessage extends Message
{
	public long playerId;
	public Map<Integer, String> commandId; 
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 9999;
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
		commandId = new HashMap<>();
		super.read(buffer);
		this.playerId = readLong(messageUnpacker);
		int size = readInt(messageUnpacker);
		for (int i=0; i<size; i++)
		{
			int id = readInt(messageUnpacker);
			String content = readString(messageUnpacker);
			commandId.put(id, content);
		}
		readEnd();
	}
}
