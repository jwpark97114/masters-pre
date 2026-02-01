import java.util.ArrayList;
import java.util.Random;

class State{
    int money;
    int[] fruits;

    public State(){
        this.money = 1000;
        this.fruits = new int[] {0,0,0};
    }

    public State(State st){
        this.money = st.money;
        this.fruits = st.fruits.clone();
    }
}

class Gamer{
    State state = new State();
    Memento mem;

    public void addHundredMoney(){
        this.state.money += 100;
    }

    public void halfMoney(){
        this.state.money = this.state.money / 2;
    }

    public void addFruit(String fruit){
        int idx = switch (fruit){
            case "Apple" -> 0;
            case "Shine Muscat" ->1;
            default -> 2;
        };

        this.state.fruits[idx] += 1;
    }

    public int currentMoney(){
        return this.state.money;
    }

    public Memento createMemento(){
        return new Memento(this.state);
    }

    public void restoreMemento(Memento m){
        this.state = new State(m.getState());
    }

    public boolean shouldRestore(Memento m){
        if (this.state.money < (m.getState().money / 2)){
            return true;
        }
        return false;
    }

    public void printState(){
        System.out.println("Current Money : "+ this.state.money);
        System.out.println("Fruit Count : "+ "Apple : "+ this.state.fruits[0] + ", Shine Muscat : "+this.state.fruits[1] + ", Tangerine : "+this.state.fruits[2]);
    }

}

class Memento{

    State savedState;

    public Memento(State state){
        this.savedState = new State(state);
    }

    public State getState(){
        return this.savedState;
    }

    public void setState(State s){
        this.savedState = new State(s);
    }

}


public class N3 {
    public static void main(String[] args) {
        String[] fruits = {"Apple","Shine Muscat","Tangerine"};
        int fruitTurn = 0;

        Gamer newGamer = new Gamer();
        Memento save = newGamer.createMemento();

        while(newGamer.currentMoney() > 0){
            Random randoDice = new Random();
            int rolledDice = randoDice.nextInt(1,7);
            switch(rolledDice){
                case 1,3:
                    System.out.println("Gained 100!");
                    newGamer.addHundredMoney();
                    save = newGamer.createMemento();
                    System.out.println("Progress Saved");
                    break;
                case 2,4:
                    System.out.println("Lost half of your money!");
                    newGamer.halfMoney();
                    if(newGamer.shouldRestore(save)){
                        newGamer.restoreMemento(save);
                        System.out.println("Restored Saved profile!");
                    }
                    break;
                default:
                    System.out.println("Gained a fruit : " + fruits[fruitTurn]);
                    newGamer.addFruit(fruits[fruitTurn]);
                    fruitTurn = (fruitTurn + 1) % 3;

            }
            newGamer.printState();
        }

    }
}
