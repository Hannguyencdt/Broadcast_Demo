package devpro.vn.broadcast_demo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import devpro.vn.broadcast_demo.Confix.Constans;
import devpro.vn.broadcast_demo.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = new Intent(Constans.KEY_DATA_MAIN_2);
        Bundle bundle = new Bundle();
        bundle.putString("DATA_2","Hannnguyencdt");
        intent.putExtra("INTENT_DATA_2",bundle);
        sendBroadcast(intent);
    }
}
