class Member{
    String name;
    float discount = 0;
    float point = 0;
    int purchaseSum;
    int hoursStayed;
    int parkingFee = 3000;

    public Member(String n, int p, int h){
        this.name = n;
        this.purchaseSum =p;
        this.hoursStayed = h;
    }

    public void print(){
        System.out.printf(this.name + "님의 지불 금액은 %d 원이고, 적립 포인트는 %d점 입니다.\n",(int)(this.purchaseSum - (this.purchaseSum * this.discount)),(int)(this.purchaseSum*this.point));
        System.out.printf("주차 요금은 %d 원 입니다.\n", this.parkingFee * this.hoursStayed);
    }
}
class Red extends Member{
    public Red(String n, int p, int h){
        super(n,p,h);
        super.point = 0.0f;

    }
}

class Platinum extends Member{
    public Platinum(String n, int p, int h){
        super(n,p,h);
        super.discount = 0.05f;
        super.parkingFee = 1000;
        super.point = 0.05f;

    }
}

class Diamond extends Member{
    public Diamond(String n, int p, int h){
        super(n,p,h);
        super.discount = 0.1f;
        super.parkingFee = 0;
        super.point = 0.1f;
    }
}

public class N1 {
    public static void main(String[] args) {
        Member james = new Red("James",10000,2);
        Member tomas = new Red("Tomas",30000,2);
        Member ed = new Platinum("Edward",10000,2);
        Member percy = new Platinum("Percy",30000,2);
        Member eli = new Diamond("Elizabet",30000,2);

        james.print();
        tomas.print();
        ed.print();
        percy.print();
        eli.print();

    }

}
