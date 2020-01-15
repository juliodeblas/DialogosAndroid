package com.example.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoSiNo extends DialogFragment implements DialogInterface.OnClickListener {

    OnDialogoSiNoListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnDialogoSiNoListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Si/No/Neutral");
        dialogo.setMessage("Elige una de las opciones");
        dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogoSelected("Si");
            }
        });

        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogoSelected("No");
            }
        });
        dialogo.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogoSelected("Neutral");
            }
        });

        return dialogo.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    public interface OnDialogoSiNoListener {
        public void onDialogoSelected(String s);
    }
}
