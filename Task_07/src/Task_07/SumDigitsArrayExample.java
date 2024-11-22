package Task_07;

public class SumDigitsArrayExample {
    public static void main(String[] args) {
        SumDigitsArray sumDigitsArray = new SumDigitsArray();
        sumDigitsArray.fillArray();
        long singleThreadTime = sumDigitsArray.singleThreadSum();
        long multiThreadTime = sumDigitsArray.multiThreadSum();
        System.out.println("Різниця у часі (багатопоточний швидше на): " +
                (singleThreadTime - multiThreadTime) + " мс");
    }
}
