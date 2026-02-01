class Coffee{
    String name;

    public void brewing(){
        System.out.println(this.name);
    }
}

class EtiopiaAmericano extends Coffee{

    public EtiopiaAmericano(){
        super();
        super.name = "EtiopiaAmericano";
    }
}

class KenyaAmericano extends Coffee{
    public KenyaAmericano(){
        super();
        super.name = "KenyaAmericano";
    }
}

class BrazilAmericano extends Coffee{
    public BrazilAmericano(){
        super();
        super.name = "BrazilAmericano";
    }
}
class HawaiiAmericano extends Coffee{
    public HawaiiAmericano(){
        super();
        super.name = "HawaiiAmericano";
    }
}

class Latte extends Coffee{
    public Latte(Coffee cof){
        super();
        super.name = cof.name + " Adding Milk ";
    }
}
class Mocha extends Coffee{
    public Mocha(Coffee c){
        super();
        super.name = c.name + " Adding Mocha Syrup ";
    }
}
class WhippedCream extends Coffee{
    public WhippedCream(Coffee c){
        super();
        super.name = c.name + " Adding WhippedCream ";
    }
}

public class CoffeeTest {

    public static void main(String[] args) {

        Coffee etiopiaAmericano = new EtiopiaAmericano();
        etiopiaAmericano.brewing();
        System.out.println();

        Coffee kenyaAmericano = new KenyaAmericano();
        kenyaAmericano.brewing();
        System.out.println();

        Coffee kenyaLatte = new Latte(kenyaAmericano);
        kenyaLatte.brewing();
        System.out.println();

        Coffee brazilMocha = new Mocha(new Latte(new BrazilAmericano()));
        brazilMocha.brewing();
        System.out.println();

        Coffee hawaiiWhippedMocha =
                new WhippedCream(new Mocha(new Latte( new HawaiiAmericano())));
        hawaiiWhippedMocha.brewing();
        System.out.println();

    }
}