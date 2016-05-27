package delta_inducti.delta01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int c=0,k=0,clr[]={-10387494,-7616229,-4320504,-8300051,-45600156};
    Button bb1;
    TextView tt1;
    RelativeLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll1=(RelativeLayout)findViewById(R.id.linear1);
        if(savedInstanceState!=null)
        {
            k=savedInstanceState.getInt("indicator");
            if(k==5)
            {
                c = savedInstanceState.getInt("count");
                ll1.setBackgroundColor(clr[c%5]);
            }
        }
        bb1=(Button)findViewById(R.id.b1);
        tt1=(TextView)findViewById(R.id.t1);
        tt1.setText(Integer.toString(c));
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c++;
                tt1.setText(Integer.toString(c));
                ll1.setBackgroundColor(clr[c%5]);
                k=5;
            }
        });
    }
    public  void onSaveInstanceState(Bundle o){
        super.onSaveInstanceState(o);
        o.putInt("count",c);
        o.putInt("indicator",k);
    }
}
