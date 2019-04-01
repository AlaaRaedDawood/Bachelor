package com.example.start;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.io.InputStream;
import java.io.OutputStream;

public class PrintMarkers extends AppCompatActivity {
    private BluetoothAdapter bluetoothAdapter ;
    private BluetoothDevice bluetoothDevice ;
    private BluetoothSocket bluetoothSocket ;

    private OutputStream outputStream ;
    private InputStream inputStream ;
    byte[] readbuffer ;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_markers);

    }

}
