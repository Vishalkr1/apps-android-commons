package fr.free.nrw.commons.ui.widget;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * a formatted dialog fragment
 */
public abstract class OverlayDialog extends DialogFragment {

    /**
     * creates a DialogFragment with the correct style and theme
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
    }

    /**
     * allows subclasses to initialize themselves if needed
     * @param view the view being used
     * @param savedInstanceState bundle re-constructed from a previous saved state
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setDialogLayoutToFullScreen();
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * sets the dialog layout to fullscreen
     */
    private void setDialogLayoutToFullScreen() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }
}