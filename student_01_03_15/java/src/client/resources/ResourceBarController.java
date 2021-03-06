package client.resources;

import java.util.*;
import shared.definitions.ResourceType;
import model.ModelFacade;
import model.player.Player;
import model.player.Resources;
import client.base.*;


/**
 * Implementation for the resource bar controller
 */
public class ResourceBarController extends Controller implements IResourceBarController, Observer {

	private Map<ResourceBarElement, IAction> elementActions;
	
	//--------------------------------------------------------------------------------
	public ResourceBarController(IResourceBarView view) {

		super(view);
		
		elementActions = new HashMap<ResourceBarElement, IAction>();
		ModelFacade.getInstance().addObserver(this);
	}

	//--------------------------------------------------------------------------------
	@Override
	public IResourceBarView getView() {
		return (IResourceBarView)super.getView();
	}

	//--------------------------------------------------------------------------------
	/**
	 * Sets the action to be executed when the specified resource bar element is clicked by the user
	 * 
	 * @param element The resource bar element with which the action is associated
	 * @param action The action to be executed
	 */
	public void setElementAction(ResourceBarElement element, IAction action) {

		elementActions.put(element, action);
	}

	//--------------------------------------------------------------------------------
	@Override
	public void buildRoad() {
		executeElementAction(ResourceBarElement.ROAD);
	}

	//--------------------------------------------------------------------------------
	@Override
	public void buildSettlement() {
		executeElementAction(ResourceBarElement.SETTLEMENT);
	}

	//--------------------------------------------------------------------------------
	@Override
	public void buildCity() {
		executeElementAction(ResourceBarElement.CITY);
	}

	//--------------------------------------------------------------------------------
	@Override
	public void buyCard() {
		executeElementAction(ResourceBarElement.BUY_CARD);
	}

	//--------------------------------------------------------------------------------
	@Override
	public void playCard() {
		executeElementAction(ResourceBarElement.PLAY_CARD);
	}
	
	//--------------------------------------------------------------------------------
	private void executeElementAction(ResourceBarElement element) {
		
		if (elementActions.containsKey(element)) {
			
			IAction action = elementActions.get(element);
			action.execute();
		}
	}

	//--------------------------------------------------------------------------------
	@Override
	public void update(Observable o, Object arg)
	{
		updateElements();
	}

	//--------------------------------------------------------------------------------
	public void updateElements()
	{
		boolean valid = false;
		Player player = ModelFacade.getInstance().getPlayer();
		if (player == null) return;
		Resources resources = player.getResources();
		
		setElement(ResourceBarElement.WOOD, resources.getResourceAmount(ResourceType.WOOD));
                setElement(ResourceBarElement.BRICK, resources.getResourceAmount(ResourceType.BRICK));
		setElement(ResourceBarElement.SHEEP, resources.getResourceAmount(ResourceType.SHEEP));
		setElement(ResourceBarElement.WHEAT, resources.getResourceAmount(ResourceType.WHEAT));
		setElement(ResourceBarElement.ORE, resources.getResourceAmount(ResourceType.ORE));
		setElement(ResourceBarElement.SOLDIERS, player.getSoldiers());

		
		setElement(ResourceBarElement.ROAD, player.getRoads());
		setElement(ResourceBarElement.SETTLEMENT, player.getSettlements());
		setElement(ResourceBarElement.CITY, player.getCities());
		

		getView().setElementEnabled(ResourceBarElement.ROAD,ModelFacade.getInstance().CanBuyRoad());
		getView().setElementEnabled(ResourceBarElement.SETTLEMENT,ModelFacade.getInstance().CanBuySettlement());
		getView().setElementEnabled(ResourceBarElement.CITY,ModelFacade.getInstance().CanBuyCity());
		
		valid = ModelFacade.getInstance().CanBuyDevCard();
		getView().setElementEnabled(ResourceBarElement.BUY_CARD, valid);

		setElement(ResourceBarElement.PLAY_CARD, getPlayCardNumber(player));
	}
	
	//--------------------------------------------------------------------------------
	public void setElement(ResourceBarElement element, int amount)
	{
		getView().setElementAmount(element, amount);
		getView().setElementEnabled(element, amount > 0);

	}
	
	//--------------------------------------------------------------------------------
	public int getPlayCardNumber(Player player)
	{
		int total = 0;
		total += player.getNewDevCards().getMonument();
		total += player.getOldDevCards().getMonument();
		total += player.getOldDevCards().getMonopoly();
		total += player.getOldDevCards().getSoldier();
		total += player.getOldDevCards().getRoadBuilding();
		total += player.getOldDevCards().getYearOfPlenty();
		return total;
	}

}

