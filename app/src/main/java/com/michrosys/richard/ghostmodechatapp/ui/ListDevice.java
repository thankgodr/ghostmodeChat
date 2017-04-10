package com.michrosys.richard.ghostmodechatapp.ui;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michrosys.richard.ghostmodechatapp.R;
import com.michrosys.richard.ghostmodechatapp.bluetooth.BluetoothService;

import java.util.List;

import io.palaima.smoothbluetooth.Device;
import io.palaima.smoothbluetooth.SmoothBluetooth;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListDevice extends Fragment {
    private SmoothBluetooth mSmoothBluetooth;

    public ListDevice() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        mSmoothBluetooth = new SmoothBluetooth(getContext());
        mSmoothBluetooth.setListener(mListener);
        mSmoothBluetooth.tryConnection();

        return inflater.inflate(R.layout.fragment_list_device, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BluetoothService.setBluetooth(false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSmoothBluetooth.doDiscovery();
    }

    private SmoothBluetooth.Listener mListener = new SmoothBluetooth.Listener() {
        @Override
        public void onBluetoothNotSupported() {
            //device does not support bluetooth
        }

        @Override
        public void onBluetoothNotEnabled() {
            //bluetooth is disabled, probably call Intent request to enable bluetooth
        }

        @Override
        public void onConnecting(Device device) {
            //called when connecting to particular device
        }

        @Override
        public void onConnected(Device device) {
            //called when connected to particular device
        }

        @Override
        public void onDisconnected() {
            //called when disconnected from device
        }

        @Override
        public void onConnectionFailed(Device device) {
            //called when connection failed to particular device
        }

        @Override
        public void onDiscoveryStarted() {
            //called when discovery is started
            Log.i("burn","started");
        }

        @Override
        public void onDiscoveryFinished() {
            //called when discovery is finished
            Log.i("burn","finished");
        }

        @Override
        public void onNoDevicesFound() {
            //called when no devices found
        }

        @Override
        public void onDevicesFound(List<Device> deviceList, SmoothBluetooth.ConnectionCallback connectionCallback) {
            for(int i = 0; i < deviceList.size(); i++){
                Log.i("burn",deviceList.get(i).getName());
            }
        }

        @Override
        public void onDataReceived(int data) {
            //receives all bytes
        }
    };
}
