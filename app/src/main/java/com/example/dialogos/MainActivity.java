package com.example.dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dialogos.dialogos.DialogoFecha;
import com.example.dialogos.dialogos.DialogoHora;
import com.example.dialogos.dialogos.DialogoInformacion;
import com.example.dialogos.dialogos.DialogoItem;
import com.example.dialogos.dialogos.DialogoMultipleItem;
import com.example.dialogos.dialogos.DialogoPerso;
import com.example.dialogos.dialogos.DialogoPersoSINO;
import com.example.dialogos.dialogos.DialogoSiNo;
import com.example.dialogos.dialogos.DialogoSingleItem;
import com.example.dialogos.utils.Persona;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogoSiNo.OnDialogoSiNoListener,
        DialogoItem.OnDialogoItemSelected, DialogoSingleItem.OnDialogoSingleItem, DialogoMultipleItem.OnDialogoMultiListener, DialogoPerso.OnDialogoPersoListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button boton_dialogo, boton_si_no, boton_si_no_perso, boton_item, boton_single_item, boton_multiple_item, boton_dialogo_perso, boton_fecha, boton_hora;
    TextView texto_si_no, texto_si_no_perso, texto_item, texto_single_item, texto_multiple_item, texto_dialogo_perso, texto_dialogo_fecha, texto_dialogo_hora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        boton_dialogo.setOnClickListener(this);
        boton_si_no.setOnClickListener(this);
        boton_si_no_perso.setOnClickListener(this);
        boton_single_item.setOnClickListener(this);
        boton_multiple_item.setOnClickListener(this);
        boton_dialogo_perso.setOnClickListener(this);
        boton_fecha.setOnClickListener(this);
        boton_hora.setOnClickListener(this);
    }

    private void instancias() {
        boton_dialogo = findViewById(R.id.dialogo_boton);
        boton_si_no = findViewById(R.id.si_no_boton);
        texto_si_no = findViewById(R.id.texto_si_no);
        boton_si_no_perso = findViewById(R.id.si_no_perso_boton);
        texto_si_no_perso = findViewById(R.id.texto_si_no_perso_respuesta);
        boton_item = findViewById(R.id.respuesta_item_boton);
        texto_item = findViewById(R.id.texto_respuesta_item);
        boton_single_item = findViewById(R.id.dialogo_singleItem_boton);
        boton_multiple_item = findViewById(R.id.dialogo_multipleItem_boton);
        texto_single_item = findViewById(R.id.texto_dialogo_singleItem);
        texto_multiple_item = findViewById(R.id.texto_dialogo_multipleItem);
        texto_dialogo_perso = findViewById(R.id.texto_dialogo_perso);
        boton_dialogo_perso = findViewById(R.id.dialogo_perso_boton);
        boton_fecha = findViewById(R.id.dialogo_fecha_boton);
        boton_hora = findViewById(R.id.dialogo_hora_boton);
        texto_dialogo_fecha = findViewById(R.id.texto_dialogo_fecha);
        texto_dialogo_hora = findViewById(R.id.texto_dialogo_hora);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogo_boton:
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(), "ejemplo");

                break;
            case R.id.si_no_boton:
                DialogoSiNo dialogoSiNo = new DialogoSiNo();
                dialogoSiNo.show(getSupportFragmentManager(), "ejemplo1");

                break;
            case R.id.si_no_perso_boton:
                DialogoPersoSINO dialogo_perso_sino = DialogoPersoSINO.newInstance("Julio");
                dialogo_perso_sino.show(getSupportFragmentManager(), "ejemplo2");

                break;
            case R.id.respuesta_item_boton:
                DialogoItem dialogoItem = new DialogoItem();
                dialogoItem.show(getSupportFragmentManager(), "items");

                break;
            case R.id.dialogo_singleItem_boton:
                DialogoSingleItem dialogoSingleItem = new DialogoSingleItem();
                dialogoSingleItem.show(getSupportFragmentManager(), "single");

                break;
            case R.id.dialogo_multipleItem_boton:
                DialogoMultipleItem dialogoMultipleItem = new DialogoMultipleItem();
                dialogoMultipleItem.show(getSupportFragmentManager(), "multi");

                break;
            case R.id.dialogo_perso_boton:
                DialogoPerso dialogoPerso = new DialogoPerso();
                dialogoPerso.show(getSupportFragmentManager(), "perso");

                break;
            case R.id.dialogo_fecha_boton:
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getSupportFragmentManager(), "fecha");

                break;
            case R.id.dialogo_hora_boton:
                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(getSupportFragmentManager(), "hora");

                break;
        }
    }


    @Override
    public void onDialogoSelected(String s) {
        //Toast.makeText(getApplicationContext(), "La opcion seleccionada es: "+s, Toast.LENGTH_SHORT).show();
        texto_si_no.setText(s);
    }

    @Override
    public void onItemSelected(String s) {

    }

    @Override
    public void onSingleItemSelected(String s) {
        texto_single_item.setText(s);
    }

    @Override
    public void onMultiSelected(int numero) {
        texto_multiple_item.setText(String.valueOf(numero));
    }

    @Override
    public void onPersoSelected(Persona persona) {
        texto_dialogo_perso.setText(persona.toString());
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        String fecha = String.format("%S/%S/%S", year, month+1, dayOfMonth);
        Toast.makeText(getApplicationContext(), fecha, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        String hora = String.format("%S:%S", hourOfDay, minute);
        Toast.makeText(getApplicationContext(), hora, Toast.LENGTH_SHORT).show();
    }
}
