package lesson8.homework;

public class Cat extends PredatorAnimal {

    //1) если я сделал конструктор класса Cat приватным то видим что не можем создать объект Cat в другом классе
    private Cat(String name, String color, int age, String gender, boolean hasFur) {
        super(name, color, age, gender, hasFur);
    }

    // но как тогда сделать экземпляр Cat? Ведь если не будет его, то и работать нам будет впринципе
    // не с чем (вызывать методы еды и голоса без самого Барсика не вайб, хочу сделать Барсика!)
    // в самом классе то могу, а вот вне его - нет (смотреть пункт 1)
    Cat catik = new Cat("Anasi", "Black", 1, "Female", false);

    // шо я делаю: делаю отдельный статический метод специально только для создания экземпляра Cat и создаю в нём барсика
    public static Cat createBarsik(String name, String color, int age, String gender, boolean hasFur) {
        return new Cat(name, color, age, gender, hasFur);
    }

    // для того чтобы вызывать getVoice and getFood принадлежащие Cat я могу юзануть туже привелегию public static
    // методов и в них закинуть дефолтные методы
    public static void getBarsikVoice(Cat barsik) {
        barsik.getVoice();
        System.out.println("\t\tBarsik meows so cool!");
    }
    public static void getBarsikFood(Cat barsik) {
        barsik.getFood();
    }


    @Override
    public void getVoice() {
        System.out.println("\t\tThe Cat MEOWS!");
    }

    @Override
    public void getFood() {
        super.getFoodForAsterisk();
    }

    @Override
    public void feed(String food) {
        if (food.equals("Meat") || food.equals("Fish")) {
            System.out.println("The Cat is happily eating " + food + "!");
        } else {
            System.out.println("Cats do not eat " + food + ". They prefer meat and fish!");
        }
    }
}
