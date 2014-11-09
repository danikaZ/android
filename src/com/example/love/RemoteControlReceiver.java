package com.example.love;

import com.example.love.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.KeyEvent;

public class RemoteControlReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            if (KeyEvent.KEYCODE_MEDIA_PLAY == event.getKeyCode()) {
                // Handle key press.
            	MediaPlayer backgroundPlayer = MediaPlayer.create(context, R.raw.song);
            	backgroundPlayer.setLooping(true);
            	backgroundPlayer.start();
            	
            	
            }
        }
	}
	
	
}
