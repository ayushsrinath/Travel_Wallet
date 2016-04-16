package com.example.ayush.controllers;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Ayush on 4/15/2016.
 */
public class RegisterActivityController extends AsyncTask<String,Void,String> {

    private Context context;

    public RegisterActivityController(Context context){

        this.context = context;
    }

    @Override
    protected String doInBackground(String... args) {

        String firstname = args[0];
        String lastname = args[1];
        String phonenumber = args[2];
        String email = args[3];
        String address = args[4];
        String password = args[5];

        System.out.println("###############Inside Controller...");
        System.out.println("********* in controller .. push data");

        //Post method
        try {


            String link = "http://omega.uta.edu/~skr2849/register.php";
            String data = URLEncoder.encode("firstname", "UTF-8") + "=" + URLEncoder.encode(firstname, "UTF-8");
            data += "&" + URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastname, "UTF-8");
            data += "&" + URLEncoder.encode("phonenumber","UTF-8") + "=" + URLEncoder.encode(phonenumber, "UTF-8");
            data += "&" + URLEncoder.encode("email","UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
            data += "&" + URLEncoder.encode("address","UTF-8") + "=" + URLEncoder.encode(address, "UTF-8");
            data += "&" + URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

            System.out.println("#########data - " + data);
            URL url = new URL(link);
            System.out.println("#########url - " + url);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            System.out.println("#########conn - " + conn);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            System.out.println("@@@@@#########wr - " + wr);
            wr.write(data);
            wr.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null)
            {
                sb.append(line);
                break;
            }
            String pnt = sb.toString();
            System.out.println("#############sbToString - " + pnt);
            return sb.toString();

        }catch (Exception e){

                return new String("Exception..."+e.getMessage());
        }
    }
    @Override
    protected void onPostExecute(String result){

        Toast toast = Toast.makeText(context,"registration successful",Toast.LENGTH_SHORT);
        toast.show();
    }


}
