package by.bsu.bakhar.json_reader.impl;

import by.bsu.bakhar.entity.Store;
import by.bsu.bakhar.json_reader.CustomJsonReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StoreReaderCustom implements CustomJsonReader {
    @Override
    public List<Store> readFromJson(String jsonPath) throws IOException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(jsonPath);
        List<Store> storeList = gson.fromJson(fileReader, new TypeToken<List<Store>>() {
        }.getType());
        fileReader.close();
        return new CopyOnWriteArrayList<>(storeList);
    }
}
