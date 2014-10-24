package com.example.testttspause;




	import java.util.HashMap;
import java.util.Locale;






	import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnUtteranceCompletedListener;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

	public class TestTTSActivity extends Activity implements TextToSpeech.OnInitListener, OnUtteranceCompletedListener{
	 
	    TextView tv;
	    String strin;
	    String remap;
	    StringBuilder sb;
	    static public MediaPlayer mediaPlayer;
	    public static TextToSpeech tts2;
	    HashMap<String, String> params ;
	    public static int oneTimeOnly = 0;
	    int i=0;
	    String leggicolora;
	    String[] separated ;
	    String[] separatedcol ;
	    public SharedPreferences myPrefssiti;
	    TextView    leggitts;
	    boolean paused= false;
	    float tono, velocita;
	    String leggi;
	    @SuppressWarnings("deprecation")
		@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.leggipau);
	        //tts2 = new TextToSpeech(this, this);
	      //  Intent intent = getIntent();
	        
	       // this.leggi = intent.getStringExtra("stringa");
	      Log.d("STRINGAALE", "leggitts: " + leggi);
	          leggitts = (TextView)findViewById(R.id.description);
	         leggi="La Gioconda, nota anche come Monna Lisa, è un dipinto a olio su tavola di pioppo (77 cm×53 cm) di Leonardo da Vinci, databile al 1503-1514 circa, e conservata nel Museo del Luvr di Parigi. Opera emblemàtica ed enigmàtica, si tratta sicuramente del ritratto più celebre del mondo, nonché di una delle opere d'arte più note in assoluto, oggetto di infiniti omaggi, ma anche di parodie e sberleffi. Il sorriso impercettibile della Gioconda, col suo alone di mistero, ha ispirato tantissime pagine di critica, di letteratura, di opere di immaginazione, di studi anche psicoanalitici. Sfuggente, ironica e sensuale, la Monna Lisa è stata di volta in volta amata, idolatrata, ma anche derisa o aggredita. Vera e propria icona della pittura, è vista ogni giorno da migliaia di persone, tanto che nella grande sala in cui è esposta, un cordone deve tenere a notevole distanza i visitatori: nella lunga storia del dipinto non sono mancati i tentativi di vandalismo, nonché un furto rocambolesco che in un certo senso ne ha alimentato la leggenda. FINE";
	         Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Verdana.ttf");
	          leggitts.setTypeface(typeFace);
	         
	   
	          
	         leggi=   Html.fromHtml(leggi).toString();
	         leggicolora = leggi;
	     
	      // String  output = leggi.replaceAll("\\s+la\\s+", " £la ");
	       //Log.d("PROVA1", "leggitts: " + output);
	         // String strOutput = sb.toString();
	         // leggi=	 leggi.replaceAll("\\s+la\\s+", " £la ");
	           // leggi=	 leggi.replaceAll("\\s+si\\s+", " £si ");
	           // leggi=	 leggi.replaceAll("\\s+di\\s+", " £di ");
	           // leggi=	 leggi.replaceAll("\\s+il\\s+", " £il ");
	           // leggi=	 leggi.replaceAll("\\s+del\\s+", " £del ");
	           // leggi=	 leggi.replaceAll("\\s+dal\\s+", " £dal ");
	           // leggi=	 leggi.replaceAll("\\s+lo\\s+", " £lo ");
	           // leggi=	 leggi.replaceAll("\\s+le\\s+", " £le ");
	           // leggi=	 leggi.replaceAll("\\s+in\\s+", " £in ");
	           //leggi=	 leggi.replaceAll("\\s+con\\s+", " £con ");
	           //leggi=	 leggi.replaceAll("\\s+su\\s+", " £su ");
	           //leggi=	 leggi.replaceAll("\\s+per\\s+", " £per ");
	           //leggi=	 leggi.replaceAll("\\s+tra\\s+", " £tra ");
	           //leggi=	 leggi.replaceAll("\\s+fra\\s+", " £fra ");
	           //leggi=	 leggi.replaceAll("\\s+che\\s+", " £che "); 
	           //leggi=	 leggi.replaceAll("\\s+da\\s+", " £da ");
	           //leggi=	 leggi.replaceAll("\\s+un\\s+", " £un ");
	           //leggi=	 leggi.replaceAll("\\s+uno\\s+", " £uno ");
	           // leggi=	 leggi.replaceAll("\\s+una\\s+", " £una ");
	           //leggi=	 leggi.replaceAll("\\s+gli\\s+", " £gli ");
	           leggi=	 leggi.replace(". ","£. ");
	           leggi=	 leggi.replace(", ","£,");
	           leggi=	 leggi.replace(": ","£:");
	           
	        		 //.replace("\\s+si\\s+"," £si ").replace("\\s+del\\s+"," £del ").replace("\\s+le\\s+"," £le ").replace("\\s+la\\s+"," £la ").replace("\\s+in\\s+"," £in ").replace("\\s+con\\s+"," £con ").replace("\\s+su\\s+"," £su ").replace("\\s+per\\s+"," £per ").replace("\\s+tra\\s+"," £tra ").replace("\\s+fra\\s+"," £fra ").replace(".\\s+"," £. ").replace(",\\s+","£,");
	        		 Log.d("OUTPUTTY", "leggitts: " + leggi);  
	          separated = leggi.split("£");
	         
	       //   for (int i=0; i<separated.length; i++){
	        	  
	        	//  Log.d("LEGGIPAROLE", "leggitts: " + separated[i]);  
	        	  leggi=separated[i];
	        	  separatedcol = separated;
	        	  
	        		
	            	
	            	
	        	 // ciao();
	        	  tts2 = new TextToSpeech(this, this);
	        	  
	        	 
	        	  
	        	  // }
	          
	          
	         
	          
	          myPrefssiti =this.getSharedPreferences("myPrefs", Context.MODE_WORLD_READABLE);
	           velocita = myPrefssiti.getFloat("velocita",1);
	           tono = myPrefssiti.getFloat("tono",1);
	          Log.d("SPS","velocita BAH " + velocita);
	          if (myPrefssiti.contains("velocita")) 
	          {
	        
	           Log.d("SPS","velocita SI " + velocita);
	       
	          }else{
	        	  
	        	  Log.d("SPS","velocita NO");
	          }
	          if (myPrefssiti.contains("tono")) 
	          {
	        
	           Log.d("SPS","tono SI");
	        
	          }else{
	        	  
	        	  Log.d("SPS","tono NO");
	          }
	          
	          
	     
	          
	    }

		@Override
		public void onDestroy()
		{
		    
		    if (tts2 != null)
		    {
		    	tts2.stop();
		    	tts2.shutdown();
		    }
		    super.onDestroy();
		}

		@Override
		public void onInit( int status) {
			Log.d("INITIO", "sono in onInit: " + leggi);
			if (status == TextToSpeech.SUCCESS) {
				Log.d("INITIO", "status ok : " + leggi);
				int result = tts2.setLanguage(Locale.ITALIAN);

				 tts2.setPitch((float) tono); // set pitch level

				tts2.setSpeechRate((float) velocita); // set speech speed rate

				if (result == TextToSpeech.LANG_MISSING_DATA
						|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
					Log.e("TTS", "Language is not supported");
				} else {
					
					params = new HashMap<String, String>();
		        	  params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"stringId");
		        	  remap="";
		            	for (int j=0;j<separatedcol.length;j++){
		            		if (i==j){
		            			String colorized = separatedcol[j].replace(separatedcol[j], "<font color=yellow>"+separatedcol[j]+ "</font>");
		            			remap= remap + colorized;	
		            		}else{
		            		remap= remap + separatedcol[j];
		            		}
		            	}
		            	leggitts.setText(Html.fromHtml(remap));
					tts2.setOnUtteranceCompletedListener(this);
					 tts2.speak(leggi,TextToSpeech.QUEUE_FLUSH, params);
				}

			} else {
				Log.e("TTS", "Initilization Failed");
			}
			
		}
		
		public void onUtteranceCompleted(String utteranceId) {
			// TODO Auto-generated method stub
			Log.d("LEGGIPAROLE2", "ECCOLO" + separated[i]);
			
			  HashMap<String, String> params = new HashMap<String, String>();

			  params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"stringId");
			
			 
		      if (i<separated.length-1){
		      if (!paused){
		    	  i++;


		    	  


		      	Log.d("LEGGIPAROLE2", "leggitts: " + separated[i]);
		       leggi=separated[i];
		      
		       
		  	 runOnUiThread(new Runnable() {
	             
		            @Override
		            public void run() {
		      
		            	
		            	
		            	String remap="";
		            	for (int j=0;j<separatedcol.length;j++){
		            		if (i==j){
		            			String colorized = separatedcol[j].replace(separatedcol[j], "<font color=yellow>"+separatedcol[j]+ "</font>");
		            			remap= remap + colorized;	
		            		}else{
		            		remap= remap + separatedcol[j];
		            		}
		            	}
		            	leggitts.setText(Html.fromHtml(remap));
		            	
		            	
		            	
		            	
		            	}
		        });

		       
		       
		       
		       
		       
		       tts2.speak(leggi,TextToSpeech.QUEUE_FLUSH, params);
		      }else{
		    	  Log.d("PAUSIZZO", "PAUSIZZO");
		    	  tts2.playSilence(100, TextToSpeech.QUEUE_ADD, null);
		    	  
		      }
		       
		      }
		      
		     
		}
		void speak(String leggi){
			  Log.d("STRINGAALE", "sono in SPEAK: " + leggi);
			
	         tts2.speak("ciao", TextToSpeech.QUEUE_FLUSH, null);
		}

	 @SuppressWarnings("deprecation")
	void ciao(){
		
		  
		  tts2.setOnUtteranceCompletedListener(new OnUtteranceCompletedListener() {

	           @Override
	           public void onUtteranceCompleted(final String utteranceId) {
	                       System.out.println("Completed");

	               runOnUiThread(new Runnable() {

	                   @Override
	                   public void run() {
	                   i++;
	                   if (i<separated.length){
	                   	if (tts2!=null){
	                   		
	                   		tts2.stop();
	                   		//tts2.shutdown();
	                   	}
	                   	Log.d("LEGGIPAROLE2", "leggitts: " + separated[i]);
	                    leggi=separated[i];
	                    ciao();
	                   }
	                 	 
	                   }
	               });
	           }
	       });
		 
	 }
	 public void pause(View v)
	{
		paused=true;
	    Toast.makeText(TestTTSActivity.this, "Pausing", Toast.LENGTH_SHORT).show();

		
	}
	 public void play(View v)
	{
		paused=false;
		 Toast.makeText(TestTTSActivity.this, "Playing", Toast.LENGTH_SHORT).show();
		i++;
		params = new HashMap<String, String>();
  	  params.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,"stringId");
  	  remap="";
      	for (int j=0;j<separatedcol.length;j++){
      		if (i==j){
      			String colorized = separatedcol[j].replace(separatedcol[j], "<font color=yellow>"+separatedcol[j]+ "</font>");
      			remap= remap + colorized;	
      		}else{
      		remap= remap + separatedcol[j];
      		}
      	}
      	leggitts.setText(Html.fromHtml(remap));
		leggi=separated[i];
		tts2.speak(leggi,TextToSpeech.QUEUE_FLUSH, params);
	}
	 
	 public void forward(View v)
	{
		 
	
		Toast.makeText(TestTTSActivity.this, "Forward", Toast.LENGTH_SHORT).show();
		
		if (i>=separated.length){
			i=separated.length-1;
			
		}
		leggi=separated[i];
		if (!paused){
			
			tts2.speak(leggi,TextToSpeech.QUEUE_FLUSH, params);
			}else{
				i++;
			}
	}
	 
	 
	 public void rewind(View v)
	{
		 
		tts2.stop();
		if (paused){
			i--;
		 }else{
		i--;
		i--;
		 }
		if (i<0){
			
			i=0;
		}
		Toast.makeText(TestTTSActivity.this, "Rewind", Toast.LENGTH_SHORT).show();
		leggi=separated[i];
		
		if (!paused){
		tts2.speak(leggi,TextToSpeech.QUEUE_FLUSH, params);
		}
	}
	 public void colora(){
	 
	 leggitts.setText(Html.fromHtml("<font color=white>"+leggi+ "</font>")); 
	 
	 }
	}