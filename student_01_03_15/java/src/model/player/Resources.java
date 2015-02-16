package model.player;

import shared.definitions.ResourceType;


public class Resources {

	private int wood;
	private int sheep;
	private int wheat;
	private int brick;
	private int ore;
	
	public Resources(int wood, int sheep, int wheat, int brick, int ore) 
	{
		this.wood = wood;
		this.sheep = sheep;
		this.wheat = wheat;
		this.brick = brick;
		this.ore = ore;
	}


	/**
	 * 
	 * Used to facilitate trading.
	 */
	public void invert()
	{
		wood = -wood;
		sheep = -sheep;
		wheat = -wheat;
		brick = -brick;
		ore = -ore;
	}


	/**
	 * This method is called when a 7 is rolled by the Dice
	 * @return the number of resources the player owns
	 */
	public int size()
	{
		return wood+sheep+wheat+brick+ore;
	}
	
	public Resources()
	{
		wood=wheat=sheep=brick=ore=0;
	}
	
	/**
	 * Adds resource to list
	 * @param type they type of resource
	 * @param n the number of resources
	 */
	public void addResource(ResourceType type, int n)
	{
		switch(type)
		{
		case WOOD: wood+=n; 
		break;
		case BRICK: brick+=n; 
		break;
		case WHEAT: wheat+=n; 
		break;
		case SHEEP: sheep+=n; 
		break;
		case ORE: ore+=n; 
		break;
			default:
				break;
		}
	}
	
	/**
	 * Removes resource from list
	 * @param type the type of resource
	 * @param n the number of resources
	 */
	public void useResource(ResourceType type, int n)
	{
		switch(type)
		{
		case WOOD: wood-=n; 
		break;
		case BRICK: brick-=n; 
		break;
		case WHEAT: wheat-=n; 
		break;
		case SHEEP: sheep-=n; 
		break;
		case ORE: ore-=n; 
		break;
			default:
				break;
		}
	}
	
	public int getResourceAmount(ResourceType type)
	{
		int amount = 0;
		switch(type)
		{
		case WOOD: amount = wood; 
		break;
		case BRICK: amount = brick;
		break;
		case WHEAT: amount = wheat;
		break;
		case SHEEP: amount = sheep;
		break;
		case ORE: amount = ore;
		break;
			default:
				break;
		}
		return amount;
		
	}
	
	public int getResourceAmount(String type)
	{
		int amount = 0;
		switch(type)
		{
		case "wood": amount = wood; 
		break;
		case "brick": amount = brick;
		break;
		case "wheat": amount = wheat;
		break;
		case "sheep": amount = sheep;
		break;
		case "ore": amount = ore;
		break;
			default:
				break;
		}
		return amount;
		
	}
	/**
	 * This method verifies that the player has at least the same amount of resources in
	 * the specified list
	 * @param r the resources to compare with
	 * @return true if each resource is greater than or equal to the amount in the comparison
	 */
	public boolean contains(Resources r)
	{
		ResourceType[] list = {ResourceType.WHEAT, ResourceType.WOOD,
				ResourceType.BRICK, ResourceType.ORE, ResourceType.SHEEP};
		for (ResourceType res : list)
		{
			int amount = r.getResourceAmount(res);
			if (amount > 0 && this.getResourceAmount(res) < amount) return false;
		}
		return true;
	}
}