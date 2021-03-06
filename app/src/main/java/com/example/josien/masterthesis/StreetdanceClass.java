package com.example.josien.masterthesis;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StreetdanceClass extends AppCompatActivity {

    String dancestyle;
    String typepas;
    String beschrijving;
    ArrayList<String> ListNew;
    int index;
    String[] combi;
    ArrayList<String> responseList = new ArrayList<>();
    ArrayList<String> beginPos = new ArrayList<>();
    ArrayList<String> Typepas;
    List<String> c;
    List<List<String>> Algo2 = new ArrayList<>();
    String pas1;
    String pas2 = "";
    String pas3 = "";
    Spinner textView2;
    String string_randomized;
    Spinner textView3;
    Spinner textView4;
    Spinner textView5;
    Spinner Spinner;
    Spinner Spinner2;
    Spinner Spinner3;
    Spinner Spinner4;
    Spinner Spinner5;
    Spinner Spinner6;
    JSONArray art_objects;
    Random random = new Random();
    String return1;
    String return2;
    String return3;
    String return11;
    String return22;
    String return33;
    String return111;
    String return222;
    String return333;
    int firstrandom;
    int secondrandom;
    int thirdrandom;
    List<String> first;
    List<String> second;
    List<String> third;
    String[] xfirst;
    String[] xsecond;
    String[] xthird;
    JSONArray body_parts;
    String lichaamsdeelnummer;
    String lichaamsdeel;
    String beschrijvingbodypart;
    String type_beweging;
    String[] combination;
    List<String> List1;
    String newstring ="";
    String returnValue;
    String returns;
    List<List<String>> List2 = new ArrayList<>();
    ArrayList<String> allbodyparts = new ArrayList<>();
    ArrayList<String> Po = new ArrayList<>();
    ArrayList<String> Zo = new ArrayList<>();
    ArrayList<String> ListA = new ArrayList<>();
    int index1;
    int index2;
    String fluent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.streetdance_activity);
        parseJSON();
        parseBodyParts();
    }

    private String getJSONString(Context context) {
        String str = "";
        try {
            AssetManager assetManager = context.getAssets();
            InputStream in = assetManager.open("2304.json");
            InputStreamReader isr = new InputStreamReader(in);

            char[] inputBuffer = new char[100];

            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return str;
    }

    public void parseJSON() {
        Algo2.clear();
        JSONObject json = new JSONObject();


        try {

            json = new JSONObject(getJSONString(getApplicationContext()));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            art_objects = json.getJSONArray("record");

            // Loop through the items till it ends
            for (int i = 0; i < art_objects.length(); i++) {
                JSONObject tijd = art_objects.getJSONObject(i);
                dancestyle = tijd.getString("Style");
                typepas = tijd.getString("TypePas");
                beschrijving = tijd.getString("Beschrijving");

                if (dancestyle.equals("Streetdance")) {
                    if (typepas.equals("Startpositie")) {
                        beginPos.add(beschrijving);
                    }

                    responseList.add(beschrijving);


                    ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    textView2 = (Spinner)
                            findViewById(R.id.autocomplete2);
                    textView2.setAdapter(adapter2);

                    ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    textView3 = (Spinner)
                            findViewById(R.id.autocomplete3);
                    textView3.setAdapter(adapter3);

                    ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    textView4 = (Spinner)
                            findViewById(R.id.autocomplete4);
                    textView4.setAdapter(adapter4);

                    ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    textView5 = (Spinner)
                            findViewById(R.id.autocomplete5);
                    textView5.setAdapter(adapter5);

                    ArrayAdapter<String> adapter6 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    Spinner = (Spinner)
                            findViewById(R.id.spinner);
                    Spinner.setAdapter(adapter6);

                    ArrayAdapter<String> adapter7 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    Spinner2 = (Spinner)
                            findViewById(R.id.spinner2);
                    Spinner2.setAdapter(adapter7);

                    ArrayAdapter<String> adapter8 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    Spinner3 = (Spinner)
                            findViewById(R.id.spinner3);
                    Spinner3.setAdapter(adapter8);

                    ArrayAdapter<String> adapter9 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    Spinner4 = (Spinner)
                            findViewById(R.id.spinner4);
                    Spinner4.setAdapter(adapter9);

                    ArrayAdapter<String> adapter10 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    Spinner5 = (Spinner)
                            findViewById(R.id.spinner5);
                    Spinner5.setAdapter(adapter10);

                    ArrayAdapter<String> adapter11 = new ArrayAdapter<>(this,
                            android.R.layout.simple_dropdown_item_1line, responseList);
                    Spinner6 = (Spinner)
                            findViewById(R.id.spinner6);
                    Spinner6.setAdapter(adapter11);

                    Typepas = new ArrayList<>();
                    combi = new String[]{typepas + "," + beschrijving};


                    c = Arrays.asList(combi);

                    Algo2.add(c);
                    Log.d("watismis", "parseJSON() returned: " + Algo2);

                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void randomizer(View view) throws JSONException {


        TextView stap2 = (TextView) textView2.getSelectedView();
        TextView stap3 = (TextView) textView3.getSelectedView();
        TextView stap4 = (TextView) textView4.getSelectedView();
        TextView stap5 = (TextView) textView5.getSelectedView();
        TextView stap6 = (TextView) Spinner.getSelectedView();
        TextView stap7 = (TextView) Spinner2.getSelectedView();
        TextView stap8 = (TextView) Spinner3.getSelectedView();
        TextView stap9 = (TextView) Spinner4.getSelectedView();
        TextView stap10 = (TextView) Spinner5.getSelectedView();
        TextView stap11 = (TextView) Spinner6.getSelectedView();

        String Stap2 = stap2.getText().toString();
        String Stap3 = stap3.getText().toString();
        String Stap4 = stap4.getText().toString();
        String Stap5 = stap5.getText().toString();
        String Stap6 = stap6.getText().toString();
        String Stap7 = stap7.getText().toString();
        String Stap8 = stap8.getText().toString();
        String Stap9 = stap9.getText().toString();
        String Stap10 = stap10.getText().toString();
        String Stap11 = stap11.getText().toString();

        ArrayList<String> List = new ArrayList<>();
        ArrayList<String> ListNew = new ArrayList<>();

        List.add(Stap2);
        List.add(Stap3);
        List.add(Stap4);
        List.add(Stap5);
        List.add(Stap6);
        List.add(Stap7);
        List.add(Stap8);
        List.add(Stap9);
        List.add(Stap10);
        List.add(Stap11);

        ListNew.add(Stap2);
        ListNew.add(Stap3);
        ListNew.add(Stap4);
        ListNew.add(Stap5);
        ListNew.add(Stap6);
        ListNew.add(Stap7);
        ListNew.add(Stap8);
        ListNew.add(Stap9);
        ListNew.add(Stap10);
        ListNew.add(Stap11);

        Random random = new Random();
        int index = random.nextInt(List.size());
        pas1 = responseList.get(random.nextInt(responseList.size()));
        if (List.contains(pas1)) {
            pas1 = responseList.get(random.nextInt(responseList.size()));
            if (List.contains(pas1)) {
                pas1 = responseList.get(random.nextInt(responseList.size()));
                if (List.contains(pas1)) {
                    pas1 = responseList.get(random.nextInt(responseList.size()));
                }
            }
        }

        ListNew.set(index, pas1);

        final AlertDialog.Builder builder = new AlertDialog.Builder(StreetdanceClass.this, R.style.AlertDialogCustom);

        builder
                .setTitle("PROBEER DIT EENS")
                .setMessage(Html.fromHtml("<h3>"+"Dit is nu je choreografie: "+"</h3>" + "\r\n" + "<br>" + "<h1>"+List+"</h1>"+
                        "\r\n" + "<br>" + "<h3>"+"verander je choreografie naar: "+"</h3>" + "\r\n" + "<br>" + "<h1>"+ListNew+"</h1>"))
                .setPositiveButton("Ik heb het uitgevoerd", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void random() {
        index1 = random.nextInt(ListA.size());
        index2 = random.nextInt(ListA.size());
    }


    public void algorithm(View view) {

        TextView stap2 = (TextView) textView2.getSelectedView();
        TextView stap3 = (TextView) textView3.getSelectedView();
        TextView stap4 = (TextView) textView4.getSelectedView();
        TextView stap5 = (TextView) textView5.getSelectedView();
        TextView stap6 = (TextView) Spinner.getSelectedView();
        TextView stap7 = (TextView) Spinner2.getSelectedView();
        TextView stap8 = (TextView) Spinner3.getSelectedView();
        TextView stap9 = (TextView) Spinner4.getSelectedView();
        TextView stap10 = (TextView) Spinner5.getSelectedView();
        TextView stap11 = (TextView) Spinner6.getSelectedView();

        String Stap2 = stap2.getText().toString();
        String Stap3 = stap3.getText().toString();
        String Stap4 = stap4.getText().toString();
        String Stap5 = stap5.getText().toString();
        String Stap6 = stap6.getText().toString();
        String Stap7 = stap7.getText().toString();
        String Stap8 = stap8.getText().toString();
        String Stap9 = stap9.getText().toString();
        String Stap10 = stap10.getText().toString();
        String Stap11 = stap11.getText().toString();

        ListA = new ArrayList<>();
        ListNew = new ArrayList<>();
        Po = new ArrayList<>();

        ListA.add(Stap2);
        ListA.add(Stap3);
        ListA.add(Stap4);
        ListA.add(Stap5);
        ListA.add(Stap6);
        ListA.add(Stap7);
        ListA.add(Stap8);
        ListA.add(Stap9);
        ListA.add(Stap10);
        ListA.add(Stap11);

        ListNew.add(Stap2);
        ListNew.add(Stap3);
        ListNew.add(Stap4);
        ListNew.add(Stap5);
        ListNew.add(Stap6);
        ListNew.add(Stap7);
        ListNew.add(Stap8);
        ListNew.add(Stap9);
        ListNew.add(Stap10);
        ListNew.add(Stap11);


        returnValue = "";

        Random random = new Random();
        index = random.nextInt(ListA.size());

        string_randomized = ListA.get(index);
        String ran_string;


        if (string_randomized.equals("Losse pas")) {
            body();

            final AlertDialog.Builder builder = new AlertDialog.Builder(StreetdanceClass.this, R.style.AlertDialogCustom);

            builder
                    .setTitle("PROBEER DIT EENS")
                    .setMessage(Html.fromHtml("<h3>" + "Dit is nu je choreografie: " + "</h3>" + "\r\n" + "<br>" + "<h1>" + ListA + "</h1>" +
                            "\r\n" + "<br>" + "<h3>" + "verander een losse pas naar: " + "</h3>" + "\r\n" + "<br>" + "<h1>" + return11 +
                            " " + return22 + " " + return33 + "</h1>"))
                    .setPositiveButton("Ik heb het uitgevoerd", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    })
                    .show();

        } else {

            for (List<String> algor : Algo2) {
                if (algor.toString().contains(string_randomized)) {
                    String r[] = algor.toString().split(",");
                    returns = r[r.length - 1];
                    ran_string = returns.substring(0, returns.length() - 1);
                    if (ran_string.equals(string_randomized)) {
                        newstring = r[0];
                        newstring = newstring.substring(1);

                        Log.d("dance_style", "algorithm() returned: " + newstring);

                        alert();
                    }
                }
            }
        }
    }

    public void alert() {
        for (List<String> algor : Algo2) {
            if (algor.toString().contains(newstring)) {
                String re[] = algor.toString().split(",");
                returns = re[re.length - 1];
                returns = returns.substring(0, returns.length() - 1);
                Po.add(returns);
                pas2 = Po.get(random.nextInt(Po.size()));
                if (ListA.contains(pas2)) {
                    pas2 = Po.get(random.nextInt(Po.size()));
                    if (ListA.contains(pas2)) {
                        pas2 = Po.get(random.nextInt(Po.size()));
                        if (ListA.contains(pas2)) {
                            pas2 = Po.get(random.nextInt(Po.size()));
                        }
                    }
                }
            }

            if (algor.toString().contains(pas2)) {
                if (pas2.equals("Losse pas")) {
                    body();

                    final AlertDialog.Builder builder = new AlertDialog.Builder(StreetdanceClass.this, R.style.AlertDialogCustom);
                    builder
                            .setTitle("PROBEER DIT EENS")
                            .setMessage(Html.fromHtml("<h3>" + "Dit is nu je choreografie: " + "</h3>" + "\r\n" + "<br>" + "<h1>" + ListA + "</h1>" +
                                    "\r\n" + "<br>" + "<h3>" + "verander " + string_randomized + " naar" + "</h3>" + "\r\n" + "<br>" + "<h1>" + return11 +
                                    " " + return22 + " " + return33 + "</h1>"))
                            .setPositiveButton("Ik heb het uitgevoerd", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            })
                            .show();

                } else {
                    String result[] = algor.toString().split(",");
                    returnValue = result[0];
                    returnValue = returnValue.substring(1);
                }
            }
        }

        if (newstring.equals(returnValue)) {
            ListNew.set(index, pas2);
            final AlertDialog.Builder builder = new AlertDialog.Builder(StreetdanceClass.this, R.style.AlertDialogCustom);

            builder
                    .setTitle("PROBEER DIT EENS")
                    .setMessage(Html.fromHtml("<h3>" + "Dit is nu je choreografie: " + "</h3>" + "\r\n" + "<br>" + "<h1>" + ListA + "</h1>" +
                            "\r\n" + "<br>" + "<h3>" + "verander je choreografie naar: " + "</h3>" + "\r\n" + "<br>" + "<h1>" + ListNew + "</h1>"))
                    .setPositiveButton("Ik heb het uitgevoerd", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        }
    }


    private String getJSON(Context context) {
        String str = "";
        try {
            AssetManager assetManager = context.getAssets();
            InputStream in = assetManager.open("nieuwlos.json");
            InputStreamReader isr = new InputStreamReader(in);

            char[] inputBuffer = new char[100];

            int charRead;
            while ((charRead = isr.read(inputBuffer)) > 0) {
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return str;
    }

    public void parseBodyParts() {
        JSONObject json = new JSONObject();


        try {
            json = new JSONObject(getJSON(getApplicationContext()));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {
            body_parts = json.getJSONArray("record");

            // Loop through the items till it ends
            for (int i = 0; i < body_parts.length(); i++) {
                JSONObject tijd = body_parts.getJSONObject(i);
                beschrijvingbodypart = tijd.getString("Beschrijving");
                lichaamsdeelnummer = tijd.getString("Lichaamsdeelnummer");
                lichaamsdeel = tijd.getString("Lichaamsdeel");
                type_beweging = tijd.getString("Type_beweging");

                allbodyparts.add(beschrijvingbodypart + " " + lichaamsdeelnummer + " " + type_beweging);
                combination = new String[]{beschrijvingbodypart + "," + lichaamsdeelnummer + "," + type_beweging};

                List1 = Arrays.asList(combination);

                List2.add(List1);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void body() {

        getRandoms();
        for (int i = 0; i < ListA.size(); i++) {
            ListA.get(i);
        }

        if (return111.equals(return222) || return222.equals(return333) || return111.equals(return333)) {
            body();
        }

        if (return1.equals("Fluent") || return2.equals("Fluent") || return3.equals("Fluent")) {
            if (return1.equals("Fluent")) {
                return11 = xfirst[0];
                return11 = return11.substring(1);
                return22 = "";
                return33 = "";
                fluent = return11;

            }
            if (return2.equals("Fluent")) {
                return22 = xsecond[0];
                return22 = return22.substring(1);
                return11 = "";
                return33 = "";
                fluent = return22;
            }
            if (return3.equals("Fluent")) {
                return33 = xthird[0];
                return33 = return33.substring(1);
                return22 = "";
                return11 = "";
                fluent = return33;
            }

        }

        // if everything is static and not the same bodypart; give description
        if (return1.equals(return2) && (return2.equals(return3))) {
            return11 = xfirst[0];
            return11 = return11.substring(1);

            return22 = xsecond[0];
            return22 = return22.substring(1);

            return33 = xthird[0];
            return33 = return33.substring(1);
        }
    }

    public void getRandoms() {
        firstrandom = random.nextInt(List2.size());
        secondrandom = random.nextInt(List2.size());
        thirdrandom = random.nextInt(List2.size());
        first = List2.get(firstrandom);
        second = List2.get(secondrandom);
        third = List2.get(thirdrandom);
        xfirst = first.toString().split(",");
        xsecond = second.toString().split(",");
        xthird = third.toString().split(",");


        //checks fluent or static
        return1 = xfirst[xfirst.length - 1];
        return1 = return1.substring(0, return1.length() - 1);

        return2 = xsecond[xsecond.length - 1];
        return2 = return2.substring(0, return2.length() - 1);

        return3 = xthird[xthird.length - 1];
        return3 = return3.substring(0, return3.length() - 1);

        //checks for same bodypartnumber
        return111 = xfirst[1];
        return222 = xsecond[1];
        return333 = xthird[1];
    }

    public void algo(View view) throws InterruptedException {
        double d = Math.random() * 100;
        if ((d < 65)) {
            Button btn;
            btn = (Button) findViewById(R.id.button5);

            btn.performClick();
        }
        if ((65 < d && d < 76)) {
            Button btn;
            btn = (Button) findViewById(R.id.okey);

            btn.performClick();
        }
        if ((76 < d && d < 101)) {
            TextView stap2 = (TextView) textView2.getSelectedView();
            TextView stap3 = (TextView) textView3.getSelectedView();
            TextView stap4 = (TextView) textView4.getSelectedView();
            TextView stap5 = (TextView) textView5.getSelectedView();
            TextView stap6 = (TextView) Spinner.getSelectedView();
            TextView stap7 = (TextView) Spinner2.getSelectedView();
            TextView stap8 = (TextView) Spinner3.getSelectedView();
            TextView stap9 = (TextView) Spinner4.getSelectedView();
            TextView stap10 = (TextView) Spinner5.getSelectedView();
            TextView stap11 = (TextView) Spinner6.getSelectedView();

            String Stap2 = stap2.getText().toString();
            String Stap3 = stap3.getText().toString();
            String Stap4 = stap4.getText().toString();
            String Stap5 = stap5.getText().toString();
            String Stap6 = stap6.getText().toString();
            String Stap7 = stap7.getText().toString();
            String Stap8 = stap8.getText().toString();
            String Stap9 = stap9.getText().toString();
            String Stap10 = stap10.getText().toString();
            String Stap11 = stap11.getText().toString();


            ListA = new ArrayList<>();
            ArrayList<String> ListN = new ArrayList<>();
            Po = new ArrayList<>();

            ListA.add(Stap2);
            ListA.add(Stap3);
            ListA.add(Stap4);
            ListA.add(Stap5);
            ListA.add(Stap6);
            ListA.add(Stap7);
            ListA.add(Stap8);
            ListA.add(Stap9);
            ListA.add(Stap10);
            ListA.add(Stap11);

            ListN.add(Stap2);
            ListN.add(Stap3);
            ListN.add(Stap4);
            ListN.add(Stap5);
            ListN.add(Stap6);
            ListN.add(Stap7);
            ListN.add(Stap8);
            ListN.add(Stap9);
            ListN.add(Stap10);
            ListN.add(Stap11);

            String returnValue = "";
            String returns;
            String returnVal = "";
            Random random = new Random();
            random();

            if (index1 == index2) {
                random();
            }

            String ratata = ListA.get(index1);
            String ratat = ListA.get(index2);
            String sja;
            String sjo = "";
            String tra;
            String tro = "";


            if (ratata.equals("Losse pas")) {
                body();

                final AlertDialog.Builder builder = new AlertDialog.Builder(StreetdanceClass.this, R.style.AlertDialogCustom);
                //final AlertDialog.Builder builder = new AlertDialog.Builder(BalletClass.this);
                builder
                        .setTitle("PROBEER DIT EENS")
                        .setMessage(Html.fromHtml("<h3>"+"Dit is nu je choreografie: "+"</h3>" + "\r\n" + "<br>" + "<h1>"+ ListA +"</h1>"+
                                "\r\n" + "<br>" + "<h3>"+"verander een losse pas naar: " +"</h3>" + "\r\n" + "<br>" + "<h1>"+ return11 +
                                " " + return22 + " " + return33 + "</h1>"))
                        .setPositiveButton("Ik heb het uitgevoerd", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }


            for (List<String> algor : Algo2) {
                if (algor.toString().contains(ratata)) {
                    String r[] = algor.toString().split(",");
                    returns = r[r.length - 1];
                    sja = returns.substring(0, returns.length() - 1);
                    if (sja.equals(ratata)) {
                        sjo = r[0];
                        sjo = sjo.substring(1);
                    }
                }
                if (algor.toString().contains(ratat)) {
                    String r[] = algor.toString().split(",");
                    returns = r[r.length - 1];
                    tra = returns.substring(0, returns.length() - 1);
                    if (tra.equals(ratat)) {
                        tro = r[0];
                        tro = tro.substring(1);
                    }
                }
                if (algor.toString().contains(sjo)) {
                    String re[] = algor.toString().split(",");
                    returns = re[re.length - 1];
                    returns = returns.substring(0, returns.length() - 1);
                    Po.add(returns);
                    pas2 = Po.get(random.nextInt(Po.size()));
                    if (ListA.contains(pas2)) {
                        pas2 = Po.get(random.nextInt(Po.size()));
                        if (ListA.contains(pas2)) {
                            pas2 = Po.get(random.nextInt(Po.size()));
                            if (ListA.contains(pas2)) {
                                pas2 = Po.get(random.nextInt(Po.size()));
                            }
                        }
                    }
                }
                if (algor.toString().contains(tro)) {
                    String re[] = algor.toString().split(",");
                    returns = re[re.length - 1];
                    returns = returns.substring(0, returns.length() - 1);
                    Zo.add(returns);
                    pas3 = Zo.get(random.nextInt(Zo.size()));
                    if (ListA.contains(pas3)) {
                        pas3 = Zo.get(random.nextInt(Zo.size()));
                        if (ListA.contains(pas3)) {
                            pas3 = Zo.get(random.nextInt(Zo.size()));
                            if (ListA.contains(pas3)) {
                                pas3 = Zo.get(random.nextInt(Zo.size()));
                            }
                        }
                    }
                }

                if (algor.toString().contains(pas2)) {
                    String result[] = algor.toString().split(",");
                    returnValue = result[0];
                    returnValue = returnValue.substring(1);
                }

                if (algor.toString().contains(pas3)) {
                    String result[] = algor.toString().split(",");
                    returnVal = result[0];
                    returnVal = returnVal.substring(1);
                }
            }

            if (tro.equals(returnVal)) {
                if (sjo.equals(returnValue)){
                    ListN.set(index1, pas2);
                    ListN.set(index2, pas3);
                    final AlertDialog.Builder builder = new AlertDialog.Builder(StreetdanceClass.this, R.style.AlertDialogCustom);

                    builder
                            .setTitle("PROBEER DIT EENS")
                            .setMessage(Html.fromHtml("<h3>"+"Dit is nu je choreografie: "+"</h3>" + "\r\n" + "<br>" + "<h1>"+ListA+"</h1>"+
                                    "\r\n" + "<br>" + "<h3>"+"verander je choreografie naar: "+"</h3>" + "\r\n" + "<br>" + "<h1>"+ListN+"</h1>"))
                            .setPositiveButton("Ik heb het uitgevoerd", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                }
            }
        }
    }
}
