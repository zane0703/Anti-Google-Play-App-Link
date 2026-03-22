package org.zane.antigoogleplaylink;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.materialswitch.MaterialSwitch;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences preferences = getSharedPreferences("antigoogleplaylink", Context.MODE_PRIVATE);
        editor = preferences.edit();
        MaterialSwitch autoCloseMode = findViewById(R.id.autoCloseMode);
        autoCloseMode.setChecked(preferences.getBoolean("AutoCloseMode", false));
        autoCloseMode.setOnCheckedChangeListener(this::onAutoCloseMode);
    }
    private void onAutoCloseMode(CompoundButton buttonView, boolean isChecked) {
        editor.putBoolean("AutoCloseMode", isChecked);
        editor.apply();
    }
}