package de.mide.android.halloname;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
public class EreignisHandler implements View.OnClickListener {

    private static final String TAG4LOGGING = "HalloName";
    private final Activity _activity;
    private final EditText _nameEditText;

    public EreignisHandler(Activity activity, EditText nameEditText){
        _activity = activity;
        _nameEditText = nameEditText;
    }

    @Override
    public void onClick(View v) {
        if(_nameEditText == null){
            Log.wtf(TAG4LOGGING, "Edit Text Element nicht gefunden");
            return;
        }

        String name = _nameEditText.getText().toString().trim();
        if(name.isEmpty()){
            Log.wtf(TAG4LOGGING, "Der Nutzer hat keinen Name eingeben.");
            Toast toast = Toast.makeText(
                    _activity,
                    R.string.toast_text_name_eingeben,
                    Toast.LENGTH_LONG);
            toast.show();
            return;
        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Begrüßung");
        dialogBuilder.setMessage("Hallo " + name + "!");
        dialogBuilder.setPositiveButton("Weiter", null);

        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        keyboardeinklappen(_nameEditText);

    }

    private void keyboardeinklappen(View view){
        InputMethodManager imm = (InputMethodManager) _activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null){
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}




