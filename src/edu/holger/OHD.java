//OHD
package edu.holger;

public class OHD{
  private boolean rear;                      //rear sensor > 5cm from object
  private boolean left;                      //left sensor > 30cm from object
  private boolean right;                     //right sensor > 30cm from object
  private boolean forwardL;                  //forwardL sensor > 30cm from object
  private boolean forwardR;                  //forwardR sensor > 30cm from object
  private boolean[] output = new boolean[5]; //output-data to external system
  private IAD iad1;                          //first connected IAD
  private IAD iad2;                          //second connected IAD
  private IAD iad3;                          //third connected IAD
  private IAD iad4;                          //fourth connected IAD
  private IAD iad5;                          //fifth connected IAD

  //Initialize OHD, connect with 3 IAD
  public void initialize(IAD iad_1, IAD iad_2, IAD iad_3, IAD iad_4, IAD iad_5){
    rear     = false;
    left     = false;
    right    = false;
    forwardL = false;
    forwardR = false;
    output[0] = rear;
    output[1] = left;
    output[2] = forwardL;
    output[3] = right;
    output[4] = forwardR;
    iad1 = iad_1;
    iad2 = iad_2;
    iad3 = iad_3;
    iad4 = iad_4;
    iad5 = iad_5;
  }

  //Execute OHD
  public void execute(){
    readDataFromAllIAD();
  }

  //Read input-data and set output-data
  private void readDataFromAllIAD(){
    rear     = iad1.getData();
    left     = iad2.getData();
    forwardL = iad3.getData();
    right    = iad4.getData();
    forwardR = iad5.getData();
    output[0] = rear;
    output[1] = left;
    output[2] = forwardL;
    output[3] = right;
    output[4] = forwardR;
  }

  //Give output-data
  public boolean[] getOutput(){
    return output;
  }
}
