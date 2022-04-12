package api.RESTful.contract;

import api.utils.HttpUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MarketRestAPI {

    // 网站申请的密钥对
    private final static String accessKey = "";
    private final static String secretKey = "";

    private final static String URL = "https://fapi.xt.com/future/market";

    // 获取交易对风险基金余额
    @Test
    public void getRiskBalance() {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "PREV");
        params.put("id", "1");
        params.put("limit", 10);
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/contract/risk-balance", params);
        System.out.println(text);
    }

    // 获取交易对币种
    @Test
    public void getCoins() {
        String text = HttpUtil.get(URL + "/v1/public/symbol/coins");
        System.out.println(text);
    }

    // 获取单个交易对的配置信息
    @Test
    public void getSymbolDetail() {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/symbol/detail", params);
        System.out.println(text);
    }

    // 获取所有交易对的配置信息
    @Test
    public void getSymbolList() {
        String text = HttpUtil.get(URL + "/v1/public/symbol/list");
        System.out.println(text);
    }

    // 查询单个交易对杠杆分层
    @Test
    public void getLeverage() {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/leverage/bracket/detail", params);
        System.out.println(text);
    }


    // 查询所有交易对杠杆分层
    @Test
    public void getLeverageList() {
        String text = HttpUtil.get(URL + "/v1/public/leverage/bracket/list");
        System.out.println(text);
    }


    // 获取指定交易对的聚合行情信息
    @Test
    public void getAggTicker() {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/agg-ticker", params);
        System.out.println(text);
    }

    // 获取全交易对的聚合行情信息
    @Test
    public void getAggTickers() {
        String text = HttpUtil.get(URL + "/v1/public/q/agg-tickers");
        System.out.println(text);
    }

    // 获取交易对的最新成交信息
    @Test
    public void getSymbolDeals() {
        Map<String, Object> params = new HashMap<>();
        params.put("num", 10);
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/deal", params);
        System.out.println(text);
    }

    // 获取交易对的深度信息
    @Test
    public void getDepth() {
        Map<String, Object> params = new HashMap<>();
        params.put("level", 1);
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/depth", params);
        System.out.println(text);
    }

    // 获取资金费率
    @Test
    public void getFundingRate() {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/funding-rate", params);
        System.out.println(text);
    }

    // GET获取资金费率记录
    @Test
    public void getFundingRateRecord() {
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "PREV");
        params.put("id", 1);
        params.put("limit", 10);
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/funding-rate-record", params);
        System.out.println(text);
    }


    // GET获取交易对的k线信息
    @Test
    public void getKline() {
        Map<String, Object> params = new HashMap<>();
        params.put("interval", "1m"); // 1m 5m 15m 30m 1h 4h 1d 1w
        params.put("limit", 10);
//        params.put("startTime", 1646970869392);
//        params.put("endTime", 1646970869392);
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/kline", params);
        System.out.println(text);
    }

    // 获取单个交易对的指数价格
    @Test
    public void getIndexPrice() {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/symbol-index-price", params);
        System.out.println(text);
    }

    // 获取所有交易对的指数价格
    @Test
    public void getIndexPrices() {
        String text = HttpUtil.get(URL + "/v1/public/q/index-price");
        System.out.println(text);
    }

    // 获取单个交易对的标记价格
    @Test
    public void getSymbolMarkPrice() {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/symbol-mark-price", params);
        System.out.println(text);
    }

    // 获取所有交易对的标记价格
    @Test
    public void getMarkPrices() {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/mark-price", params);
        System.out.println(text);
    }

    // 获取指定交易对的行情信息
    @Test
    public void getTicker() {
        Map<String, Object> params = new HashMap<>();
        params.put("symbol", "btc_usdt");
        String text = HttpUtil.get(URL + "/v1/public/q/ticker", params);
        System.out.println(text);
    }

    // 获取全交易对的行情信息
    @Test
    public void getTickers() {
        String text = HttpUtil.get(URL + "/v1/public/q/tickers");
        System.out.println(text);
    }

    // To be continued...

}
