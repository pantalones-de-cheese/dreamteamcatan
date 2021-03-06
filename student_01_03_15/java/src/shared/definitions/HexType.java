package shared.definitions;
public enum HexType
{
	WOOD, BRICK, SHEEP, WHEAT, ORE, DESERT, WATER;
        
    public static HexType fromString(String s)
    {
        HexType ht = DESERT;
        if(s != null)
        {
            switch(s)
            {
                case "wood": ht = WOOD; break;
                case "brick": ht = BRICK; break;
                case "sheep": ht = SHEEP; break;
                case "wheat": ht = WHEAT; break;
                case "ore": ht = ORE; break;
                case "desert": ht = DESERT; break;
                case "water": ht = WATER; break;
            }
        }
        return ht;
    }
    public static String asString(HexType ht)
    {
    	String s = "desert";
    	if (ht != null)
    	{
    		switch (ht)
    		{
				case WOOD: s = "wood"; break;
				case BRICK: s = "brick"; break;
				case SHEEP: s = "sheep"; break;
				case WHEAT: s = "wheat"; break;
				case ORE: s = "ore"; break;
				default: break;
    		}
    	}
    	return s;
    }
}


