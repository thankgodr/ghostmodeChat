package com.michrosys.richard.ghostmodechatapp.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.util.Log;

/**
 * Created by ACECR on 4/5/2017.
 */

public class BluetoothService {
    private static final BluetoothService ourInstance = new BluetoothService();

    public static BluetoothService getInstance() {
        return ourInstance;
    }

    private BluetoothService() {
    }
    private static String slice_range(String s, int startIndex, int endIndex) {
        if (startIndex < 0) startIndex = s.length() + startIndex;
        if (endIndex < 0) endIndex = s.length() + endIndex;
        return s.substring(startIndex, endIndex);
    }


    public static boolean setBluetooth(boolean enable) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = bluetoothAdapter.isEnabled();
        if (enable && !isEnabled) {
            Log.i("burn","blueetooth On succes");
            bluetoothAdapter.enable();
            bluetoothAdapter.setName("TECNO-W5Lite");
            Log.i("burn",bluetoothAdapter.getName());
            return true;
        }
        else if(!enable && isEnabled) {
            Log.i("burn","blueetooth off succes");
            Log.i("burn",bluetoothAdapter.getName());
            return bluetoothAdapter.disable();
        }
        // No need to change bluetooth state
        else if(enable && isEnabled){
            bluetoothAdapter.setName("TECNO-W5Lite");
            Log.i("burn",bluetoothAdapter.getName());
        }
        return true;
    }
}
