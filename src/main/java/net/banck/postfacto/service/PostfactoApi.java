package net.banck.postfacto.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.banck.postfacto.model.ActionItem;
import net.banck.postfacto.model.Item;
import net.banck.postfacto.model.Retro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@Service
public class PostfactoApi {

    private final PostfactoApiConfiguration properties;

    private HttpHeaders headers;
    private RestTemplate restTemplate;

    @Autowired
    public PostfactoApi(PostfactoApiConfiguration properties) {
        this.properties = properties;
        this.headers = createHeaders();
        this.restTemplate = restTemplate();
    }

    private HttpHeaders createHeaders () {
        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("authorization", String.format("Bearer %s", this.properties.getToken()));
        return headers;
    }

    private RestTemplate restTemplate () {
        // object mapper to support @JsonRootName
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        MappingJackson2HttpMessageConverter jackson = new MappingJackson2HttpMessageConverter();
        jackson.setObjectMapper(objectMapper);

        // create rest template
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
        restTemplate.getMessageConverters().add(jackson);

        return restTemplate;
    }

    public ActionItem createAction(String description) {

        HttpEntity<ActionItem> request = new HttpEntity<>(new ActionItem(description), this.headers);
        String url = String.format("%s/retros/%s/action_items", this.properties.getUrl(), this.properties.getTeam());

        return this.restTemplate.postForObject(url, request, ActionItem.class);
    }

    public Item createItem(String description, String category){

        HttpEntity<Item> request = new HttpEntity<>(new Item(description, category), this.headers);
        String url = String.format("%s/retros/%s/items", this.properties.getUrl(), this.properties.getTeam());

        return this.restTemplate.postForObject(url, request, Item.class);
    }

    public Retro getRetro() throws IOException {
        HttpEntity<Item> request = new HttpEntity<>(this.headers);
        String url = String.format("%s/retros/%s", this.properties.getUrl(), this.properties.getTeam());

        ResponseEntity<Retro> response = this.restTemplate.exchange(url, HttpMethod.GET, request, Retro.class);
        return response.getBody();
    }
}
