package br.eng.moretto.a2turbo;


import br.eng.moretto.a2turbo.view.VerticalSeekBar;
import android.app.Activity;
import android.os.Bundle;

public class FuelMapper extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.fuel_mapper);   
		
		//TODO persist values in preferences
		
		
		 VerticalSeekBar vSeekBar = (VerticalSeekBar)findViewById(R.id.SeekBar01);
		 vSeekBar.setProgress(30);
	     
		 vSeekBar = (VerticalSeekBar)findViewById(R.id.SeekBar02);
		 vSeekBar.setProgress(40);

		 
		 //vSeekBar.setMax(100);
	       
		
	}
}
