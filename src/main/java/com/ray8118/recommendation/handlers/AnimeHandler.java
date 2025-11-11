package com.ray8118.recommendation.handlers;

import java.io.IOException;
import java.io.OutputStream;

import org.bson.Document;

import com.ray8118.recommendation.db.MongoService;
import com.ray8118.recommendation.utils.JsonUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class AnimeHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod();
        System.out.println("Path: " + path + " Method: " + method);

        if (method.equalsIgnoreCase("GET")) {
            try {
                if (path.startsWith("/anime/")) {
                    String idStr = path.substring("/anime/".length());
                    int id = Integer.valueOf(idStr);
                    handleGetAnimeById(exchange, id);
                } else {
                    sendResponse(exchange, 404, "Endpoint not found");
                }
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException: " + e.getMessage());
                sendResponse(exchange, 400, "Invalid ID");
            } catch (Exception e) {
                System.out.println("Exception in handle: " + e.getMessage());
                sendResponse(exchange, 500, "Internal server error");
            }
        } else {
            sendResponse(exchange, 405, "Method not allowed");
        }
    }

    public void handleGetAnimeById(HttpExchange exchange, int id) throws IOException {
        try {
            Document anime = MongoService.getAnimeById(id);
            if (anime != null) {
                Document response = new Document()
                        .append("id", anime.getInteger("id"))
                        .append("title", anime.get("title"))
                        .append("averageScore", anime.getInteger("averageScore"));

                sendResponse(exchange, 200, JsonUtil.toJson(response));
            } else {
                sendResponse(exchange, 404, "Anime not found");
            }
        } catch (Exception e) {
            System.out.println("Exception in handleGetAnimeById: " + e.getMessage());
            sendResponse(exchange, 500, "Internal server error");
        }
    }

    private void sendResponse(HttpExchange exchange, int statusCode, String responseText) throws IOException {
        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, responseText.length());
        System.out.println("Statuscode: " + statusCode + " Response :" + responseText);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseText.getBytes());
        }
    }
}