package sg.edu.rp.c346.id22036196.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnDemo1, btnDemo2, btnDemo3, btnExercise3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvExercise3, tvDemo4, tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1=findViewById(R.id.buttonDemo1);
        btnDemo1=findViewById(R.id.buttonDemo2);
        btnDemo3=findViewById(R.id.buttonDemo3);
        btnExercise3=findViewById(R.id.buttonExercise3);
        btnDemo4=findViewById(R.id.buttonDemo4);
        btnDemo5=findViewById(R.id.buttonDemo5);
        tvDemo2=findViewById(R.id.textViewDemo2);
        tvDemo3=findViewById(R.id.buttonDemo3);
        tvExercise3=findViewById(R.id.textViewExercise3);
        tvDemo4=findViewById(R.id.buttonDemo4);
        tvDemo5=findViewById(R.id.textViewDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // create the dialog builder
                //AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);

                // set the dialog details
                //myBuilder.setTitle("Demo 1-Simple Dialog");
                //myBuilder.setMessage("I can develop Android App.");
                //myBuilder.setCancelable(false);
                //myBuilder.setPositiveButton("Close",null);

                //AlertDialog myDialog=myBuilder.create();
                //myDialog.show();

                //2b
                // create the dialog builder
                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);

                // set the dialog details
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box.");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("Dismiss",null);

                AlertDialog myDialog=myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the dialog builder
                AlertDialog.Builder myBuilder= new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the buttons below");
                myBuilder.setCancelable(false);

                //configure the 'positive' button
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected positive");
                    }
                });

                //configure the 'negative' button
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected negative");
                    }
                });

                //configure the 'neutral' button
                myBuilder.setNeutralButton("CANCEL",null);
                AlertDialog myDialog=myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //inflate the input.xml layout file
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog=inflater.inflate(R.layout.input, null);

                //obtain the UI component in the input.xml layout
                //it needs to be defined as "final", so that ut can be used in the onClick() method later
                final EditText etInput=viewDialog.findViewById(R.id.editTextNum1);

                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);
                //set the view of the dialog
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the text entered by the user
                        String message=etInput.getText().toString();
                        //set the text to the textview
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog=myBuilder.create();
                myDialog.show();
            }
        });

        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inflate the input.xml layout file
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog=inflater.inflate(R.layout.exercise3, null);

                //obtain the UI component in the input.xml layout
                //it needs to be defined as "final", so that it can be used in the onClick() method later
                final EditText etNum1=viewDialog.findViewById(R.id.editTextNum1);
                final EditText etNum2=viewDialog.findViewById(R.id.editTextNum2);

                AlertDialog.Builder myBuilder=new AlertDialog.Builder(MainActivity.this);
                //set the view of the dialog
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //extract the text entered by the user
                        int num1 = Integer.parseInt(etNum1.getText().toString());
                        int num2=Integer.parseInt(etNum2.getText().toString());
                        int total=num1+num2;
                        //set the text to the textview
                        tvDemo3.setText("The sum is" +Integer.toString(total));
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog=myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: "+dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                };
                //create the Date Picker Dialog
                //DatePickerDialog myDateDialog=new DatePickerDialog(MainActivity.this,myDateListener, 2014, 11, 31);
                //myDateDialog.show();

                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);

                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: "+hourOfDay+":"+minute);
                    }
                };
                //create the Time Picker Dialog
                //TimePickerDialog myTimeDialog=new TimePickerDialog(MainActivity.this, myTimeListener, 20, 00, true);
                Calendar now = Calendar.getInstance();
                // Current Hour
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
                // Current Minute
                int minute = now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hourOfDay, minute, false);

                myTimeDialog.show();
            }
        });

    }
}