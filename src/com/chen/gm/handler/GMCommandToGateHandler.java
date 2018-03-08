package com.chen.gm.handler;

import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chen.command.Handler;
import com.chen.gm.message.GMCommandToGateMessage;
import com.chen.gm.structs.GMCommandId;
import com.chen.player.manager.PlayerManager;

public class GMCommandToGateHandler extends Handler
{
	private Logger log = LogManager.getLogger(GMCommandToGateHandler.class);
	@Override
	public void action()
	{
		try 
		{
			GMCommandToGateMessage message = (GMCommandToGateMessage)this.getMessage();
			if (message.commandId == null || message.commandId.size() == 0)
			{
				log.error("没有指令");
				return;
			}
			for (Entry<Integer, String> entry : message.commandId.entrySet())
			{
				GMCommandId type = GMCommandId.values()[entry.getKey()];
				switch (type) 
				{
				case MaxLoginNum:
					PlayerManager.MAX_PLAYER = Integer.parseInt(entry.getValue());
					break;
				case ResetPlayerState:
					String[] content = entry.getValue().split(",");
					PlayerManager.getInstance().removeUserState(Integer.parseInt(content[0]), content[1]);
					break;
				}
			}
		} 
		catch (Exception e)
		{
			log.error(e);
		}
	}
}
