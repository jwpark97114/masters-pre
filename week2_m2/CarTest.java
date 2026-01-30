class Car{
    private int number;

    public Car(int num){
        this.number = num;
    }

    public int showCarNumber(){
        return this.number;
    }
}

class HyundaiFactory{
    private static final HyundaiFactory onlyFactory = new HyundaiFactory();
    private int nextNumber = 1000;

    public HyundaiFactory(){};

    public static HyundaiFactory getFactory(){
        return onlyFactory;
    }

    public Car createCar(){
        Car newCar = new Car(nextNumber);
        this.nextNumber++;
        return newCar;
    }
}


public class CarTest{



    public static void main(String[] args) {
        HyundaiFactory factory = HyundaiFactory.getFactory();
        Car myCar = factory.createCar();
        Car yourCar = factory.createCar();

        System.out.println("첫번째 차 번호는" +myCar.showCarNumber());
        System.out.println("두번째 차 번호는" +yourCar.showCarNumber());
    }
}