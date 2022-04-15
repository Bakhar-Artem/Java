package by.bsu.bakhar.json_adapter;

import by.bsu.bakhar.entity.ProdInStore;
import by.bsu.bakhar.entity.Product;
import by.bsu.bakhar.entity.Store;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;


public class CustomProdInStoreAdapter extends TypeAdapter<ProdInStore> {
    @Override
    public void write(JsonWriter jsonWriter, ProdInStore prodInStore) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        jsonWriter.beginObject();
        jsonWriter.name("product");
        String string = gson.toJson(prodInStore.getProduct());
        jsonWriter.jsonValue(gson.toJson(prodInStore.getProduct()));
        jsonWriter.name("store");
        jsonWriter.jsonValue(gson.toJson(prodInStore.getStore()));
        jsonWriter.name("amount");
        jsonWriter.value(prodInStore.getAmount());
        jsonWriter.endObject();
    }

    @Override
    public ProdInStore read(JsonReader jsonReader) throws IOException {
        ProdInStore prodInStore = new ProdInStore();

        Gson gson = new Gson();
        String fieldname = null;

        while (jsonReader.hasNext()) {
            JsonToken token = jsonReader.peek();
            if (token.equals(JsonToken.BEGIN_OBJECT)) {
                jsonReader.beginObject();
            }
            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = jsonReader.nextName();
            }
            if (token.equals(JsonToken.END_OBJECT)) {
                jsonReader.endObject();
            }

            if ("product".equals(fieldname)) {
                //move to next token
                token = jsonReader.peek();
                Product product = gson.fromJson(jsonReader, Product.class);
                prodInStore.setProduct(product);
            }

            if ("store".equals(fieldname)) {
                //move to next token
                token = jsonReader.peek();
                Store store = gson.fromJson(jsonReader, Store.class);
                prodInStore.setStore(store);
            }
            if ("amount".equals(fieldname)) {
                //move to next token
                token = jsonReader.peek();
                prodInStore.setAmount(jsonReader.nextInt());
            }

        }
        return prodInStore;
    }
}
