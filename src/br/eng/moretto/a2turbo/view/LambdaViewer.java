package br.eng.moretto.a2turbo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class LambdaViewer extends View {
	
	Paint darkRed,red,darkYellow,yellow,darkGreen,green,textPaint;
	
	int value = 0;
	
	public LambdaViewer(Context context) {
		super(context);
		init();
	}

	public LambdaViewer(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public LambdaViewer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	private void init() {		
		
		darkRed = new Paint();
		darkRed.setAntiAlias(true);
		darkRed.setColor(0xff550000); 
		darkRed.setStyle(Paint.Style.FILL);
		
		red = new Paint();
		red.setAntiAlias(true);
		red.setColor(0xffFF0000); 
		red.setStyle(Paint.Style.FILL);
		
		darkYellow = new Paint();
		darkYellow.setAntiAlias(true);
		darkYellow.setColor(0xff555500); 
		darkYellow.setStyle(Paint.Style.FILL);
		
		yellow = new Paint();
		yellow.setAntiAlias(true);
		yellow.setColor(0xffFFFF00); 
		yellow.setStyle(Paint.Style.FILL);
		
		darkGreen = new Paint();
		darkGreen.setAntiAlias(true);
		darkGreen.setColor(0xff005500); 
		darkGreen.setStyle(Paint.Style.FILL);
				
		green = new Paint();
		green.setAntiAlias(true);
		green.setColor(0xff00FF00); 
		green.setStyle(Paint.Style.FILL);
		
		
		textPaint = new Paint();
		textPaint.setStyle(Paint.Style.STROKE);
		textPaint.setAntiAlias(true);
		textPaint.setTypeface(Typeface.DEFAULT);
		textPaint.setTextAlign(Paint.Align.CENTER);
		textPaint.setTextSize(30f);
		textPaint.setTextScaleX(1f);
		textPaint.setColor(0xafA0A0A0);
		 
		red.setAlpha(70);
		green.setAlpha(70);
		yellow.setAlpha(70);
		
		invalidate();
	}

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		super.onDraw(canvas);	
		
		float x=20f;
		for(int i=0 ; i < 12 ; i++){
			
			// the light is on!
			if(value == i){
				red.setAlpha(255);
				green.setAlpha(255);
				yellow.setAlpha(255);
			}
			
			if(i<4){				
				canvas.drawCircle(x, 24f, 18f, red);
			}else if(i<8){
				canvas.drawCircle(x, 24f, 18f, yellow);
			}else{
				canvas.drawCircle(x, 24f, 18f, green);
			}
			
			//default light (off)
			red.setAlpha(80);
			green.setAlpha(80);
			yellow.setAlpha(80);
			
			x+=40f;
		}
		
		canvas.drawText("Hallmeter", 70f, 70f, textPaint);		
		canvas.restore();
	}
	
	/**
	 * 
	 * @param value range 1 to 12
	 */
	public void setValue(int value){
	
		this.value = value;
	}

}
