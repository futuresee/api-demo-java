package api.RESTful.contract;

import api.utils.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserRestAPI {

    // 网站申请的密钥对
    private final static String apikey = "";
    private final static String secretKey = "";

    private final static String URL = "https://fapi.xt.com";
    // 获取ws listenKey
    @Test
    public void getListenKey() {
        String path = "/future/user/v1/user/listen-key";
        Map<String, Object> params = new HashMap<>();
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }
    // 获取交易账户资产
    @Test
    public void getAccountInfo() {
        String path = "/future/user/v1/account/info";
        Map<String, Object> params = new HashMap<>();
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    // 开通合约
    @Test
    public void getAccountOpen() {
        String path = "/future/user/v1/account/open";
        Map<String, Object> body = new HashMap<>();
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    // 收藏交易对
    @Test
    public void postUserCollectionAdd() {
        String path = "/future/user/v1/user/collection/add";
        Map<String, Object> body = new HashMap<>();
        body.put("symbol", "btc_usdt");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    // 取消收藏交易对
    @Test
    public void postionUserCollectionCancel() {
        String path = "/future/user/v1/user/collection/cancel";
        Map<String, Object> body = new HashMap<>();
        body.put("symbol", "btc_usdt");

        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    // 查询收藏交易对列表
    @Test
    public void getCollectionList() {
        String path = "/future/user/v1/user/collection/list";
        Map<String, Object> params = new HashMap<>();
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET获取用户账务流水
    @Test
    public void getBalanceBills() {
        String path = "/future/user/v1/balance/bills";
        Map<String, Object> params = new HashMap<>();
        params.put("coin", "usdt");
        params.put("direction", "PREV");
        params.put("startTime", 1646751503419L);
        params.put("endTime", 1646890701448L);
//        params.put("symbol","btc_usdt");
//        params.put("type","EXCHANGE");
//        params.put("id",71510800392536320L);
        params.put("limit", 10);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET获取用户单币种资金
    @Test
    public void getBalanceDetail() {
        String path = "/future/user/v1/balance/detail";
        Map<String, Object> params = new HashMap<>();
        params.put("coin", "usdt");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET获取资金费用
    @Test
    public void getFundingRateList() {
        String path = "/future/user/v1/balance/funding-rate-list";
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "NEXT");
        params.put("startTime", 1646751503419L);
        params.put("endTime", 1646890701448L);
//        params.put("symbol","btc_usdt");
//        params.put("id",71510800392536320L);
        params.put("limit", 10);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET获取用户资金
    @Test
    public void getBalanceList() {
        String path = "/future/user/v1/balance/list";
        Map<String, Object> params = new HashMap<>();
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }


    //POST调整杠杆倍数
    @Test
    public void postPositionAdjustLeverage() {
        String path = "/future/user/v1/position/adjust-leverage";
        Map<String, Object> body = new HashMap<>();
        body.put("leverage", "20");
        body.put("positionSide", "LONG");
        body.put("symbol", "btc_usdt");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //GET获取ADL信息
    @Test
    public void getPositionAdl() {
        String path = "/future/user/v1/position/adl";
        Map<String, Object> params = new HashMap<>();
        params.put("apikey", apikey);
        params.put("nonce", System.currentTimeMillis());
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //POST修改自动追加保证金
    @Test
    public void postPositionAutoMargin() {
        String path = "/future/user/v1/position/auto-margin";
        Map<String, Object> body = new HashMap<>();
        
        
        body.put("autoMargin", "true");
        body.put("positionSide", "LONG");
        body.put("symbol", "btc_usdt");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST一键平仓
    @Test
    public void positionCloseAll() {
        String path = "/future/user/v1/position/close-all";
        Map<String, Object> body = new HashMap<>();
        
        
        body.put("symbol", "btc_usdt");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //GET获取持仓信息
    @Test
    public void getPositionList() {
        String path = "/future/user/v1/position/list";
        Map<String, Object> params = new HashMap<>();
        params.put("apikey", apikey);
        params.put("nonce", System.currentTimeMillis());
        params.put("symbol", "btc_usdt");
        // 签名

        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //POST修改保证金
    @Test
    public void positiionAdjustMargin() {
        String path = "/future/user/v1/position/margin";
        Map<String, Object> body = new HashMap<>();
        
        
        body.put("margin", "421.1231");
        body.put("positionSide", "LONG");
        body.put("symbol", "btc_usdt");
        body.put("type", "ADD");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST合并仓位
    @Test
    public void positionMerge() {
        String path = "/future/user/v1/position/merge";
        Map<String, Object> body = new HashMap<>();
        
        
        body.put("symbol", "btc_usdt");
        // 签名

        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("validate-timestamp", String.valueOf(time));
        headers.put("validate-appkey", apikey);
        headers.put("validate-algorithms", "HmacSHA256");
        headers.put("validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }


    // To be continued...

}
