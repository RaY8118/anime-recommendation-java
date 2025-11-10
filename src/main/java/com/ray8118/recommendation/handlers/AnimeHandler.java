package com.ray8118.recommendation.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.bson.Document;

import com.ray8118.recommendation.db.MongoService;
import com.ray8118.recommendation.utils.JsonUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class AnimeHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }

        String path = exchange.getRequestURI().getPath();
        String[] parts = path.split("/");
        if (parts.length < 3) {
            exchange.sendResponseHeaders(400, -1);
            return;
        }

        String animeId = parts[2];
        System.out.println(animeId);
        Document doc = MongoService.getAnimeById(Integer.valueOf(animeId));

        String response;
        if (doc == null) {
            response = JsonUtil.toJson(Map.of("error", "Anime not found"));
            exchange.sendResponseHeaders(404, response.getBytes().length);
        } else {
            response = JsonUtil.toJson(doc);
            exchange.sendResponseHeaders(200, response.getBytes().length);
        }

        exchange.getResponseHeaders().add("Content-Tyepe", "application/json");
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
