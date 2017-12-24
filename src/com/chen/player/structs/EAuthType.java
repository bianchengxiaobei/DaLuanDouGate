package com.chen.player.structs;

public enum EAuthType
{
	Normal((byte)0),
	Platform((byte)1),
	Guest((byte)2);
	
	public byte value;
	private EAuthType(byte value) 
	{
		this.value = value;
	}
}
