package com.max;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by lenovo on 2017/4/24.
 */
@Service
public class TokenService {

    public String getToken(String name) throws IOException {
        String re = null;
        CloseableHttpClient httpClient =  HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://192.168.41.49:8085/awifi-oauth-server-web/tokenController/authorizationGrant?oauthCode=" + name);
        CloseableHttpResponse response1 = httpClient.execute(httpGet);

        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            re = EntityUtils.toString(entity1);
            //EntityUtils.consume(entity1);
        } finally {
            response1.close();
        }
        return re;
    }

}
