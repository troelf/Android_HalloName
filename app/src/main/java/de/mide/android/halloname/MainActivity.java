package de.mide.android.halloname;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


/**
 * App demonstriert Verwendung von Dialogen, Toasts und Log-Nachrichten.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG4LOGGING = "HalloName";

    /** UI-Element, in das der Nutzer einen (Vor-)Namen eingeben soll. */
    protected EditText _nameEditText = null;


    /**
     * Lifecycle-Methode: Lädt UI, lädt Referenz auf UI-Element in
     * Member-Variable und setzt Event-Handler-Methode für den Button.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _nameEditText = findViewById(R.id.nameEditText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new EreignisHandler(this, _nameEditText));

        Log.v(TAG4LOGGING, "Methode onCreate() wurde erfolgreich beendet.");
    }
}