public class Main {
    public static void main(String[] args) {
        MyDate date = new MyDate(2002, 10, 12);
        System.out.println(date.getNextDate());
        //System.out.println(date.addYear(1));
        System.out.println(date.addMonth(5));
        System.out.println(date.addDay(6));
    }
}