package deltaproject.delta01advanced;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button bb1,bb2;
    TextView tt1;
    RelativeLayout rl1;
    int c=0,clr[]={-10387494,-7616229,-4320504,-8300051,-45600156};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final SharedPreferences pref=getSharedPreferences("save",MODE_PRIVATE);
        c=pref.getInt("count",0);
        bb1=(Button) findViewById(R.id.b1);
        bb2=(Button)findViewById(R.id.b2);
        tt1=(TextView)findViewById(R.id.t1);
        rl1=(RelativeLayout)findViewById(R.id.relative1);
        tt1.setText(Integer.toString(c));
        if(c!=0)
        rl1.setBackgroundColor(clr[c%5]);
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c++;
                tt1.setText(Integer.toString(c));
                rl1.setBackgroundColor(clr[c%5]);
                SharedPreferences.Editor savevalue=getSharedPreferences("save",MODE_PRIVATE).edit();
                savevalue.putInt("count",c);
                savevalue.commit();
            }
        });
        bb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=0;
                tt1.setText(Integer.toString(c));
                rl1.setBackgroundColor(c);
                SharedPreferences.Editor savevalue=pref.edit();
                savevalue.putInt("count",c);
                savevalue.commit();
            }
        });
    }
}
