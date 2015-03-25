package server.handlers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

import server.facade.ServerFacade;
import shared.parameters.AddAiParam;
import shared.response.LoginResponse;
import shared.response.StandardResponse;

/**
 *
 * @author Drew
 */
public class AddAIHandler extends ServerHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Gson g = new Gson();
        String responseBody;
        int responseCode = 400;
        
        String cookie = exchange.getRequestHeaders().getFirst("Cookie");
        LoginResponse login = getLoginFromCookie(cookie);
        
        if(!login.isValid())
        {
            responseBody = "\"Error: bad cookie\"";
        }
        else
        {
            int gameId = getGameIdFromCookie(cookie);
            AddAiParam param = new AddAiParam("LARGEST_ARMY");
            
            StandardResponse response = ServerFacade.addAI(param,gameId);
            

            if(response.isValid())
            {
                responseBody = "\"Success\"";
                responseCode = 200;
            }
            else
            {
                responseBody = "\"Failure\"";
            }
        }
        
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(responseCode, 0);
        
        
        write(exchange.getResponseBody(), responseBody);
    }
    
}
