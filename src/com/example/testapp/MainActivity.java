package com.example.testapp;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	Button btnQeleBrowserin;
	ImageView fotografia;
	private int resultCode;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        fotografia=(ImageView) findViewById(R.id.fotografia);
        
        btnQeleBrowserin = (Button)
        		findViewById(R.id.btnQeleBrowserin);
        
        btnQeleBrowserin.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        		startActivityForResult(i,0);
        	
        	}
        	
        }
    );}
    
    @Override
    protected void onActivityResult(int requestCode, int resultCOde, Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	InputStream istream;
    	try
    	{
    		istream = getContentResolver().openInputStream(data.getData());
    		Bitmap bmp=BitmapFactory.decodeStream(istream);
    		istream.close();
    		fotografia.setImageBitmap(bmp);
    	}
    	catch(FileNotFoundExeption e)
    	{
    	
    		e.printStackTrace();
    		
    	}
    	catch(IOExection e)
    	{
    		e.printStackTrace();
    	}
    	
    	
    }
   
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
