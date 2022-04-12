package api.RESTful.contract;

import api.websocket.WebsocketClient;
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.TimeUnit;

public class MarketWebSocketAPI {

	private final static String URL = "wss://fstream.xt.com/ws/market";
	
	private WebsocketClient wc;
	
	private boolean connect() {
		this.wc = new WebsocketClient(URL);
		return this.wc.connect();
	}
	
	public void send(String text) {
		this.wc.send(text);
	}
	
	public static void main(String[] args) {
		
		MarketWebSocketAPI api = new MarketWebSocketAPI();
		if(!api.connect()) {
			return;
		}
		
		// 订阅
		JSONObject subscribe = new JSONObject();
		subscribe.put("req", "sub_symbol");
		subscribe.put("symbol", "fil_usdt");
		api.send(subscribe.toJSONString());
		
		try {
			TimeUnit.MILLISECONDS.sleep(60 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 取消订阅
		JSONObject unsubscribe = new JSONObject();
		unsubscribe.put("req", "unsub_symbol");
		unsubscribe.put("symbol", "fil_usdt");
		api.send(unsubscribe.toJSONString());
		
		// 关闭
		api.send("close");
	}
}
