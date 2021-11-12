import java.io.*;
import java.net.*;

import org.apache.logging.log4j.*;
import com.google.gson.Gson;
import okhttp3.*;

public class TaskMain {
    private static final Logger LOGGER = LogManager.getLogger(TaskMain.class.getName());

    public static void main(String[] args) {

        String myText = "Hello worlld, I'm happi";
        try {
            String res = chek(myText);
            System.out.println(res);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String chek(String str) throws IOException {

        URL url = new URL("https://speller.yandex.net/services/spellservice.json/checkText");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("text", str)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        String result;
        Gson g = new Gson();
        WordsErrors[] w = g.fromJson(response.body().string(), WordsErrors[].class);
        if (w.length > 0) {
            result = "Количество слов с орфографическими ошибками: " + w.length + "\nОшибки в словах:";

            for (int i = 0; i < w.length; i++)
                result = result + "\n" + w[i].getWords();
        } else result = "Слов с ошибками нет";

        return result;
    }
}