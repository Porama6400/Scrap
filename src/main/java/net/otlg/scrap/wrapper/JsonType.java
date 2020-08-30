package net.otlg.scrap.wrapper;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public enum JsonType {
    ARRAYLIST_STRING(TypeToken.getParameterized(ArrayList.class, String.class)),
    ARRAYLIST_OBJECT(TypeToken.getParameterized(ArrayList.class, Object.class)),
    HASHMAP_OBJECT_OBJECT(TypeToken.getParameterized(HashMap.class, Object.class, Object.class));

    private final TypeToken<?> token;

    JsonType(TypeToken<?> token) {
        this.token = token;
    }

    public TypeToken<?> getToken() {
        return token;
    }
}
