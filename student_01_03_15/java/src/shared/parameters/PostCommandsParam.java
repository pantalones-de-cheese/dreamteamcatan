package shared.parameters;

import java.util.ArrayList;

import shared.response.GameCommand;

public class PostCommandsParam {
	// For testing
	private String commands;
	
	public PostCommandsParam(String c)
	{
		commands = c;
	}
	
	public String getCommands()
	{
		return this.commands;
	}
}