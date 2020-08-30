package net.otlg.scrap.wrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.util.UUID;

public class ScrapUtil {
    private final Gson gson = new GsonBuilder().create();

    public UUID toUUID(String stringUUID) {
        return UUID.fromString(stringUUID);
    }

    public String toJson(Object object) {
        return gson.toJson(object);
    }

    public Object fromJson(String json, String typeString) {
        JsonType type = JsonType.valueOf(typeString);
        return gson.fromJson(json, type.getToken().getType());
    }

    public Object getJsonReader(String json) {
        return new JsonReader(new StringReader(json));
    }

    public String getTypeName(Object object){
        return object.getClass().getName();
    }
}
