package com.chen.login.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.chen.command.Handler;
import com.chen.login.message.res.ResLoginSuccessToGateMessage;
import com.chen.login.message.res.ResRegisterSuccessIfInBattleMessage;
import com.chen.player.manager.PlayerManager;
import com.chen.server.GateServer;
import com.chen.util.MessageUtil;

public class ResLoginSuccessToGateHandler extends Handler
{
	private Logger log = LogManager.getLogger(ResLoginSuccessToGateHandler.class);
	@Override
	public void action() 
	{
		try
		{
			//收到游戏服务器发送的创建角色成功之后登陆成功的消息
			ResLoginSuccessToGateMessage msg = (ResLoginSuccessToGateMessage)this.getMessage();
			PlayerManager.getInstance().registerPlayer(msg.getServerId(), msg.getCreateServerId(), msg.getUserId(), msg.getPlayerId());
			IoSession session = GateServer.getInstance().getSessionByUser(msg.getCreateServerId(), msg.getUserId());
			//发送注册成功消息给游戏服务器
			ResRegisterSuccessIfInBattleMessage message = new ResRegisterSuccessIfInBattleMessage();
			message.playerId = msg.getPlayerId();
			MessageUtil.sendMessageToGameServer(msg.getCreateServerId(), (Integer)session.getAttribute("session_id"), message);
		} 
		catch (Exception e)
		{
			log.error(e,e);
		}
	}

}
