package com.chen.login.message.res;

import java.nio.ByteBuffer;


import org.apache.mina.core.buffer.IoBuffer;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;

import com.chen.login.bean.CharacterInfo;
import com.chen.message.Message;
/**
 * 服务器发送给客户端角色信息列表
 * 当登陆成功的时候
 * @author chen
 *
 */
public class ResCharacterInfosMessage extends Message
{
	public CharacterInfo[] characters;
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 1003;
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
	}

	@Override
	public void write(IoBuffer buf)
	{
		int length = characters.length;
		writeInt(this.messagePack, length);
		for (int i=0;i<length;i++)
		{
			characters[i].write(this.messagePack);;
		}
		super.write(buf);	
	}

}
