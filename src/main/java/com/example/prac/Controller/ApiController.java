package com.example.prac.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;

@RestController
public class ApiController {

    @GetMapping("/api")      //api 정보 GetMapping
    public String CallApi() throws IOException{
        StringBuilder result = new StringBuilder();

        String urlStr = "http://openapi.kric.go.kr/openapi/convenientInfo/stationToilet?" +
                "serviceKey=[서비스키값]" +          // 서비스키
                "&format=xml" +                    // 데이터 포멧  JSON or Xml
                "&railOprIsttCd=S1" +              // 철도운영기관코드
                "&lnCd=3" +                        // 선코드
                "&stinCd=322";                      // 역코드

        URL url = new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br;
        br = new BufferedReader


        return "";
    }
}
