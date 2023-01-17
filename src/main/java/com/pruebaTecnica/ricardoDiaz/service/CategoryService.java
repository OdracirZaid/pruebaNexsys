package com.pruebaTecnica.ricardoDiaz.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pruebaTecnica.ricardoDiaz.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class CategoryService {


    public Optional<CategoryEntity[]> getAllCategoryPlatzi() {
        HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest requestPosts = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.escuelajs.co/api/v1/categories"))
                .build();
        try {
            HttpResponse<String> listCategories = httpClient.send(requestPosts, HttpResponse.BodyHandlers.ofString());
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            CategoryEntity[] categories = gson.fromJson(listCategories.body(),CategoryEntity[].class);
            return Optional.of(categories);
        } catch (Exception e) {
            return null;
        }

    }

}

