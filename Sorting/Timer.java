/*
Author: Mr. Guglielmi
Date: 12/04/2024
Description: This class implements a timer thread that can be used to time events in milliseconds. 
*/
/**
Timer implements a timer thread that can be used to time events in milliseconds. 
@author Mr. Guglielmi
@author Tristan Cao
@version 1.0
*/
public class Timer extends Thread{
    /**
    The time in miliseconds
    */
    private int time;//the time
    /**
    If the thread is running or not
    */
    private boolean running;//control for the thread
   /**
    Constructor for the Timer class
    */
    Timer (){
	time = 0;//start the timer at 0
	running = true;

    }

   /**
   A method to get the current time
   @return the time in miliseconds
   */
    public int getTime(){
	return this.time; //get the current timer value
       
    }
    /**
   A method end the timer
   */
    public void endTimer(){
	this.running = false; //end the loop in run, killing the thread
    }
   /**
   Check if the timer is running or not
   @return if the timer is running as a boolean value
   */
    public boolean isRunning(){
	return this.running; //check if the timer is running
    }

   
    /**
   Override of the run method. Will execute when the thread is started
   */
    public void run(){

	while (running){ //so long as the timer is running

	    try{
		sleep(1); //wait 1 millisecond
	    }
	    catch (Exception e){
	    
	    }

	    this.time++; //increment the time elapsed

	}
    }
}
