package com.example.mhweventos.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mhweventos.R;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {
    List<Event> lista;
    View.OnClickListener listener;
    interfaceClick cl;
    Context context;

    public EventsAdapter(interfaceClick interfaceClick, Context context) {
        cl = interfaceClick;
        this.context = context;
    }

    @NonNull
    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsAdapter.ViewHolder holder, final int position) {
        Event event = lista.get(position);

        holder.txtRango.setText(String.valueOf(event.getQuestRank()));
        holder.txtNombre.setText(String.valueOf(event.getName()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cl.click(position, v);
            }
        });
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public void setList(List<Event> eventos) {
        Date date = new Date(System.currentTimeMillis());
        //La API no esta actualizada
        //this.lista = eventos.stream().filter(event -> event.getStartTimestamp().before(date)
        // && event.getEndTimestamp().after(date)).collect(Collectors.toList());
        this.lista = eventos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRango, txtNombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtRango = itemView.findViewById(R.id.txtRango);
            txtNombre = itemView.findViewById(R.id.txtNombre);
        }
    }

    public interface interfaceClick {
        void click(int position, View v);
    }
}
