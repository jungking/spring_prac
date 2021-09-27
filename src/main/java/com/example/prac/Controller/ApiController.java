package com.example.prac.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
public class ApiController {

    @GetMapping("/api")      //api 정보 GetMapping
    public String CallApi() throws IOException{
        StringBuffer result = new StringBuffer();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://openapi.kric.go.kr/openapi/convenientInfo/stationToilet");
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=$2a$10$RcNxon/Qcm1TrhHhCLAbseX87hZKIdFC4cBAEyHURGftWP0Qkc/hu");          // 서비스키
            urlBuilder.append("&format=json");                                                               // 데이터 포멧  JSON or Xml
            urlBuilder.append("&" + URLEncoder.encode("railOprIsttCd","UTF-8") + "=1");              // 철도운영기관코드
            urlBuilder.append("&" + URLEncoder.encode("lnCd","UTF-8") + "=3");                       // 선코드
            urlBuilder.append("&" + URLEncoder.encode("stinCd","UTF-8") + "=322");                   // 역코드

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd;

            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else{
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result + "";
    }
}
