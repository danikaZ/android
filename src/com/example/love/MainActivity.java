package com.example.love;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	MediaPlayer backgroundPlayer ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
				
		
		
    	backgroundPlayer = MediaPlayer.create(this, R.raw.song);
    	backgroundPlayer.setLooping(true);
    	backgroundPlayer.start();

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		else if(id == R.id.action_album) {
			//show album;
			openAlbum();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void openAlbum() {
		// TODO Auto-generated method stub
	
	}

	/** Called when the user clicks the Send button */
	//View -> View that was clicked
	public void sendMessage(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	/** Called when the user clicks the date button */
	//View -> View that was clicked
	public void showDate(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, DatePickerActivity.class);
		startActivity(intent);
	}
	
	@Override
	protected void onPause() {
		backgroundPlayer.stop();
		super.onPause();
	};
	

	
}
