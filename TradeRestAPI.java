package api.RESTful.contract;

import api.utils.HttpUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeRestAPI {

    // 网站申请的密钥对
    private final static String apikey = "";
    private final static String secretKey = "";

    private final static String URL = "https://fapi.xt.com";

    //POST撤销订单
    @Test
    public void orderCancel() {
        String path = "/future/trade/v1/order/cancel";
        Map<String, Object> body = new HashMap<>();
        body.put("orderId", "72867985060018816");

        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));

        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST撤销所有订单
    @Test
    public void orderCancelAll() {
        String path = "/future/trade/v1/order/cancel-all";
        Map<String, Object> body = new HashMap<>();
        body.put("symbol", "dao_usdt");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST下单
    @Test
    public void orderCreate() {
        String path = "/future/trade/v1/order/create";
        Map<String, Object> body = new HashMap<>();
        body.put("symbol", "btc_usdt");
        body.put("marketOrderLevel", "5");
        body.put("orderSide", "BUY");
        body.put("orderType", "LIMIT");
        body.put("origQty", "100");
        body.put("positionSide", "LONG");
        body.put("price", "60000.3123");
        body.put("timeInForce", "GTC");
//		map.put("triggerProfitPrice", "631342.4321");
//		map.put("triggerStopPrice", "521312.1213");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST批量下单
    @Test
    public void orderCreateBatch() {
        String path = "/future/trade/v1/order/create-batch";
        Map<String, Object> body = new HashMap<>();
        List<Map> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> temp = new HashMap<>();
            temp.put("symbol", "btc_usdt");
            temp.put("marketOrderLevel", "5");
            temp.put("orderSide", "BUY");
            temp.put("orderType", "LIMIT");
            temp.put("origQty", "100");
            temp.put("positionSide", "LONG");
            temp.put("price", "60000.3123");
            temp.put("timeInForce", "GTC");
            list.add(temp);
        }
        body.put("list", list);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //GET根据id查询订单
    @Test
    public void orderDetail() {
        String path = "/future/trade/v1/order/detail";
        Map<String, Object> parmas = new HashMap<>();
        parmas.put("orderId", 71510893329940800L);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, parmas, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, parmas);
        System.out.println(text);
    }

    //GET查询订单
    @Test
    public void orderList() {
        String path = "/future/trade/v1/order/list";
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        params.put("state", "NEW");
//        params.put("startTime", 1646751525627L);
//        params.put("endTime", 1646989510323"L);
        params.put("forceClose", false);
        params.put("page", 1);
        params.put("size", 10);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }


    //GET查询历史订单
    @Test
    public void gethistoryOrders() {
        String path = "/future/trade/v1/order/list-history";
        Map<String, Object> params = new HashMap<>();


        params.put("symbol", "btc_usdt");
        params.put("direction", "PREV");
//        params.put("startTime", 1646751525627L);
//        params.put("endTime", 1646989510323"L);
//        params.put("id", 72509073051892352L);
        params.put("limit", 10);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET查询成交明细
    @Test
    public void getOrderTradeList() {
        String path = "/future/trade/v1/order/trade-list";
        Map<String, Object> params = new HashMap<>();


        params.put("orderId", 72084135279070720L);
        params.put("page", 1);
        params.put("size", 10);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //POST撤销所有计划委托
    @Test
    public void entrustCancelAllPlan() {
        String path = "/future/trade/v1/entrust/cancel-all-plan";
        Map<String, Object> body = new HashMap<>();


        body.put("symbol", "btc_usdt");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST撤销所有止盈止损
    @Test
    public void entrustCancelAllProfitStop() {
        String path = "/future/trade/v1/entrust/cancel-all-profit-stop";
        Map<String, Object> body = new HashMap<>();


        body.put("symbol", "btc_usdt");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST撤销计划委托
    @Test
    public void entrustCancelPlan() {
        String path = "/future/trade/v1/entrust/cancel-plan";
        Map<String, Object> body = new HashMap<>();
        body.put("entrustId", "72760717073231424");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST撤销止盈止损
    @Test
    public void entrustCancelProfit() {
        String path = "/future/trade/v1/entrust/cancel-profit-stop";
        Map<String, Object> body = new HashMap<>();


        body.put("profitId", "72509073051892352");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST创建计划委托
    @Test
    public void entrustCratePlan() {
        String path = "/future/trade/v1/entrust/create-plan";
        Map<String, Object> body = new HashMap<>();


        body.put("entrustType", "TAKE_PROFIT");
        body.put("orderSide", "BUY");
        body.put("origQty", "100");
        body.put("positionSide", "LONG");
        body.put("price", "62003.22");
        body.put("stopPrice", "62002.22");
        body.put("symbol", "btc_usdt");
        body.put("timeInForce", "IOC");
        body.put("triggerPriceType", "MARK_PRICE");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //POST创建止盈止损
    @Test
    public void entrustCreateProfit() {
        String path = "/future/trade/v1/entrust/create-profit";
        Map<String, Object> body = new HashMap<>();


        body.put("origQty", "200");
        body.put("positionSide", "LONG");
        body.put("symbol", "btc_usdt");
        body.put("triggerProfitPrice", "70000");
        body.put("triggerStopPrice", "40000");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }

    //GET根据entrustId查询计划委托
    @Test
    public void getEntrustPlanDetail() {
        String path = "/future/trade/v1/entrust/plan-detail";
        Map<String, Object> params = new HashMap<>();


        params.put("entrustId", 72760717073231424L);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET查询计划委托列表
    @Test
    public void entrustPlanList() {
        String path = "/future/trade/v1/entrust/plan-list";
        Map<String, Object> params = new HashMap<>();


        params.put("symbol", "btc_usdt");
        params.put("state", "NOT_TRIGGERED");
//        params.put("startTime", 72509073051892352L);
//        params.put("endTime", 72509073051892352L);
        params.put("page", 1);
        params.put("size", 10);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET查询历史计划委托
    @Test
    public void getHistoryOlanList() {
        String path = "/future/trade/v1/entrust/plan-list-history";
        Map<String, Object> params = new HashMap<>();


        params.put("symbol", "btc_usdt");
        params.put("direction", "NEXT");
//        params.put("startTime", 72509073051892352L);
//        params.put("endTime", 72509073051892352L);
//        params.put("id", 72509073051892352L);
        params.put("limit", 10);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET根据profitId查询止盈止损
    @Test
    public void entrustProfitDetail() {
        String path = "/future/trade/v1/entrust/profit-detail";
        Map<String, Object> params = new HashMap<>();


        params.put("profitId", 72509073051892352L);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //GET查询止盈止损
    @Test
    public void entrustProfitList() {
        String path = "/future/trade/v1/entrust/profit-list";
        Map<String, Object> params = new HashMap<>();


        params.put("symbol", "btc_usdt");
        params.put("state", "USER_REVOCATION");
//        params.put("startTime", 72509073051892352L);
//        params.put("endTime", 72509073051892352L);
//        params.put("id", 72509073051892352L);
        params.put("page", 1);
        params.put("size", 10);
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, params, null, apikey, secretKey, time
        ));
        String text = HttpUtil.get(URL + path, headers, params);
        System.out.println(text);
    }

    //POST修改止盈止损
    @Test
    public void entrustUpdateProfit() {
        String path = "/future/trade/v1/entrust/update-profit-stop";
        Map<String, Object> body = new HashMap<>();
        body.put("profitId", "72509073051892352");
        body.put("triggerProfitPrice", "55500");
        body.put("triggerStopPrice", "35500");
        // 签名
        Map<String, String> headers = new HashMap<>();
        long time = System.currentTimeMillis();
        headers.put("xt-validate-timestamp", String.valueOf(time));
        headers.put("xt-validate-appkey", apikey);
        headers.put("xt-validate-algorithms", "HmacSHA256");
        headers.put("xt-validate-signature", HttpUtil.getContractSignature(
                path, null, body, apikey, secretKey, time
        ));
        String text = HttpUtil.post(URL + path, headers, body);
        System.out.println(text);
    }
    // To be continued...

}
