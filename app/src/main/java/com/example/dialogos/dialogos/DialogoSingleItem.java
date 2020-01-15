package com.example.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoSingleItem extends DialogFragment {

    OnDialogoSingleItem listener;
    int posicion;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDialogoSingleItem) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] opciones = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "opcion 5"};

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Título del diálogo single item");

        dialogo.setSingleChoiceItems(opciones, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                posicion = which;

            }
        });

        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onSingleItemSelected(opciones[posicion]);
            }
        });

        return dialogo.create();
    }

    public interface OnDialogoSingleItem{
        public void onSingleItemSelected(String s);
    }
}
