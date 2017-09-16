package nohaaubdalh.qurany1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Showajwed extends AppCompatActivity {
    DatabaseHelper1 db = new DatabaseHelper1(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showajwed);


        TextView full_text = (TextView) findViewById(R.id.te1);
        //full_text.setText(Html.fromHtml());

        // ImageView imageView=(ImageView)findViewById(R.id.imageView2) ;
        // imageView.setImageDrawable(Drawable.createFromPath("back.jpg"));
        Intent intent = getIntent();



        String title = intent.getStringExtra("title");
        String ful_story = db.get_full_story(title);
        full_text.setTextSize(16);

        full_text.setText(ful_story);
        this.setTitle(title);

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
