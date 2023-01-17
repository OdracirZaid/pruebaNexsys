package com.pruebaTecnica.ricardoDiaz.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pruebaTecnica.ricardoDiaz.entity.ProductEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class ProductService {

    public Optional<ProductEntity[]> getAllProductPlatzi() {

        HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest requestPosts = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.escuelajs.co/api/v1/products"))
                .build();
        try {
            HttpResponse<String> listProduct = httpClient.send(requestPosts, HttpResponse.BodyHandlers.ofString());
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            ProductEntity[] products = gson.fromJson(listProduct.body(), ProductEntity[].class);
            return Optional.of(products);
        } catch (Exception e) {
            return null;
        }
    }

    public String postProduct(ProductEntity productEntity) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(productEntity);
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost request = new HttpPost("https://api.escuelajs.co/api/v1/products");
            request.addHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(requestBody));
            CloseableHttpResponse response = client.execute(request);
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            ProductEntity product = gson.fromJson(EntityUtils.toString(response.getEntity()), ProductEntity.class);
            return product.toStringId();
        } catch (Exception e) {
            return null;
        }
    }
}

