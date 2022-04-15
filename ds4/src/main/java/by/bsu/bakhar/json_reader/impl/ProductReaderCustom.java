package by.bsu.bakhar.json_reader.impl;

import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.json_reader.CustomJsonReader;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductReaderCustom implements CustomJsonReader {
    @Override
    public List<Product> readFromJson(String jsonPath) throws IOException {
        Gson gson = new Gson();
        FileReader fileReader = new FileReader(jsonPath);
        List<Product> productList = gson.fromJson(fileReader, new TypeToken<List<Product>>() {
        }.getType());
        fileReader.close();
        return new CopyOnWriteArrayList<>(productList);
    }
}
