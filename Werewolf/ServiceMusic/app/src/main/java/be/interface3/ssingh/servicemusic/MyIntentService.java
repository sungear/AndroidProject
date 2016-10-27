package be.interface3.ssingh.servicemusic;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_PLAY = "be.interface3.ssingh.servicemusic.action.PLAY";
    private static final String ACTION_PAUSE = "be.interface3.ssingh.servicemusic.action.PAUSE";
    private static final String ACTION_STOP = "be.interface3.ssingh.servicemusic.action.STOP";

    // TODO: Rename parameters
    private static final String MUSIC_ID1 = "be.interface3.ssingh.servicemusic.music.ID1";

    private static MediaPlayer mediaPlayer;

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionPlay(Context context, String musicId1) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_PLAY);
        intent.putExtra(MUSIC_ID1, musicId1);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionPause(Context context, String musicId1) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_PAUSE);
        intent.putExtra(MUSIC_ID1, musicId1);
        context.startService(intent);
    }

    public static void startActionStop(Context context, String musicId1) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_STOP);
        intent.putExtra(MUSIC_ID1, musicId1);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_PLAY.equals(action)) {
                final String musicId1 = intent.getStringExtra(MUSIC_ID1);
                handleActionStart(musicId1);
            } else if (ACTION_PAUSE.equals(action)) {
                final String musicId1 = intent.getStringExtra(MUSIC_ID1);
                handleActionPause(musicId1);
            } else if (ACTION_STOP.equals(action)) {
                final String musicId1 = intent.getStringExtra(MUSIC_ID1);
                handleActionStop(musicId1);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionStart(String musicId1) {
        // TODO: Handle action Foo
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dancing_faery);
        }

        mediaPlayer.start();
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionPause(String musicId1) {
        // TODO: Handle action Baz
        mediaPlayer.pause();
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void handleActionStop(String musicId1) {
        // TODO: Handle action Baz

        mediaPlayer.release();
        mediaPlayer = null;
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
