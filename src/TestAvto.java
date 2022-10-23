package lab3;

public class TestAvto {
    public static void main(String[] args) {
        Avto car1 = new Avto("Lexus");
        Avto car2 = new Avto("Mercedes-Benz");
        Avto car3 = new Avto("Porsche");

        VectorAvto list = new VectorAvto(5);

        list.add(car1);
        list.add(car2);
        list.add(car3);

        System.out.println(list.indexOf(car1));

    }
}
