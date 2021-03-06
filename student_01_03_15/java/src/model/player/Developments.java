package model.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import shared.definitions.DevCardType;

public class Developments
{
	int monopoly;
	int monument;
	int roadBuilding;
	int soldier;
	int yearOfPlenty;
	
	private transient List<DevCardType> deck;
	
	public Developments(){}
	
	public void reset()
	{
		clear();
		init();
	}
	
	public void clear()
	{
		monopoly = 0;
		monument = 0;
		roadBuilding = 0;
		soldier = 0;
		yearOfPlenty = 0;
	}
	public Developments init()
	{
		monopoly = 2;
		monument = 5;
		roadBuilding = 2;
		soldier = 14;
		yearOfPlenty = 2;
		deck = new ArrayList<>();
		this.initDeck();
		return this;
	}
	
	public void initDeck()
	{
		for (int i = 0; i < 14; i++)
		{
			if (i < 2)
			{
				deck.add(DevCardType.MONOPOLY);
				deck.add(DevCardType.ROAD_BUILD);
				deck.add(DevCardType.YEAR_OF_PLENTY);
			}
			if (i < 5)
			{
				deck.add(DevCardType.MONUMENT);
			}
			deck.add(DevCardType.SOLDIER);
		}
		Collections.shuffle(deck);
	}
	
	public DevCardType drawCard()
	{
		DevCardType card = deck.get(0);
		deck.remove(0);
		useCard(card);
		return card;
	}
	
	public void addCard(DevCardType type)
	{
		if (type != null)
		{
			switch (type)
			{
				case MONOPOLY: monopoly++;break;
				case ROAD_BUILD: roadBuilding++; break;
				case YEAR_OF_PLENTY: yearOfPlenty++; break;
				case SOLDIER: soldier++; break;
				case MONUMENT: monument++; break;
				default: break;
			}
		}
	}
	
	public void useCard(DevCardType type)
	{
		if (type != null)
		{
			switch (type)
			{
				case MONOPOLY: monopoly--;break;
				case ROAD_BUILD: roadBuilding--; break;
				case YEAR_OF_PLENTY: yearOfPlenty--; break;
				case SOLDIER: soldier--; break;
				case MONUMENT: monument--; break;
				default: break;
			}
		}
	}

	/**
	 * Checks to see if the DevCardType given is contained in the developments
	 * 
	 * @param devCard
	 * @return whether or not the dev card is in the hand
	 */
	public boolean hasDevCard(DevCardType devCard)
	{
		switch (devCard)
		{
		case SOLDIER:
			return soldier > 0;
		case YEAR_OF_PLENTY:
			return yearOfPlenty > 0;
		case MONOPOLY:
			return monopoly > 0;
		case ROAD_BUILD:
			return roadBuilding > 0;
		case MONUMENT:
			return monument > 0;
		default:
			assert false;
			return false;

		}
	}

	
	/**
	 * Adds up the amount of each type of development and returns
	 * 
	 * @return the size of the development hand
	 */
	public int size()
	{
		return (monopoly + monument + roadBuilding + soldier + yearOfPlenty);
	}

	public int getMonopoly()
	{
		return monopoly;
	}

	public void setMonopoly(int monopoly)
	{
		this.monopoly = monopoly;
	}

	public int getMonument()
	{
		return monument;
	}

	public void setMonument(int monument)
	{
		this.monument = monument;
	}

	public int getRoadBuilding()
	{
		return roadBuilding;
	}

	public void setRoadBuilding(int roadBuilding)
	{
		this.roadBuilding = roadBuilding;
	}

	public int getSoldier()
	{
		return soldier;
	}

	public void setSoldier(int soldier)
	{
		this.soldier = soldier;
	}

	public int getYearOfPlenty()
	{
		return yearOfPlenty;
	}

	public void setYearOfPlenty(int yearOfPlenty)
	{
		this.yearOfPlenty = yearOfPlenty;
	}

	@Override
	public String toString()
	{
		return "Developments [monopoly=" + monopoly + ", monument=" + monument
				+ ", roadBuilding=" + roadBuilding + ", soldier=" + soldier
				+ ", yearOfPlenty=" + yearOfPlenty + "]";
	}
	
	

}