package nohaaubdalh.qurany1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ShowActivity extends AppCompatActivity {

    Button start,stop,pasue;
    MediaPlayer mediaPlayer;
    String file_name;
    DatabaseHelper db= new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView full_text = (TextView) findViewById(R.id.textView);
        //full_text.setText(Html.fromHtml());

        Typeface face = Typeface.createFromAsset(getAssets(),"me_quran.ttf");
        full_text.setTypeface(face);
        full_text.setTextSize(35);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String ful_story = db.get_full_story(title);

        full_text.setText(ful_story);
        this.setTitle(title);

        start= (Button) findViewById(R.id.bt1);
        stop= (Button) findViewById(R.id.bt3);
       // pasue= (Button) findViewById(R.id.bt3);

        file_name=db.get_mp3(title);
        Log.i("Resource ID Check",""+getResources().getIdentifier(file_name,"raw",getPackageName()));
        mediaPlayer= MediaPlayer.create(getApplicationContext(),getResources().getIdentifier(file_name,"raw",getPackageName()));

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        });


      //  pasue.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
        //        mediaPlayer.pause();
         //   }
       // });
    }

    private boolean CopyData(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(db.DBNAME);
            String outFileName = db.DBLOCATION + db.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
