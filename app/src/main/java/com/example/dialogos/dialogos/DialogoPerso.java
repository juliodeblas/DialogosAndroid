package com.example.dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos.R;
import com.example.dialogos.utils.Persona;

public class DialogoPerso extends DialogFragment {

    EditText editNombre, editPassword;
    Button boton_dialogo;
    View view;
    OnDialogoPersoListener listener;

    @Override
    public void onAttach(Context context) {
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_perso, null);
        listener = (OnDialogoPersoListener) context;
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        instancias();
        acciones();

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setView(view);

        return dialogo.create();
    }

    private void acciones() {
        boton_dialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona persona = new Persona(editNombre.getText().toString(), editPassword.getText().toString());
                listener.onPersoSelected(persona);
                dismiss();
            }
        });
    }

    private void instancias() {
        editNombre = view.findViewById(R.id.edit_nombre_dialogo);
        editPassword = view.findViewById(R.id.edit_password_dialogo);
        boton_dialogo = view.findViewById(R.id.boton_login_dialogo);
    }

    public interface OnDialogoPersoListener{
        void onPersoSelected(Persona persona);
    }
}
