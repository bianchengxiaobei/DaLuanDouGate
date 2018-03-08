package com.chen.login.bean;

import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessageUnpacker;

import com.chen.message.Bean;

public class CharacterInfo extends Bean
{
	public long playerId;
	public String name;
	public int level;
	public byte sex;
	public int icon;
	@Override
	public void read(MessageUnpacker messageUnpacker)
	{
		this.playerId = readLong(messageUnpacker);
		this.name = readString(messageUnpacker);
		this.level = readInt(messageUnpacker);
		this.sex = readByte(messageUnpacker);
		this.icon = readInt(messageUnpacker);		
	}
	@Override
	public void write(MessageBufferPacker messagePack)
	{
		writeLong(messagePack, playerId);
		writeString(messagePack, name);
		writeInt(messagePack, level);
		writeByte(messagePack, sex);
		writeInt(messagePack, icon);
	}
}
