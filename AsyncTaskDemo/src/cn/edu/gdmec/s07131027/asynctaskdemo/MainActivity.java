

package cn.edu.gdmec.s07131027.asynctaskdemo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ImageView imageView;
	private ProgressBar progressBar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        progressBar = (ProgressBar) findViewById(R.id.progressBae);
    }
    
    public void doClick(View v){
    	MyAsyncTask asyncTask = new MyAsyncTask();
    	asyncTask.execute("http://www.hao123.com");
    }
    
    private class MyAsyncTask extends AsyncTask<String, Integer, Integer>{

		@Override
		protected Integer doInBackground(String... params) {
			for(int i = 0; i < 100; i += 10){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				publishProgress(i);
			}
			;
			return R.drawable.ic_launcher;
		}
    	
		@Override
		protected void onPostExecute(Integer result) {
			super.onPostExecute(result);
			
			imageView.setImageResource(result);
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			
			Toast.makeText(MainActivity.this, "¿ªÊ¼ÏÂÔØ", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		protected void onCancelled() {
			super.onCancelled();
			
			Log.i("info", "onCancelled");
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			
			progressBar.setProgress(values[0]);
		}
    }

}
