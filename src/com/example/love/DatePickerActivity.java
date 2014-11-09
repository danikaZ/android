package com.example.love;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.net.ParseException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;

public class DatePickerActivity extends ActionBarActivity {
    private DatePicker datePicker;
    private static final String ACTIVITY_TAG="LogDemo";

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_date);

        datePicker = (DatePicker) findViewById(R.id.dpPicker);
        

        datePicker.init(2013, 8, 20, new OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year,
                    int monthOfYear, int dayOfMonth) {
                // 获取一个日历对象，并初始化为当前选中的时间
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat(
                		"dd/MMM/yyyy");
//                Toast.makeText(DatePickerActivity.this,
//                        format.format(calendar.getTime()), Toast.LENGTH_SHORT)
//                        .show();
                String Expire_date_String = format.format(calendar.getTime());
               
            }
        });
        

		

        

    }
    
    
    public int daysToWait(View view){
    	datePicker = (DatePicker) findViewById(R.id.dpPicker);
    	
	    Calendar thatDay = Calendar.getInstance();
	    thatDay.set(Calendar.DAY_OF_MONTH,datePicker.getDayOfMonth());
	    thatDay.set(Calendar.MONTH,datePicker.getMonth()); // 0-11 so 1 less
	    thatDay.set(Calendar.YEAR, datePicker.getYear());

	    Calendar today = Calendar.getInstance();
	    Log.w(DatePickerActivity.ACTIVITY_TAG, datePicker.getMonth()+"");
	    
	    long diff =   thatDay.getTimeInMillis() - today.getTimeInMillis();
	    int days_wait = (int) (diff / (24 * 60 * 60 * 1000));
	    
	    Log.w(DatePickerActivity.ACTIVITY_TAG, days_wait+"");
	    
	    TextView textView = (TextView)findViewById(R.id.days_left);
	    textView.setText("Days left:"+days_wait);
		
        return (days_wait);
    }
}
