package lesson6.homework.ATM.task;

public class MyMainATM {
    public static void main(String[] args) {

        ATM atm = new ATM(10, 10, 10);

        System.out.println("\n\t\t\tATM Belarusbank");
        System.out.println("=======================================");
        atm.getATMsOperation();

    }
}
