package com.perepelkiny.finger_love;

import android.app.AlertDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

public class InfoDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                      .setTitle("О приложении")
                      .setMessage("Для закрытия окна нажмите ОК")
                      .setPositiveButton("Ок", null)
                      .create();
    }

}
