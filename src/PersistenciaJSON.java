import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PersistenciaJSON implements IGravacao {

    public boolean gravarLista(List<Pessoa> list) {
        try {
            File arq = new File("agenda.json");
            Gson gson = new Gson();
            gson = new GsonBuilder().create();
            List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

            if (arq.exists()) {
                listaPessoas = ler();
            }
            FileWriter writer = new FileWriter("agenda.json");


            for (Pessoa p : list) {
                listaPessoas.add(p);
            }

            String strJson = gson.toJson(listaPessoas);
            writer.write(strJson);

            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public List<Pessoa> ler() {
        File arq = new File("agenda.json");
        ArrayList<Pessoa> patterns = new ArrayList<>();
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        if (arq.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader("agenda.json"));
                JsonElement jsonElement = jsonParser.parse(br);
                Type type = new TypeToken<List<Pessoa>>() {
                }.getType();
                return gson.fromJson(jsonElement, type);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return patterns;

    }

}