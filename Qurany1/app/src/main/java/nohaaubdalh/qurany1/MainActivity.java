package nohaaubdalh.qurany1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class
MainActivity extends AppCompatActivity {

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);


        
        File database = getApplicationContext().getDatabasePath(db.DBNAME);
        if (false == database.exists()) {
            db.getReadableDatabase();
            if (copyDatabase(this)) {
                //Toast.makeText(MainActivity.this, "تم نسخ قاعدة البيانات بنجاح", Toast.LENGTH_SHORT).show();
            } else {
                // Toast.makeText(MainActivity.this, "خطأ لم يتم نسخ قاعدة البيانات", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        ArrayList listTitles = db.get_All_Titles();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listTitles);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = String.valueOf(parent.getItemAtPosition(position));
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });



    }


    private boolean copyDatabase(MainActivity context) {

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
