package by.bsu.bakhar.json_writer.impl;

import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.json_writer.CustomJsonWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProductWriterImpl implements CustomJsonWriter<Product> {
    @Override
    public void writeJson(List<Product> list,String jsonPath) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        FileWriter fileWriter = new FileWriter(jsonPath);
        gson.toJson(list, fileWriter);
        fileWriter.close();
    }
}
