package com.example.listview_version1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creamos el array y lo llenamos con los datos que queremos que aparescan en la lista
        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Guatemala");
        nombres.add("El Salvador");
        nombres.add("Honduras");
        nombres.add("Nicaragua");
        nombres.add("Costa Rica");
        nombres.add("Panama");

        //hacemos referencia desde el codigo a nuestro listview del layout
        ListView ListaUI = (ListView) findViewById(R.id.ListaPaises);

        //creamos el adaptador para nuestra lista
       // ListaUI.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres));

        MyAdapter adaptador = new MyAdapter(this, R.layout.filas_lista, nombres);
        ListaUI.setAdapter(adaptador);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    class MyAdapter extends ArrayAdapter
    {
        Context c;
        int MytextView;
        ArrayList<String> l;

        public MyAdapter(Context context, int textViewResourceId, ArrayList<String> list) {
            super(context, textViewResourceId, list);
            // TODO Auto-generated constructor stub
            this.c = context;
            this.MytextView = textViewResourceId;
            this.l = list;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View v;
            if(convertView==null)
            {
                LayoutInflater inflator = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v  = inflator.inflate(MytextView, null, true);
            }else{
                v = convertView;
            }

            //cambiamos los nombres de los paises
            TextView t = (TextView)v.findViewById(R.id.txtContent);
            t.setText(l.get(position));

            //ponemos las banderas dependiendo do que pais es en el que estemos actualmente
            ImageView countryIcon = (ImageView) v.findViewById(R.id.bandera);
            if( l.get(position).equals("Guatemala")){
                countryIcon.setImageResource(R.drawable.guatemala);
            }else if( l.get(position).equals("El Salvador")){
                countryIcon.setImageResource(R.drawable.elsalvador);
            }else if( l.get(position).equals("Honduras")){
                countryIcon.setImageResource(R.drawable.elsalvador);
            }else if( l.get(position).equals("Nicaragua")){
                countryIcon.setImageResource(R.drawable.elsalvador);
            }else if( l.get(position).equals("Costa Rica")){
                countryIcon.setImageResource(R.drawable.elsalvador);
            }else if( l.get(position).equals("Panama")){
                countryIcon.setImageResource(R.drawable.elsalvador);
            }

            //retornamos nuestra nueva vista
            return v;
        }
    }
    
}
