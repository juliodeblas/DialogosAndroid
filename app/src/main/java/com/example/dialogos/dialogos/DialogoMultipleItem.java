package com.example.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoMultipleItem extends DialogFragment {

    int contador = 0;
    OnDialogoMultiListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
        dialogo.setTitle("Título del diálogo multiple item");

        dialogo.setMultiChoiceItems(opciones, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    contador++;
                }else{
                    contador--;
                }
            }
        });

        dialogo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onMultiSelected(contador);
            }
        });

        return dialogo.create();
    }

    public interface OnDialogoMultiListener{
        void onMultiSelected(int numero);
    }
}
