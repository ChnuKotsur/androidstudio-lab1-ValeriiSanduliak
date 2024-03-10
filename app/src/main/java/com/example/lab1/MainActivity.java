package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import android.content.Intent;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {


    ImageView imageViewFlag ;
    ImageView imageViewBack;
    Resources resources;
    TextView topText;
    TextView AnthemText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resource = getResources();

        String[] items = getResources().getStringArray(R.array.countries);
        Spinner countries = (Spinner) findViewById(R.id.spinnerCountry);
        ArrayAdapter<String> adapter = new CustomSpinnerAdapter(this, R.layout.spinner_item_layout_closed, Arrays.asList(items));
        countries.setAdapter(adapter);

    }

    public void onClickSwitchCountry(View view){
        Spinner countries = (Spinner) findViewById(R.id.spinnerCountry);
        imageViewFlag = findViewById(R.id.imageViewFlag);
        imageViewBack = findViewById(R.id.imageViewBackround);
        resources = getResources();
        topText = (TextView) findViewById(R.id.textTop);
        AnthemText = (TextView) findViewById(R.id.textViewAnthem);

        String country = String.valueOf(countries.getSelectedItem());
        topText.setText(country);

        switch (country) {
            case "Georgia":
                imageViewFlag.setImageResource(R.drawable.georgiaflag);
                imageViewBack.setImageResource(R.drawable.museumfortress);
                AnthemText.setText(resources.getString(R.string.anthemGeorgia));

                break;
            case "Saint Vincent":
                imageViewFlag.setImageResource(R.drawable.saintvincentflag);
                imageViewBack.setImageResource(R.drawable.mandarin);
                AnthemText.setText(resources.getString(R.string.anthemSaint));
                break;
            case "Djibouti" :
                imageViewFlag.setImageResource(R.drawable.djiboutiflag);
                imageViewBack.setImageResource(R.drawable.peopleplacedji);
                AnthemText.setText(resources.getString(R.string.anthemDjibouti));
                break;
            case "Jordan" :
                imageViewFlag.setImageResource(R.drawable.jordanflag);
                imageViewBack.setImageResource(R.drawable.hoteljordan);
                AnthemText.setText(resources.getString(R.string.anthemJordan));
                break;
            case "Central African Republic" :
                imageViewFlag.setImageResource(R.drawable.africaflag);
                imageViewBack.setImageResource(R.drawable.afback);
                AnthemText.setText(resources.getString(R.string.anthemAfrican));
                break;
            default:
                break;
        }

    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent (this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }

    public void onSendMessageOther(View view){
        EditText messageView = (EditText)findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}