package com.shareddependencysample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shareddependencysample.DI.DaggerShareComponent;
import com.shareddependencysample.DI.ShareComponent;
import com.shareddependencysample.DI.SharedModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences preferences;

    ShareComponent mComponent;

    TextView viewText;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewText = (TextView)findViewById(R.id.text_view);
        editText = (EditText)findViewById(R.id.edit_text);
        button = (Button)findViewById(R.id.button);

        mComponent = DaggerShareComponent.builder().sharedModule(new SharedModule(this)).build();
        mComponent.inject(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getText = editText.getText().toString();
                SharedPreferences.Editor editor =  preferences.edit();
                editor.putString("edittext",getText);
                editor.commit();

                viewText.setText(preferences.getString("edittext","default"));
            }
        });



    }
}
