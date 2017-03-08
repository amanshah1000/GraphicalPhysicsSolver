
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Waves extends UpdatableComponent 
{ 
    private double frequency;
    private double wavelength;
    private double velocity;
    private double speed;
    private double length;
    private Image closedImage;
    private Image openImage;
    private boolean isOpen;
    private double harmonic;
    public Waves(double harmonic)
    {

        super();
        this.velocity=velocity;
        frequency=1;
        length=1;
        this.harmonic=harmonic;
        isOpen=false;
        calculate();
        try
        {
            closedImage = ImageIO.read(new File("Tube Closed.png"));

        } catch (IOException ex)
        {
            Logger.getLogger(WavesPanel.class.getName()).log(Level.WARNING,null,ex);
        }
        try
        {
            openImage = ImageIO.read(new File("Tube Open.png"));

        } catch (IOException ex)
        {
            Logger.getLogger(WavesPanel.class.getName()).log(Level.WARNING,null,ex);
        }

    }
    public void update(){
    	repaint();
    }
    public void setHarmonic(double harmonic){
        this.harmonic= harmonic;
    }

    public void calculate()
    {
    	System.out.println(isOpen);
    	if(isOpen==true)
    	{
    		wavelength = 2/harmonic * length;
    	}
    	else
    	{
    		wavelength = 4/harmonic * length;
    	}
    }


    public void setOpen(boolean isOpen) {this.isOpen=isOpen;}

    public void drawCosWave(Graphics g,int x,int y,int scale,double periods,boolean mirror)
    {
        //resolution is how close each step is to the other the higher the resolution the higher the step.
        //resolution is not dependent on period
        // as you go too high in resolution you get weird artifacts. 64 doesnt give much artifacting
        //wavelength= wavelength/100.0;
		int alternator;
		if (mirror==true)
		{
			alternator=-1;
		}
		else
		{
			alternator=1;
		}
		System.out.println(wavelength);
        double resolution =64;
        double step = (2*Math.PI)/resolution;
        double maxSteps=(2*Math.PI)*periods;
        double functionX;
        double functionY;
        double nxtFunctionX;
        double nxtFunctionY;
        int currentX;
        int currentY;
        int nxtX;
        int nxtY;
        int initialX=x;
        int initialY=y;



       for (double i=0;i<=maxSteps;i=i+step)
       {
           functionX=i;
           functionY=alternator*1.28*Math.cos((1/wavelength)*(i));
           nxtFunctionX=i+step;
           nxtFunctionY=alternator*1.28*Math.cos((1/wavelength)*(i+step));
           currentX= initialX+(int)(functionX *scale);
           currentY= initialY+(int)(functionY *scale);
           nxtX= initialX+(int)(nxtFunctionX *scale);
           nxtY= initialY+(int)(nxtFunctionY *scale);


           g.drawLine(currentX,currentY,nxtX,nxtY);
       }

    }

	public void drawSinWave(Graphics g,int x,int y,int scale,double periods,boolean mirror)
	{
		//resolution is how close each step is to the other the higher the resolution the higher the step.
		//resolution is not dependent on period
		// as you go too high in resolution you get weird artifacts. 64 doesnt give much artifacting
		//wavelength= wavelength/100.0;
		int alternator;
		if (mirror==true)
		{
			alternator=-1;
		}
		else
		{
			alternator=1;
		}
		System.out.println(wavelength);
		double resolution =64*(1/wavelength);
		double step = (2*Math.PI)/resolution;
		double maxSteps=(2*Math.PI)*periods;
		double functionX;
		double functionY;
		double nxtFunctionX;
		double nxtFunctionY;
		int currentX;
		int currentY;
		int nxtX;
		int nxtY;
		int initialX=x;
		int initialY=y;



		for (double i=0;i<=maxSteps;i=i+step)
		{
			functionX=i;
			functionY=alternator*1.35*Math.sin((1/wavelength)*(i));
			nxtFunctionX=i+step;
			nxtFunctionY=alternator*1.35*Math.sin((1/wavelength)*(i+step));
			currentX= initialX+(int)(functionX *scale);
			currentY= initialY+(int)(functionY *scale);
			nxtX= initialX+(int)(nxtFunctionX *scale);
			nxtY= initialY+(int)(nxtFunctionY *scale);


			g.drawLine(currentX,currentY,nxtX,nxtY);
		}

	}
	public void drawGrid(Graphics g)
	{
		g.setColor(Color.BLUE);
		Graphics2D g2d = (Graphics2D)g;
		for( int i = 0; i <= 800; i = i+10)
		{
			g2d.drawLine(i, 0, i, 600);
			String k = String.valueOf(i);
			g2d.drawString(k,i,  0);
		}

		for( int j = 0; j <= 600; j = j+10)
		{
			g2d.drawLine(0,j, 800, j);
			String k = String.valueOf(j);
			g2d.drawString(k, 0, j);
		}
	}


	public void paint(Graphics g) 
    {
		Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.WHITE);

        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.BLACK);
		//g.setColor(Color.RED);
        

        g.drawString( "Closed Columns : " + " Length is " + length + " m when Wavelength is " + wavelength + " m/s", getWidth()/2, getHeight()/2);

        //g.drawString("Wavelength is " + wavelength + "when Frequency is:" + String.valueOf(wavelength) + "m/s", getWidth()/2, getHeight()/2);

        if(isOpen)
        {
			g.setColor(Color.RED);
            g2d.drawImage(openImage, getWidth()/2-200,200-60, 400,200, this);
            calculate();
			drawCosWave(g,getWidth()/2-200,getHeight()/2-6,63,1,false);
			drawCosWave(g,getWidth()/2-200,getHeight()/2-6,63,1,true);
        }
        else
        {
        	g.setColor(Color.RED);
            g2d.drawImage(closedImage, getWidth()/2-200,200-60, 400,200, this);
			calculate();
			drawSinWave(g,getWidth()/2-200+27,getHeight()/2-6,59,1,false);
			drawSinWave(g,getWidth()/2-200+27,getHeight()/2-6,59,1,true);
        }
		//drawGrid(g);


        //drawTrajectory(g,0,getHeight()/2,20,85);
        /*
		g.setColor(Color.BLACK);
		drawTrajectory(g,0,getHeight()/2,20,40);
		g.setColor(Color.RED);
		drawTrajectory(g,0,getHeight()/2,20,35);
		g.setColor(Color.BLACK);
		drawTrajectory(g,0,getHeight()/2,20,30);
		g.setColor(Color.RED);
		drawTrajectory(g,0,getHeight()/2,20,25);
		g.setColor(Color.BLACK);
		drawTrajectory(g,0,getHeight()/2,20,20);
		g.setColor(Color.RED);
		drawTrajectory(g,0,getHeight()/2,20,15);

		//g.setColor(Color.BLACK);
		//g.drawLine(0,getHeight()/2,getWidth(),getHeight()/2);
		g.setColor(Color.BLUE);

		for( int i = 0; i <= 800; i = i+10)
		{
			g2d.drawLine(i, 0, i, 600);
			String k = String.valueOf(i);
			g2d.drawString(k,i,  0);
		}

		for( int j = 0; j <= 600; j = j+10)
		{
			g2d.drawLine(0,j, 800, j);
			String k = String.valueOf(j);
			g2d.drawString(k, 0, j);
		}
		*/


    }
}
          

          
          
          
