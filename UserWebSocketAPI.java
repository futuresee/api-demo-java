package api.RESTful.contract;

import api.utils.HttpUtil;
import api.websocket.WebsocketClient;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UserWebSocketAPI {
    // 网站申请的密钥对
    private final static String apikey = "";
    private final static String secretKey = "";
    private final static String USER_URL = "https://fapi.xt.com";

    private final static String URL = "wss://fstream.xt.com/ws/user";

    private WebsocketClient wc;

    public static String getListenKey() {
        String path = "/future/user/v1/user/listen-key";
        Map<String, Object> params = new HashMap<>();
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        return HttpUtil.get(USER_URL + path, headers, params);
    }

    private boolean connect() {
        this.wc = new WebsocketClient(URL);
        return this.wc.connect();
    }

    public void send(String text) {
        this.wc.send(text);
    }

    public static void main(String[] args) {

        UserWebSocketAPI api = new UserWebSocketAPI();
        if (!api.connect()) {
            return;
        }

        // 订阅
        JSONObject subscribe = new JSONObject();
        subscribe.put("req", "sub_user");
        subscribe.put("listenKey", JSONObject.parseObject(getListenKey()).getString("result"));
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
