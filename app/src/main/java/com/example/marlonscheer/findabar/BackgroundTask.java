package com.example.marlonscheer.findabar;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

class BackgroundTask extends AsyncTask<String,Void,String> {
        private final Context ctx;
        private AlertDialog alertDialog;
        private String result;
        public Button show;


        BackgroundTask(Context ctx) {
            this.ctx = ctx;

        }





        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            alertDialog = new AlertDialog.Builder(ctx).create();
            alertDialog.setTitle("Login Information...");




        }


        @Override
        protected String doInBackground(String... params) {
            String reg_url = "http://192.168.43.157:8888/registerfindabar.php";
            String login_url = "http://192.168.43.157:8888/loginfindabar.php";
            String method = params[0];
            if (method.equals("register")) {
                String name = params[1];
                String user_name = params[2];
                String user_pass = params[3];

                try {
                    URL url = new URL(reg_url);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);

                    OutputStream OS = httpURLConnection.getOutputStream();

                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));


                    String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                            URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                            URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");


                    bufferedWriter.write(data);

                    bufferedWriter.flush();
                    bufferedWriter.close();
                    OS.close();

                    InputStream IS = httpURLConnection.getInputStream();
                    IS.close();


                    return "Registration Success!";


                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else if (method.equals("login")) {
                String login_name = params[1];
                String login_pass = params[2];

                try {
                    URL url = new URL(login_url);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                    httpURLConnection.setRequestMethod("POST");

                    httpURLConnection.setDoOutput(true);


                    httpURLConnection.setDoInput(true);

                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String data = URLEncoder.encode("login_name", "UTF-8") + "=" + URLEncoder.encode(login_name, "UTF-8") + "&" +
                            URLEncoder.encode("login_pass", "UTF-8") + "=" + URLEncoder.encode(login_pass, "UTF-8");

                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();


                    InputStream inputStream = httpURLConnection.getInputStream();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));


                    String response = "";
                    String line;

                    if (login_name == login_name)
                        while ((line = bufferedReader.readLine()) != null) {
                            response += line;
                        }


                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return response;


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            return reg_url;
        }


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);


        }

        @Override
        protected void onPostExecute(String result) {

            //    If login is success or fail

            if (result.equals("Registration Success!")) {
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            }

            else {
                Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            }

            //   Proof for real user data


            if (result.equals("Login failed...try again!")){
                System.out.println("Fail");

            }
            else {
                ctx.startActivity(new Intent(ctx, SecondActivity.class));
            }


        }




    }
