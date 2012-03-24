package br.eng.moretto.a2turbo;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import br.eng.moretto.a2turbo.view.HallmeterViewer;
import br.eng.moretto.a2turbo.view.VerticalSeekBar;

public class FuelMapper extends Activity {
	
	private static final String PREFS_NAME = "FuelMap";


	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
	     getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
	                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

	    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	        
		setContentView(R.layout.fuel_mapper);   
		
		//TODO persist values in preferences
			
		// Restore preferences
	    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    String mapa = settings.getString("mapa", "empty");
	    
	    if(mapa.equals("empty")){
			 ((VerticalSeekBar) findViewById(R.id.SeekBar01)).setProgress(90);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar02)).setProgress(90);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar03)).setProgress(80);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar04)).setProgress(70);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar05)).setProgress(60);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar06)).setProgress(60);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar07)).setProgress(50);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar08)).setProgress(40);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar09)).setProgress(30);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar10)).setProgress(0);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar11)).setProgress(0);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar12)).setProgress(0);
	    }else{
	    	 String[] split = mapa.split(",");
	    	 ((VerticalSeekBar) findViewById(R.id.SeekBar01)).setProgress(Integer.parseInt(split[0]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar02)).setProgress(Integer.parseInt(split[1]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar03)).setProgress(Integer.parseInt(split[2]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar04)).setProgress(Integer.parseInt(split[3]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar05)).setProgress(Integer.parseInt(split[4]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar06)).setProgress(Integer.parseInt(split[5]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar07)).setProgress(Integer.parseInt(split[6]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar08)).setProgress(Integer.parseInt(split[7]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar09)).setProgress(Integer.parseInt(split[8]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar10)).setProgress(Integer.parseInt(split[9]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar11)).setProgress(Integer.parseInt(split[10]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar12)).setProgress(Integer.parseInt(split[11]));
	    }
		 
		 //((TextView) findViewById(R.id.textView01)).setText(vSeekBar01.getProgress());
		 		 
		 //TODO  fazer os seekbar andar de 10 em 10
		 //vSeekBar.setMax(100);
		 /*
		 Rect bounds = new Rect();
		 
		 vSeekBar.getHitRect(bounds);
	     bounds.right += 50;
	     TouchDelegate touchDelegate = new TouchDelegate(bounds, vSeekBar);
	 
	     if (View.class.isInstance(vSeekBar.getParent())) {	     
	    	 ((View) vSeekBar.getParent()).setTouchDelegate(touchDelegate);
	     }
	     */	     	        
		 //vSeekBar.setTouchDelegate(delegate)	 
	}
	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.fuel_menu, menu);	        
	        return true;
	    }
	    
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	    	
	    	String mapa = "";        	
        	mapa = ""+((VerticalSeekBar) findViewById(R.id.SeekBar01)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar02)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar03)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar04)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar05)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar06)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar07)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar08)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar09)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar10)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar11)).getProgress();
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar12)).getProgress();
        	
        	// We need an Editor object to make preference changes.
            // All objects are from android.context.Context            
        	SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            
	        switch (item.getItemId()) {
	            
	        case R.id.saveMap:
	        	
	            editor.putString("mapa", mapa);
	            // Commit the edits!
	            editor.commit();
	            
	        	break;
	        case R.id.sendMap:
	        	System.out.println("enviando mapa");
	        	System.out.println(mapa);
	        	
	            editor.putString("mapa", mapa);
	            // Commit the edits!
	            editor.commit();	            
	            
	        	MainApplication.get().getSerialService().write(mapa.getBytes());
	        	
	            return true;	            
	        }
	        return false;
	    }
	    
		
	@Override
	protected void onStart() {		
		super.onStart();		
		MainApplication.get().getSerialService().setmHandlerFuel(mHandlerBTFuel);
	}
	
	@Override
	protected void onPause() {	
		super.onPause();
		MainApplication.get().getSerialService().setmHandlerFuel(null);
	}
	
	@Override
	protected void onStop() {	
		super.onStop();
		MainApplication.get().getSerialService().setmHandlerFuel(null);
	}
	
	
	  private final Handler mHandlerBTFuel = new Handler() {
	    	
	        @Override
	        public void handleMessage(Message msg) {     
	        	
	            switch (msg.what) {	            
	               
	            	case MainActivity.LAMBDA:
	            		String lambda = (String) msg.obj;              
	                
	            		HallmeterViewer l = (HallmeterViewer) findViewById(R.id.lambdaViewerFuel); 
	            		l.setValue(Integer.parseInt(lambda));
	                
	            		break;
	            }
	        }
	    }; 
}
