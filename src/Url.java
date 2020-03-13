import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Url {
    public List<Pessoa> lerJsonUrl(String urlRequisicao) {
        List<Pessoa> lista = new ArrayList<Pessoa>();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        try {
            URL url = new URL(urlRequisicao);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                Type listType = new TypeToken<ArrayList<Pessoa>>() { }.getType();
                lista = gson.fromJson(linha, listType);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
