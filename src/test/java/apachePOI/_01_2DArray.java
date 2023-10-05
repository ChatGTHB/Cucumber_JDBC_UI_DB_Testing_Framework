package apachePOI;

public class _01_2DArray {
    public static void main(String[] args) {
        String[][] zoo = {
                {"Lion", "1"},
                {"Tiger", "2"},
                {"Elephant", "3", "1"},
                {"Monkey", "4"}
        };

        System.out.println("--------------------------------");
        System.out.println(zoo[2][0]);
        System.out.println(zoo[2][1]);
        System.out.println("--------------------------------");

        for (int i = 0; i < zoo.length; i++) {
            for (int j = 0; j < zoo[i].length; j++) {
                System.out.print(zoo[i][j] + " ");
            }
            System.out.println();
        }
    }
}
