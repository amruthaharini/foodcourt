package com.example.foodcourt.beveragesui;

        import org.springframework.core.ParameterizedTypeReference;
        import org.springframework.http.HttpMethod;
        import org.springframework.web.client.RestOperations;
        import org.springframework.web.util.UriComponentsBuilder;

        import java.util.List;

public class BeverageClient {

    private static ParameterizedTypeReference<List<BeverageUI>> beverageListType = new ParameterizedTypeReference<List<BeverageUI>>() {
    };
    private RestOperations restOperations;
    private String beveragesURL;


    public BeverageClient(String beveragesURL, RestOperations restOperations) {
        this.restOperations = restOperations;
        this.beveragesURL = beveragesURL;
    }

    public void create(BeverageUI beverage) {
        restOperations.postForEntity(beveragesURL, beverage, BeverageUI.class);
    }

    public List<BeverageUI> getAll() {
        return restOperations.exchange(beveragesURL, HttpMethod.GET, null, beverageListType).getBody();
    }

    public void delete(Long id) {
        String deleteURL = new StringBuilder(beveragesURL).append("/").append(id).toString();
        restOperations.delete(beveragesURL);
    }

    public int count(String field, String key) {
        String URI = UriComponentsBuilder.fromUriString(beveragesURL + "/count")
                .queryParam("field", field)
                .queryParam("key", key)
                .build().toUriString();
        return restOperations.getForEntity(URI, Integer.class).getBody();
    }

    public int countAll() {
        return restOperations.getForEntity(beveragesURL + "/count", Integer.class).getBody();
    }

    public List<BeverageUI> findAll(int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(beveragesURL)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, beverageListType).getBody();
    }

    public List<BeverageUI> findRange(String field, String key, int offset, int size) {
        String URI = UriComponentsBuilder.fromUriString(beveragesURL)
                .queryParam("field", field)
                .queryParam("key", key)
                .queryParam("start", offset)
                .queryParam("pageSize", size)
                .toUriString();
        return restOperations.exchange(URI, HttpMethod.GET, null, beverageListType).getBody();

    }

}