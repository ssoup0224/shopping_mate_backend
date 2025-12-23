package com.shopping_mate_backend.naver;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class NaverProductService {

    @Value("${NAVER_URL}")
    private String naverUrl;

    @Value("${NAVER_CLIENT_ID}")
    private String naverClientId;

    @Value("${NAVER_CLIENT_SECRET}")
    private String naverClientSecret;

    public List<NaverProductDto> naverShopSearchAPI(NaverRequestVariableDto naverVariable) {
        // 참고 url: https://ssong915.tistory.com/36

        URI uri = UriComponentsBuilder.fromUriString(naverUrl)
                .path("v1/search/shop.json")
                .queryParam("query", naverVariable.getQuery())
                .queryParam("display", naverVariable.getDisplay())
                .queryParam("start", naverVariable.getStart())
                .queryParam("sort", naverVariable.getSort())
                .encode()
                .build()
                .toUri();
        log.info("uri : {}", uri);
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", naverClientId)
                .header("X-Naver-Client-Secret", naverClientSecret)
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        List<NaverProductDto> naverProductDtos = fromJSONtoNaverProduct(result.getBody());

        log.info("result ={}", naverProductDtos);
        return naverProductDtos;

    }

    private List<NaverProductDto> fromJSONtoNaverProduct(String result) {
        // 문자열 정보를 JSONObject로 바꾸기
        JSONObject rjson = new JSONObject(result);
        // JSONObject에서 items 배열 꺼내기
        // JSON 배열이기 때문에 보통 배열이랑 다르게 활용해야한다.
        JSONArray naverProducts = rjson.getJSONArray("items");
        List<NaverProductDto> naverProductDtoList = new ArrayList<>();
        for (int i = 0; i < naverProducts.length(); i++) {
            JSONObject naverProductsJson = (JSONObject) naverProducts.get(i);
            NaverProductDto itemDto = new NaverProductDto(naverProductsJson);
            naverProductDtoList.add(itemDto);
        }
        return naverProductDtoList;
    }

}