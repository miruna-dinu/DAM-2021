package com.example.tema1workoutplan;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public void read(String param_url, IResponse response) {
        try {
            URL url = new URL(param_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String line = "";

            while((line = br.readLine()) != null) {
                sb.append(line);

            }

            List<Program> list = Parsare(sb.toString());

            response.onSucces(list);

            Log.v("afisare", list.toString());

            br.close();
            isr.close();
            is.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Program> Parsare(String jsonString) {
        List<Program> listJSON = new ArrayList<>();

        JSONObject obj = null;
        try {
            obj = new JSONObject(jsonString);
            JSONArray array = obj.getJSONArray("programe");
            for(int i=0; i < array.length(); i++) {
                JSONObject jsonObject=array.getJSONObject(i);
                String zi = jsonObject.getString("zi");
                String exercitiu = jsonObject.getString("exercitiu");
                Integer set = jsonObject.getInt("set");
                Float timp = Float.valueOf(jsonObject.getInt("timp"));

                Program progr = new Program(zi,exercitiu, set, timp);
                listJSON.add(progr);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listJSON;
    }

}
