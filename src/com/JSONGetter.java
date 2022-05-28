package com;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class JSONGetter  extends Thread{
    private String jsonIn;
    public static String url;
    private String outJson;

    private String readAll(Reader rd) throws IOException{
        StringBuilder sb =new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1){
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public String ConnectAntGetDate(){
        jsonIn ="";
        InputStream is = null;
        try{
            HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(url).openConnection();
//            httpURLConnection.setRequestProperty("X-RapidAPI-Key", "62964ed641msh2a22b3b7a8030ccp16db69jsnfdb46e1120e7");
//            httpURLConnection.setRequestProperty("X-RapidAPI-Host", "community-open-weather-map.p.rapidapi.com");
//            httpURLConnection.setRequestMethod("GET");

            is = httpURLConnection.getInputStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

                try {
                    jsonIn = readAll(rd);
                } catch (IOException e){
                    e.printStackTrace();
                }
            } finally {
                try {
                    is.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return jsonIn;
    }

    @Override
    public void run(){
        outJson = ConnectAntGetDate();
    }

    public String getOutJson() {
        return outJson;
    }
}
