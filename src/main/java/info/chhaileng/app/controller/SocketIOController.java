package info.chhaileng.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

import info.chhaileng.app.model.Price;

@Controller
public class SocketIOController {
	
	private SocketIONamespace namespace;
	
	public SocketIONamespace getNamespace() {
        return namespace;
    }

    @Autowired
    public SocketIOController(SocketIOServer server) {
        this.namespace = server.addNamespace("/auction");
        this.namespace.addEventListener("userBid", Price.class, onUserBid); 
    }
    
    public DataListener<Price> onUserBid = new DataListener<Price>() {
    	@Override
    	public void onData(SocketIOClient client, Price price, AckRequest ack) throws Exception {
			System.out.println("Listen on even userBid" + price);
			namespace.getBroadcastOperations().sendEvent("onBid", client, price);
			
			// 
			
			System.out.println(price.getPrice());
		}
	};

    public void broadcastEvent(String event, Object data){
        this.getNamespace().getBroadcastOperations().sendEvent(event,data);
    }
    
    public void stopServer() {
    	this.stopServer();
    }
}
