//IAD
package edu.holger;

public class IAD {
  private int input1;      //input from first IHD
  private int IHD_limit;   //limit for IHD data seen as TRUE or FALSE
  private boolean output1; //TRUE if input1 > IHD_limit
  private IHD ihd1;        //first connected IHD

    //Initialize IAD, connect with 1 IHD
  public void initialize(IHD ihd_1, int limit){
    ihd1 = ihd_1;
    input1 = 0;
    output1 = false;
    IHD_limit = limit;
  }

  //Execute IHD
  public void execute(){
    this.analyzeData();
  }

  //Analyze data from connected IHD(s) and set output-data
  private void analyzeData(){
    input1 = ihd1.getMean();
    output1 = (input1 > IHD_limit);
  }

  //Give output-data
  public boolean getData() {
    return output1;
  }
}
