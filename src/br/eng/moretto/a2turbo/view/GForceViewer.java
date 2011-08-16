package br.eng.moretto.a2turbo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class GForceViewer extends View {
	
	Paint textPaint, rimPaint,targetPaint;
	
	int x,y = 0;
	
	public GForceViewer(Context context) {
		super(context);
		init();
	}

	public GForceViewer(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public GForceViewer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	private void init() {		
		
		rimPaint = new Paint();
		rimPaint.setAntiAlias(true);
		rimPaint.setColor(0xafA0A0A0); 
		rimPaint.setStyle(Paint.Style.STROKE);	
		rimPaint.setTextSize(20f);
				
		targetPaint = new Paint();
		targetPaint.setAntiAlias(true);
		targetPaint.setColor(0xffAA0000); 
		targetPaint.setStyle(Paint.Style.FILL);	
		targetPaint.setStrokeWidth(4f);
		
		textPaint = new Paint();
		textPaint.setStyle(Paint.Style.STROKE);
		textPaint.setAntiAlias(true);
		textPaint.setTypeface(Typeface.DEFAULT);
		textPaint.setTextAlign(Paint.Align.CENTER);
		textPaint.setTextSize(30f);
		textPaint.setTextScaleX(1f);
		textPaint.setColor(0xafA0A0A0);
		
		invalidate();
	}

	
	@Override
	protected void onDraw(Canvas canvas) {
		
		super.onDraw(canvas);	
		
		int x1g = 65;
		int y1g = 65;
		int x2g = 130;
		int y2g = 130;
		int cx = 160;
		int cy = 160;
		int size = 20;
		int nx = 0;
		int ny = 0;
		//rim 1G
		
		//top left
		canvas.drawLine(cx-x1g, cy-y1g, cx-x1g+size, cy-y1g, rimPaint); //x
		canvas.drawLine(cx-x1g, cy-y1g, cx-x1g, cy-y1g+size, rimPaint); //y
		canvas.drawText("1G", 205, 245, rimPaint);
		//top right		
		canvas.drawLine(cx+x1g-size, cy-y1g, cx+x1g, cy-y1g, rimPaint); //x
		canvas.drawLine(cx+x1g, cy-y1g, cx+x1g, cy-y1g+size, rimPaint); //y
		//bottom left
		canvas.drawLine(cx-x1g, cy+y1g, cx-x1g+size, cy+y1g, rimPaint); //x
		canvas.drawLine(cx-x1g, cy+y1g, cx-x1g, cy+y1g-size, rimPaint); //y
		//bottom right		
		canvas.drawLine(cx+x1g-size, cy+y1g, cx+x1g, cy+y1g, rimPaint); //x
		canvas.drawLine(cx+x1g, cy+y1g, cx+x1g, cy+y1g-size, rimPaint); //y
		
		/*
		canvas.drawLine(210, 230, 230, 230, rimPaint); //x
		canvas.drawLine(230, 210, 230, 230, rimPaint); //y
		canvas.drawText("1G", 210-30, 230+7, rimPaint);
		*/
		//rim 2G
		
		//top left
		canvas.drawLine(cx-x2g, cy-x2g, cx-x2g+size, cy-x2g, rimPaint); //x
		canvas.drawLine(cx-y2g, cy-y2g, cx-y2g, cy-y2g+size, rimPaint); //y
		//top right		
		canvas.drawLine(cx+x2g-size, cy-x2g, cx+x2g, cy-x2g, rimPaint); //x
		canvas.drawLine(cx+y2g, cy-y2g, cx+y2g, cy-y2g+size, rimPaint); //y
		//bottom left
		canvas.drawLine(cx-x2g, cy+x2g, cx-x2g+size, cy+x2g, rimPaint); //x
		canvas.drawLine(cx-y2g, cy+y2g, cx-y2g, cy+y2g-size, rimPaint); //y
		//bottom right		
		canvas.drawLine(cx+x2g-size, cy+x2g, cx+x2g, cy+x2g, rimPaint); //x
		canvas.drawLine(cx+y2g, cy+y2g, cx+y2g, cy+y2g-size, rimPaint); //y
		
		canvas.drawText("2G", 298-30, 308, rimPaint);
		
		//target
		//x-=250;//zero gap (0-250)
		
		//misterious ahead!!!
		nx = x;
		if(x < 0){
			nx*=-1;
			int factor = 128-nx;
			nx += factor*2;			
		}
		ny = y;
		if(y < 0){
			ny*=-1;
			int factor = 128-ny;
			ny += factor*2;			
		}
		
		ny*=1.28; //fit to range (320x320px - size of gauge)
		nx*=1.28; //fit to range (320x320px - size of gauge)
		
		//inverting
		nx = 320 - nx;
		ny = 320 - ny;		
		
		//canvas.drawLine(x, 150, x, 170, targetPaint);
		//canvas.drawLine(x-10, 160, x+10, 160, targetPaint);
		canvas.drawCircle(nx, ny, 15, targetPaint);
		
		//mid375   max500   min 250
		// 0.1g = 0.016
		// +1g = 60 ( 435 )
		// +2g >= 120 (490)
		// -1g
				
		canvas.drawText("G-Force", 55f, 318f, textPaint);		
		canvas.restore();
	}
	
	/**
	 * 
	 * @param value range 1 to 12
	 */
	public void setGForce(Integer x, Integer y){	
		if(x != null) this.x = x;
		
		if(y != null) this.y = y;
		
		invalidate();
	}

}
