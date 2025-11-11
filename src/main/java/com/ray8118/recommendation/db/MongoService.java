package com.ray8118.recommendation.db;

import com.mongodb.client.*;
import org.bson.Document;
import io.github.cdimascio.dotenv.Dotenv;

public class MongoService {
    private static Dotenv dotenv = Dotenv.load();
    private static String mongoDbUri = dotenv.get("MONGODB_URI");
    private static final MongoClient client = MongoClients
            .create(mongoDbUri);
    private static final MongoDatabase db = client.getDatabase("anime_recommendation");
    private static final MongoCollection<Document> collection = db.getCollection("animes");

    public static Document getAnimeById(int id) {
        return collection.find(new Document("id", id)).first();
    }
}