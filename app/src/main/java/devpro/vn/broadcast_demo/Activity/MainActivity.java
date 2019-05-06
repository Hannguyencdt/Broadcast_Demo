package devpro.vn.broadcast_demo.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import devpro.vn.broadcast_demo.Confix.Constans;
import devpro.vn.broadcast_demo.R;

public class MainActivity extends AppCompatActivity {
    TextView tvStatus;
    Button button;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                tvStatus.setText(" Đang sạc pin");
            }
            // nếu sự kiện nhận đưọc là rút sạc
            if (intent.getAction().endsWith(Intent.ACTION_POWER_DISCONNECTED)) {
                tvStatus.setText(" Đã rút sạc");
            }
            if (intent.getAction().equals(String.valueOf(Constans.KEY_NETWORK_STATUS))) {
                Toast.makeText(context, "Có kết nối mạng", Toast.LENGTH_SHORT).show();
            }
            if (intent.getAction().equals(String.valueOf(Constans.KEY_DATA_MAIN_2))) {
               Bundle bundle = intent.getBundleExtra("INTENT_DATA_2");
               String data = bundle.getString("DATA_2");
               tvStatus.setText(data);
            }

        }
    };
    IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvStatus = findViewById(R.id.tvStatus);
        button = findViewById(R.id.button);
        filter = new IntentFilter();
        filter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        filter.addAction(String.valueOf(Constans.KEY_NETWORK_STATUS));
        filter.addAction(String.valueOf(Constans.KEY_DATA_MAIN_2));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new  Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });


    }

        @Override
        public void onDestroy () {
            // hủy đăng ký
            super.onDestroy();

        }

        @Override
        public void onResume () {
            registerReceiver(receiver, filter);
            // hủy đăng ký
            super.onResume();

        }
    }



