package info.chhaileng.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.corundumstudio.socketio.AckRequest;
//import com.corundumstudio.socketio.Configuration;
//import com.corundumstudio.socketio.SocketIOClient;
//import com.corundumstudio.socketio.SocketIOServer;
//import com.corundumstudio.socketio.listener.DataListener;
//
//import info.chhaileng.app.model.Price;

@SpringBootApplication
public class RealTimeSocketIoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeSocketIoApplication.class, args);
//		Configuration config = new Configuration();
//		config.setHostname("127.0.0.1");
//		config.setPort(9000);
//		
//		final SocketIOServer server = new SocketIOServer(config);
//		server.addEventListener("test", Price.class, new DataListener<Price>() {
//			@Override
//			public void onData(SocketIOClient arg0, Price arg1, AckRequest arg2) throws Exception {
//				server.getBroadcastOperations().sendEvent("test", arg1);	
//			}
//		});
//		
//		server.start();
//		try {
//			Thread.sleep(Integer.MAX_VALUE);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		server.stop();
		
	}
}
