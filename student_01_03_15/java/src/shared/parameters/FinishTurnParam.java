package shared.parameters;

public class FinishTurnParam {
	private int playerIndex;
	private String type = "finishTurn";
	
	public FinishTurnParam(int p)
	{
		playerIndex = p;
	}

}