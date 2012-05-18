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
import android.widget.Toast;
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
		
		//persist values in preferences
			
		// Restore preferences
	    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
	    String mapa = settings.getString("mapa1", "empty");
	    String mapa2 = settings.getString("mapa2", "empty");
	    
	    if(mapa.equals("empty")){
			 ((VerticalSeekBar) findViewById(R.id.SeekBar01)).setProgress(80);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar02)).setProgress(80);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar03)).setProgress(70);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar04)).setProgress(60);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar05)).setProgress(60);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar06)).setProgress(50);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar07)).setProgress(30);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar08)).setProgress(20);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar09)).setProgress(10);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar10)).setProgress(0);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar11)).setProgress(0);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar12)).setProgress(0);
			 
			 ((VerticalSeekBar) findViewById(R.id.SeekBar201)).setProgress(50);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar202)).setProgress(50);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar203)).setProgress(40);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar204)).setProgress(40);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar205)).setProgress(30);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar206)).setProgress(20);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar207)).setProgress(10);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar208)).setProgress(0);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar209)).setProgress(0);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar210)).setProgress(0);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar211)).setProgress(0);
			 ((VerticalSeekBar) findViewById(R.id.SeekBar212)).setProgress(0);
			 
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
			 
		   	 String[] split2 = mapa2.split(",");
	    	 ((VerticalSeekBar) findViewById(R.id.SeekBar201)).setProgress(Integer.parseInt(split2[0]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar202)).setProgress(Integer.parseInt(split2[1]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar203)).setProgress(Integer.parseInt(split2[2]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar204)).setProgress(Integer.parseInt(split2[3]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar205)).setProgress(Integer.parseInt(split2[4]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar206)).setProgress(Integer.parseInt(split2[5]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar207)).setProgress(Integer.parseInt(split2[6]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar208)).setProgress(Integer.parseInt(split2[7]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar209)).setProgress(Integer.parseInt(split2[8]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar210)).setProgress(Integer.parseInt(split2[9]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar211)).setProgress(Integer.parseInt(split2[10]));
			 ((VerticalSeekBar) findViewById(R.id.SeekBar212)).setProgress(Integer.parseInt(split2[11]));
	    }
	 
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
        	mapa = mapa + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar12)).getProgress() + ","; // end delimiter
        	
        	String mapa2 = "";        	
        	mapa2 = ""+((VerticalSeekBar) findViewById(R.id.SeekBar201)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar202)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar203)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar204)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar205)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar206)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar207)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar208)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar209)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar210)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar211)).getProgress();
        	mapa2 = mapa2 + "," + ((VerticalSeekBar) findViewById(R.id.SeekBar212)).getProgress() + ","; // end delimiter
        	
        	// We need an Editor object to make preference changes.
            // All objects are from android.context.Context            
        	SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            
	        switch (item.getItemId()) {
	            
	        case R.id.saveMap:
	        	
	            editor.putString("mapa1", mapa);
	            editor.putString("mapa2", mapa);
	            // Commit the edits!
	            editor.commit();
	            
	            Toast.makeText(getApplicationContext(), "Mapa salvo!", Toast.LENGTH_SHORT).show();	            
	        	break;
	        	
	        case R.id.sendMap:
	        	System.out.println("enviando mapas");
	        	System.out.println(mapa);
	        	
	            editor.putString("mapa1", mapa);
	            editor.putString("mapa2", mapa);
	            // Commit the edits!
	            editor.commit();	            
	            
	        	MainApplication.get().getSerialService().write(("m"+mapa).getBytes());
	        	MainApplication.get().getSerialService().write(("n"+mapa).getBytes());
	        	
	        	Toast.makeText(getApplicationContext(), "Mapa enviado!", Toast.LENGTH_SHORT).show();
	        	
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
