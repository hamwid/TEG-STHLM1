//Sensor
package edu.holger;

import java.util.Random; //to simulate static or disturbance in updateData(int input)

public class Sensor {
  public int originalOutput  = 0; //Reads data twice; this is first read.
  public int safetyOutput    = 0; //Reads data twice; this is second read.
  public int startRestartPin = 1;//1 = undefined, 0 = send data, 3 = restart.
  private Random rand = new Random(); //to simulate static or disturbance

  public void updateStatus(int input){
    startRestartPin = input;
  }

  //The real updateData() is removed and replaced with updateData(int input)
  //in order to ease development of system while no physical sensor is present
  /*
  public void updateData(){
    originalOutput = @ReadData();
    safetyOutput   = @ReadData();
  }*/

  public void updateData(int input){
    originalOutput = input;
    safetyOutput   = input;

    //Random to simulate disturbance in environment or static in signal
    int n = rand.nextInt(10) + 1;
    if (n>8){ //disturbance or static occured on first data-read
      originalOutput += (n-8)*5;
    }
    if (n<5){ //disturbance or static occured on second data-read
      if (n<3){
        safetyOutput += n*5;
      } else {
        safetyOutput += (n-2)*-5;
      }
    }
  }

  //reconfigure() performs handy stuff to restart a sensor but is removed
  //in order to ease development of system while no physical sensor is present
  /*
  public void reconfigure(){
    @ReconfigureSensor();
  }*/
}
