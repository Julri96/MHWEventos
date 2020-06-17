package com.example.mhweventos.Interface;

import com.example.mhweventos.Model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface mhwAPI {
    /*este get me coge los eventos con questRank menor a 5*/
    @GET("events?q={%22questRank%22:{%22$lt%22:5}}")
    Call<List<Event>> getEvents();

    /*este get me coge los eventos con questRank mayor a 5*/
    @GET("events?q={%22questRank%22:{%22$gt%22:5}}")
    Call<List<Event>> getEventsI();

    /*este get me coge todos los eventos*/
    @GET("events")
    Call<List<Event>> getAllEvents();

}
//con estos dos se filtraria entre el juego base y la expansion
/*https://mhw-db.com/events?q={%22expansion%22:%22base%22}
https://mhw-db.com/events?q={%22expansion%22:%22iceborne%22}*/