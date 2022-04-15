package by.bsu.bakhar.json_adapter;

import by.bsu.bakhar.entity.ProdInStore;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomListProdInStoreAdapter extends TypeAdapter<List<ProdInStore>> {
    @Override
    public void write(JsonWriter jsonWriter, List<ProdInStore> prodInStores) throws IOException {

    }

    @Override
    public List<ProdInStore> read(JsonReader jsonReader) throws IOException {
        List<ProdInStore> prodInStoreList = new ArrayList<>();
        Gson gson = new Gson();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            JsonToken token = jsonReader.peek();
            if (token.equals(JsonToken.BEGIN_OBJECT)) {
                ProdInStore prodInStore = gson.fromJson(jsonReader, ProdInStore.class);
                prodInStoreList.add(prodInStore);
            }
        }
        jsonReader.endArray();
        return prodInStoreList;
    }
}
