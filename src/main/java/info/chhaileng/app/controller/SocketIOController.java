package info.chhaileng.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;

@Controller
public class SocketIOController {
	public SocketIONamespace getNamespace() {
        return namespace;
    }

    private SocketIONamespace namespace;

    @Autowired
    public SocketIOController(SocketIOServer server) {
        this.namespace = server.addNamespace("/auction");
    }

    public void broadcastEvent(String event, Object data){
        this.getNamespace().getBroadcastOperations().sendEvent(event,data);
    }
}
