package br.eng.moretto.a2turbo;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;

public class MainApplication extends Application {
	
	private BluetoothAdapter bluetoothAdapter = null;
	private BluetoothSerialService serialService = null;
	private static MainApplication me = null;
	
	
	 @Override
	  public void onCreate() {
	    super.onCreate();
		    
	    if(me == null)
	    	me = this;
	  }
	 
	 
	public static MainApplication get(){
		return me;		
	}
	
	public BluetoothAdapter getBluetoothAdapter() {
		return bluetoothAdapter;
	}


	public void setBluetoothAdapter(BluetoothAdapter bluetoothAdapter) {
		this.bluetoothAdapter = bluetoothAdapter;
	}


	public BluetoothSerialService getSerialService() {
		return serialService;
	}


	public void setSerialService(BluetoothSerialService serialService) {
		this.serialService = serialService;
	}
	
}
