package com.example.ayush.controllers;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by Sahana on 4/18/2016.
 *
 * */
public class LoginController extends AsyncTask<String,Void,String>{

    private String username, password, phpUrl;
    private Context context;

    //initialize the constructor with the LoginActivity context
    public LoginController(Context context){
        this.context = context;
    }

    protected void onPreExecute(){

    }

    //background task to be performed
    @Override
    protected String doInBackground(String... params) {
        username = (String) params[0];
        password = (String) params[1];

        try {
            phpUrl = "https://omega.uta.edu/~skr2849/login.php?username="+username+"&password="+password;
            System.out.println("The phpurl is   " + phpUrl);
            URL url = new URL(phpUrl);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(phpUrl));
            System.out.println("The request is   " + request);
            HttpResponse response = client.execute(request);
            System.out.println("the response is   "  + response);

            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            System.out.println("buffered in obj " + in);
            StringBuffer sb = new StringBuffer("");
            String line="";

            while ((line = in.readLine()) != null) {
                sb.append(line);
                break;
            }
            in.close();
            System.out.println("sb. tostring is    " + sb.toString());
            return sb.toString();

        }catch (Exception e) {
            return new String("Exception..." + e.getMessage());
        }
    }

    //code to be executed after completion of doInBackground method
    @Override
    protected void onPostExecute(String result){
        Toast toast = Toast.makeText(context,"login successful",Toast.LENGTH_SHORT);
        toast.show();
    }
}
