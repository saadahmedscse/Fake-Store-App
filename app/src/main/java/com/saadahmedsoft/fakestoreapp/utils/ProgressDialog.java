package com.saadahmedsoft.fakestoreapp.utils;

import android.annotation.SuppressLint;
import android.content.Context;

import com.saadahmedsoft.fakestoreapp.R;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;

public class ProgressDialog {

    @SuppressLint("StaticFieldLeak")
    private static PopupDialog dialog;

    public static void show(Context context) {
        dialog = PopupDialog.getInstance(context);

        dialog.setStyle(Styles.LOTTIE_ANIMATION)
                .setLottieRawRes(R.raw.loading)
                .setLottieRepeatCount(10000)
                .showDialog();
    }

    public static void dismiss() {
        dialog.dismissDialog();
    }
}
