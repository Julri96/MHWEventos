package com.example.mhweventos.Model;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mhweventos.Interface.mhwAPI;
import com.example.mhweventos.R;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventList extends AppCompatActivity implements EventsAdapter.interfaceClick {

    RecyclerView rv;
    EventsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventsAdapter(this, this);

        llenarLista();

    }

    private void llenarLista() {
        //con el getIntent() recupero el valor que he mandado antes mediante el intent y se lo asigno a expansion
        int expansion = getIntent().getIntExtra("modo", 0);
        //me conecto a la API mediante retrofit y lo combierto directamente con el Gson
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://mhw-db.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        mhwAPI mhwapi = retrofit.create(mhwAPI.class);
        //Log.d("expansion", "expansion" + expansion);
        //Según el valor de expansion(segun que boton se pulse al inicio), hara la llamada GET a la API con distintos filtros
        if (expansion == 0) {
            //hace el getEvents que trae todos los eventos de rango 5 o menores
            Call<List<Event>> call = mhwapi.getEvents();
            call.enqueue(new Callback<List<Event>>() {
                @Override
                public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                    if (!response.isSuccessful()) {
                        //este toast te devuelve el error encaso de que ocurra alguno
                        Toast.makeText(EventList.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //mediante el adapter llena la lista
                    List<Event> eventList = response.body();
                    adapter.setList(eventList);
                    rv.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Event>> call, Throwable t) {
                    //este toast te devuelve el error encaso de que ocurra alguno
                    Toast.makeText(EventList.this, String.valueOf(t.getMessage()), Toast.LENGTH_SHORT).show();
                }
            });
        } else if (expansion == 1) {
            //hace el getEventsI que trae todos los eventos mayores a rango 5
            Call<List<Event>> call = mhwapi.getEventsI();
            call.enqueue(new Callback<List<Event>>() {
                @Override
                public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(EventList.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<Event> eventList = response.body();


                    //Toast.makeText(EventList.this, String.valueOf(eventList.get(1).getEndTimestamp()), Toast.LENGTH_SHORT).show();
                    adapter.setList(eventList);
                    rv.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Event>> call, Throwable t) {
                    Toast.makeText(EventList.this, String.valueOf(t.getMessage()), Toast.LENGTH_SHORT).show();
                }
            });
        } else if (expansion == 2) {
            //hace el getAllEvents que trae todos los eventos sin filtrar
            Call<List<Event>> call = mhwapi.getAllEvents();
            call.enqueue(new Callback<List<Event>>() {
                @Override
                public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(EventList.this, String.valueOf(response.code()), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<Event> eventList = response.body();


                    //Toast.makeText(EventList.this, String.valueOf(eventList.get(1).getEndTimestamp()), Toast.LENGTH_SHORT).show();
                    adapter.setList(eventList);
                    rv.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Event>> call, Throwable t) {
                    Toast.makeText(EventList.this, String.valueOf(t.getMessage()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void click(int position, View v) {
        //esta funcion se utiliza para abrir otra pantalla con la informacion del elemento de la lista clicado
        Event selectedEvent = adapter.lista.get(position);

        Intent DetallesEventoIntetn = new Intent(this, DetallesEvent.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("DetallesEventos", selectedEvent);
        DetallesEventoIntetn.putExtras(bundle);
        startActivity(DetallesEventoIntetn);
    }
}
