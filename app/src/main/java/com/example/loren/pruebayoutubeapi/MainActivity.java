package com.example.loren.pruebayoutubeapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {
    String claveYoutube="AIzaSyCJmItiSohr4brT1ZqyumP_7Fo32k74d60";
    YouTubePlayerView y1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        y1=(YouTubePlayerView)findViewById(R.id.youtube_view);

        y1.initialize(claveYoutube, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {
        if(!fueRestaurado){
            youTubePlayer.cueVideo("azxDhcKYku4");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else{
            String error="Error al iniciar Youtube"+youTubeInitializationResult.toString();

            Toast.makeText(getApplication(),error,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode==1){
            getYoutubePlayerProvider().initialize(claveYoutube,this);
       }
    }

    public YouTubePlayer.Provider getYoutubePlayerProvider(){
        return y1;
    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
}
