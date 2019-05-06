package devpro.vn.broadcast_demo.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import devpro.vn.broadcast_demo.Confix.Constans;
import devpro.vn.broadcast_demo.MyApplication;
import devpro.vn.broadcast_demo.Confix.Network;


public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        try {
            int status = Network.getConnectivityStatusString(context);
            if (status == Constans.STATUS_ON ) {
                Intent intentNetwork = new Intent();
                intentNetwork.setAction(Constans.KEY_NETWORK_STATUS);
                MyApplication.getInstance().sendBroadcast(intentNetwork);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
