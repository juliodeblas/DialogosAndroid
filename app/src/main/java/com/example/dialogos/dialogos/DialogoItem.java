package com.example.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoItem extends DialogFragment {

    OnDialogoItemSelected listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDialogoItemSelected) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String[] opciones = {"opcion 1", "opcion 2", "opcion 3"};
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Titulo de dialógos item");
        dialogo.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onItemSelected(opciones[which]);
            }
        });

        return dialogo.create();
    }

    public interface OnDialogoItemSelected{
        public void onItemSelected(String s);
    }
}
