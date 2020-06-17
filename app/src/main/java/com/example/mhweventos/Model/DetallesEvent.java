package com.example.mhweventos.Model;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mhweventos.R;



public class DetallesEvent extends AppCompatActivity implements View.OnClickListener {

    TextView txtNombre, txtRango, txtLocation, txtDescription, txtSuccess, txtRequirements, txtLimite;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);
        txtNombre = findViewById(R.id.txtNombre);
        txtRango = findViewById(R.id.txtRango);
        txtLocation = findViewById(R.id.txtLocation);
        txtDescription = findViewById(R.id.txtDescription);
        txtSuccess = findViewById(R.id.txtSuccess);
        txtRequirements = findViewById(R.id.txtRequirements);
        txtLimite = findViewById(R.id.txtLimite);

        Bundle BundleRecibido = getIntent().getExtras();
        Event selectedEvent = (Event) BundleRecibido.getSerializable("DetallesEventos");
        txtRango.setText(String.valueOf(selectedEvent.getQuestRank()));
        txtNombre.setText(selectedEvent.getName());
        txtLocation.setText(selectedEvent.getLocation().getName());
        txtDescription.setText(selectedEvent.getDescription());
        txtSuccess.setText(selectedEvent.getSuccessConditions());
        txtRequirements.setText(selectedEvent.getRequirements());
        txtLimite.setText(String.valueOf(selectedEvent.getEndTimestamp()));

    }

    @Override
    public void onClick(View v) {

    }
}
