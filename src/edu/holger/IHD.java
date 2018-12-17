//IHD
package edu.holger;

public class IHD {
  private int read1;                //input from sensor, "original output"
  private int read2;                //input from sensor, "safety output"
  private int mean;                 //mean of read1 and read2
  public int outputToSensor; //output to sensor
  private Sensor sensor;     //the connected sensor

  final private int TO_SENSOR_3V = 3; //3V = "reset sensor"
  final private int TO_SENSOR_0V = 0; //0V = "listen to sensor-values"

  //Initialize IHD, connect with 1 Sensor
  public void initialize(Sensor sensor_1){
    read1 = 0;
    read2 = 0;
    mean = 0;
    outputToSensor = TO_SENSOR_3V;
    sensor = sensor_1;
  }

  //Execute IHD
  public void execute(){
    listenToSensor();
    readFromSensor();
    mean(read1, read2);
  }

  //Calculate mean
  private void mean(int i1, int i2){
    mean = (i1+i2)/2;
  }

  //Obtain mean of read1 and read2
  public int getMean(){
    return mean;
  }

  //Put 3V on "start/restart"-pin of sensor
  public void startSensor(){
    outputToSensor = TO_SENSOR_3V;
  }

  //Put 0V on "start/restart"-pin of sensor
  private void listenToSensor(){
    outputToSensor = TO_SENSOR_0V;
  }

  //Collect data from connected sensor
  private void readFromSensor(){
    read1 = sensor.originalOutput;
    read2 = sensor.safetyOutput;
  }

  //Get-methods for testers
  public int getRead1(){
    return read1;
  }
  public int getRead2(){
    return read2;
  }
}
