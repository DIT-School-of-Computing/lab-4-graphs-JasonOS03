package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

	float[] rainfall = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};

	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;

		if(r1 == 0)
		{
			return d;
		}

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}
	

	

	public void settings()
	{
		size(500, 500);

		
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10 


	}

	public void setup() {
		colorMode(HSB);
		background(0);
		randomize();
		
		
		
	}

	public void randomize()
	{
		for(int i = 0;i<rainfall.length;i++)
		{
			rainfall[i] = random(500);
		}
	}

	
	public void draw()
	{
		

		if(keyCode == LEFT)
		{
			background(0);
			
			float w = (width - 80) / (float)months.length - 1;
			for(int i = 0 ; i < months.length ;  i ++)
			{


				
				float colorspec = map1(i,0, months.length, 0, 255);

				float x = 40+i*w;
				fill(colorspec,255,225);
				rect(x,height - 30, w, -rainfall[i]);
				


				textAlign(CENTER,CENTER);
				fill(255);
				text(months[i],x+w/2,height - 20);
			}

				textAlign(RIGHT);

				
				

			for(int i = 0 ; i<=  120;i+=10)
			{

			
				float y = map(i, 0,120, height - 30, 40);
				fill(255);
				text(i, 30, y);
			}
				
			
			
			textAlign(CENTER);
			text("Rainfall bar chart",width/2,20);


			stroke(255);
			line(40,40,40,height-40);
			
			line(30,height-30,width-30,height-30);
			

		}
		else if(keyCode == RIGHT)
		{
			background(0);
			
			float w = 500 /(float) months.length - 1;
			
				for( int i=0;i<months.length-1;i++)
				{

				
					stroke(255);
					float y1 = height - rainfall[i];
					float x1 = i*w+40;
					float x2 = (i+1)*w+40;
					float y2 = height - rainfall[i+1];

					line(x1,y1,x2,y2);

					
					

					
					textAlign(RIGHT);
				}

				
				

			for( int i = 0 ; i<=  120;i+=10)
			{

			
				float y = map(i, 0,120, height - 30, 40);
				fill(255);
				text(i, 30, y);
			}
				
			
			
			textAlign(CENTER);
			text("Rainfall Trend chart",width/2,20);


			stroke(255);
			line(40,40,40,height-40);
			
			line(30,height-30,width-30,height-30);

			for(int i = 0;i<months.length;i++)
			{
				float x = map1(i, 0, months.length, 40, width-40);
				textAlign(CENTER,CENTER);
				fill(255);
				text(months[i],x+w/2,height-20);

			}
			



		}
		 else if(keyCode == DOWN)
		{
			float startang = 0;
			float sum = 0;
			for(float f: rainfall)
			{
				sum = sum+f;
			}


			
			for(int i  = 0;i<months.length;i++)
			{
				float angle = map(rainfall[i], 0, sum, 0, TWO_PI);
				float colorspec2 = map1(i,0,months.length,0,255);
				fill(colorspec2,255,255);
				arc(width/2,height/2,200,200,startang,startang + angle);

				float midpoint = startang + angle/2;
				float x = width/2 + cos(midpoint)*115;
				float y = height/2 + sin(midpoint)*115;

				textAlign(CENTER,CENTER);
				fill(255);
				text(months[i],x,y);
				startang+=angle;
	
				
			}

			
			textAlign(CENTER,CENTER);
			fill(255);
			text("Rainfall piechart",width/2,height+20);
		
			

			
			
			
		}
	}
}

