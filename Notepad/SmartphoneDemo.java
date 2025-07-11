class Smartphone{
 String brand;
 double screenSize;
 int batteryLife;
 public void displayPhoneSettings(){
  System.out.println("Brand: "+ brand);
  System.out.println("Screen Size: "+screenSize);
  System.out.println("Battery Life: "+batteryLife + "%");
}
}


class SmartphoneDemo{
 public static void main(String[] args){
  Smartphone myPhone = new Smartphone();
  myPhone.brand = "Nokia";
  myPhone.screenSize = 1.2;
  myPhone.batteryLife = 100;
  myPhone.displayPhoneSettings();
   
}
}