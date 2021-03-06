package server.facade;

import shared.parameters.AddAiParam;
import shared.parameters.CommandsParam;
import shared.response.CommandResponse;
import shared.response.GameModelResponse;
import shared.response.ListAIResponse;
import shared.response.StandardResponse;

public interface IGameFacade
{
	
	/**
	 * This method returns the server Game model object
	 * @param id the id of the game
	 */
	GameModelResponse getGameModel(int id);

	/**
	 * This method validates the credentials through the ModelFacade then
	 * adds an AI User to the specified game.
	 * @param param Add AI parameters for the command
	 * @param id the id of the game
	 */
	StandardResponse addAI(AddAiParam param, int id);
	
	/**
	 * This method returns a list of AI types
	 */
	ListAIResponse listAI();
	
	/**
	 * This method resets the game to its initial state
	 * @param id the id of the game
	 */
	GameModelResponse resetGame(int id);
	
	/**
	 * This method returns a list of commands executed in the game
	 * @param id the id of the game
	 */
	CommandResponse getCommands(int id);
	
	/**
	 * This method executes a list of commands
	 * @param id the id of the game
	 */
	GameModelResponse commands(CommandsParam param, int id);

}
