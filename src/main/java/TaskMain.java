import java.io.*;
import java.net.*;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class TaskMain {
    public static void main(String[] args){

        String myText = "text=Hello worlld, I'm happi";

        try{
            String res = Chek(myText);
            System.out.println(res);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static String Chek(String str) throws IOException {

        str = str.replace(' ', '_');
        //  Передаём строку как параметр
        URL url = new URL("https://speller.yandex.net/services/spellservice.json/checkText?" + str);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        http.setRequestMethod("POST");
        http.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();

        String result;
        Gson g = new Gson();
        WordsErrors[] w = g.fromJson(response.toString(), WordsErrors[].class);
        if(w.length > 0)
        {
            result = "Количество слов с орфографическими ошибками: " + w.length + "\nОшибки в словах:";

            for (int i = 0; i < w.length; i++)
                result = result + "\n" + w[i].getWords();
        }
        else result ="Слов с ошибками нет";



        
        return result;
    }
}

class WordsErrors {
    @SerializedName("word")
    private String words;
    public String getWords(){return this.words;}
}