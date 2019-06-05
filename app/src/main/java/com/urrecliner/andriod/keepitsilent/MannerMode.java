package com.urrecliner.andriod.keepitsilent;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.Toast;

import static android.content.Context.VIBRATOR_SERVICE;
import static com.urrecliner.andriod.keepitsilent.Vars.beepManner;
import static com.urrecliner.andriod.keepitsilent.Vars.mainContext;
import static com.urrecliner.andriod.keepitsilent.Vars.utils;

class MannerMode {

    static private String logID = "MannerMode";
    private static MediaPlayer mpStart, mpFinish;

    static void turnOn(Context context, String subject, boolean vibrate) {
        final String text = subject + ", Go into Silent";
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        assert am != null;
        beepStart();
        vibratePhone(context);
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
        if (vibrate)
            am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        else
            am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    }

    static void turnOff(Context context, String subject) {
        final  String text = subject + ", Return to normal";
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        assert am != null;
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        Toast.makeText(context, text,Toast.LENGTH_LONG).show();
        vibratePhone(context);
        beepFinish();
    }

    private static void vibratePhone(Context context) {
        long[] pattern = {0, 100, 1000, 300, 200, 100, 500, 200, 100};
        Vibrator v = (Vibrator) context.getSystemService(VIBRATOR_SERVICE);
        assert v != null;
        v.vibrate(VibrationEffect.createWaveform(pattern, -1));
    }

    private static void beepStart() {

//        utils.log(logID, "Start");
//        mSettings = PreferenceManager.getDefaultSharedPreferences(mainContext);
//        beepManner = mSettings.getBoolean("beepManner", true);
        if (beepManner) {
//            utils.log(logID, "Start ON");
            if (mpStart == null) {
                utils.log(logID, "creating beep");
                mpStart = MediaPlayer.create(mainContext, R.raw.manner_starting);
                mpStart.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });
            }
            else
                mpStart.start();
        }
    }

    private static void beepFinish() {

//        utils.log(logID, "Finish");
//        mSettings = PreferenceManager.getDefaultSharedPreferences(mainContext);
//        beepManner = mSettings.getBoolean("beepManner", true);
        if (beepManner) {
//            utils.log(logID, "Finish ON");
            if (mpFinish == null) {
                utils.log(logID, "creating beep");
                mpFinish = MediaPlayer.create(mainContext, R.raw.manner_return2normal);
                mpFinish.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mediaPlayer.start();
                    }
                });
            }
            else
                mpFinish.start();
        }
    }

}
