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
 * Created by urkud on 4/23/2016.
 */
public class ExpenseDetailsController extends AsyncTask<String,Void,String> {

    private Context context;
    public ExpenseDetailsController(Context context) {

        this.context = context;
    }



    @Override
    protected String doInBackground(String... params) {

        String ExpenseAmount = params[0];
        String ExpenseDate = params[1];
        String ExpenseCategory = params[2];
        String ExpenseLocation = params[3];

        System.out.println("###############Inside Controller...");
        System.out.println("********* in controller .. push data");

        //Post method
        try {


            String link = "http://omega.uta.edu/~skr2849/AddExpense.php";
            String data = URLEncoder.encode("ExpenseAmount", "UTF-8") + "=" + URLEncoder.encode(ExpenseAmount, "UTF-8");
            data += "&" + URLEncoder.encode("ExpenseDate", "UTF-8") + "=" + URLEncoder.encode(ExpenseDate, "UTF-8");
            data += "&" + URLEncoder.encode("ExpenseCategory","UTF-8") + "=" + URLEncoder.encode(ExpenseCategory, "UTF-8");
            data += "&" + URLEncoder.encode("ExpenseLocation","UTF-8") + "=" + URLEncoder.encode(ExpenseLocation, "UTF-8");


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

        Toast toast = Toast.makeText(context,"Expense Added successfully",Toast.LENGTH_SHORT);
        toast.show();
    }


}
