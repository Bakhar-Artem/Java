package by.bsu.bakhar.json_writer.impl;

import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.json_adapter.CustomProdInStoreAdapter;
import by.bsu.bakhar.json_writer.CustomJsonWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProdInStoreWriterImpl implements CustomJsonWriter<ProdInStore> {
    private static final String jsonPath = "src/main/resources/data/lab1_store.json";

    @Override
    public void writeJson(List<ProdInStore> prodInStoreList, String jsonPath) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapter(ProdInStore.class, new CustomProdInStoreAdapter());
        Gson gson = builder.create();
        FileWriter fileWriter = new FileWriter(jsonPath);
        gson.toJson(prodInStoreList, fileWriter);
        fileWriter.close();
    }
}
