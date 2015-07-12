package com.example.android.alarmclock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void Continue(View view){
        //Getting Repeat Settings
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        RadioButton radioButton=(RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        String  repeatSettings=(String)radioButton.getText();
        //Getting the choosen Alarm Time
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        int hour=timePicker.getCurrentHour();
        int mins=timePicker.getCurrentMinute();
        //Toast.makeText(getApplicationContext(),repeatSett , Toast.LENGTH_LONG).show();
        switch(repeatSettings)
        {
            case "On":{
                Intent intent=new Intent(this,MainActivity2.class);
                intent.putExtra("Hour",hour);
                intent.putExtra("Minutes",mins);
                startActivity(intent);
                }
            case "Off":{
                Intent intent=new Intent(this,RegistrationIntentService.class);
                startService(intent);
                }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
