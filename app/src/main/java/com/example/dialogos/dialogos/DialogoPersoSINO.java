package com.example.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos.R;

public class DialogoPersoSINO extends DialogFragment {

    public String nombreRecuperado;
    final static String TAG_ARG1 = "nombre";

    public static DialogoPersoSINO newInstance(String nombre) {
        DialogoPersoSINO dialogo_perso_sino = new DialogoPersoSINO();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG1, nombre);
        dialogo_perso_sino.setArguments(bundle);

        return dialogo_perso_sino;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        nombreRecuperado = this.getArguments().getString(TAG_ARG1);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle(R.string.titulo_perso_dialogo);
        dialogo.setMessage("¿" + nombreRecuperado.toUpperCase() + " estás seguro que quieres continuar?");

        return dialogo.create();
    }
}
