package top.yugle.fuckshangkela.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.time.Instant;

public class RequestUtil {
    public static String generateTimestamp() {
        long timestamp = Instant.now().getEpochSecond();
        return Long.toString(timestamp);
    }

    public String helloSKL(Integer userId,Integer code1) throws IOException {
        String url = "http://124.160.107.92:7009/api/checkIn/code-check-in";
        String cookie = "SESSION=73789953-d2e8-4110-af4f-e209a09775e0";
        String accept = "application/json, text/plain, */*";
        String encoding = "gzip, deflate";
        String language = "zh-CN,zh;q=0.9,ja;q=0.8,en;q=0.7";
        String host = "124.160.107.92:7009";
        String connection = "keep-alive";
        String refer = "http://124.160.107.92:7009/";
        String skl_ticket = "i-7GBBiIHuH6gGDpSKlAo";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36123";
        String userid = String.valueOf(userId);
        String code = String.valueOf(code1);
        String latitude = "30.28840";
        String longitude = "119.82408";
        String t = generateTimestamp();
        HttpClient client = HttpClientBuilder.create().build();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000)
                .build();
        String fullUrl = String.format("%s?userid=%s&code=%s&latitude=%s&longitude=%s&t=%s", url, userid, code, latitude, longitude, t);
        HttpGet request = new HttpGet(fullUrl);
        request.setConfig(requestConfig);
        request.addHeader("cookie", cookie);
        request.addHeader("Accept", accept);
        request.addHeader("Accept-Encoding", encoding);
        request.addHeader("Accept-language", language);
        request.addHeader("Host", host);
        request.addHeader("Connection", connection);
        request.addHeader("Refer", refer);
        request.addHeader("sk-ticke", skl_ticket);
        request.addHeader("User-Agent", userAgent);
        HttpResponse response = client.execute(request);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        return result;
    }
}
