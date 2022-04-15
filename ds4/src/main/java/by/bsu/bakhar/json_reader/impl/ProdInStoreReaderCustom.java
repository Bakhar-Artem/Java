package by.bsu.bakhar.json_reader.impl;

import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.json_adapter.CustomListProdInStoreAdapter;
import by.bsu.bakhar.json_reader.CustomJsonReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProdInStoreReaderCustom implements CustomJsonReader {
    @Override
    public List<ProdInStore> readFromJson(String jsonPath) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Type token = new TypeToken<List<ProdInStore>>() {
        }.getType();
        builder.registerTypeAdapter(token, new CustomListProdInStoreAdapter());
        Gson gson = builder.create();
        FileReader fileReader = new FileReader(jsonPath);
        List<ProdInStore> prodInStoreList = gson.fromJson(fileReader, token);
        fileReader.close();
        return new CopyOnWriteArrayList<>(prodInStoreList);
    }
}
