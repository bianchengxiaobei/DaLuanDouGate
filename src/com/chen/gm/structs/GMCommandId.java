package com.chen.gm.structs;

public enum GMCommandId
{
	MaxLoginNum(0),
	ResetPlayerState(1);
	public int value;
	private GMCommandId(int value)
	{
		this.value = value;
	}
}
