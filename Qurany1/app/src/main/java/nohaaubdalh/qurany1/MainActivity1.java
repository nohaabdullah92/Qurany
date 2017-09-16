package nohaaubdalh.qurany1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class
MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        Button button1=(Button)findViewById(R.id.button);
        Button button2=(Button )findViewById(R.id.button2);
       Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);


        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity1.this,MainActivity.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

           @Override
          public void onClick(View v) {

              Intent intent=new Intent(MainActivity1.this,Activitytajwed.class);
               startActivity(intent);

          }
       });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity1.this,QuizeActivity.class);
                startActivity(intent);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity1.this);
                builder.setTitle("إغلاق التطبيق"); // العنوان
                builder.setMessage("هل متأكد من خروج من التطبيق :("); // المحتوى
                builder.setPositiveButton("نعم", // الزر الاول
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // الاوامر التي تحدث بعد الضغط على الزر الأاول
                                finish();

                            }
                        });
                builder.setNegativeButton("لا", // الزر الثاني
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // اوامر الزر الثاني

                            }
                        });
                builder.show();

            }
        });



    }
}
