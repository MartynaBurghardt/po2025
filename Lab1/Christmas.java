public class Choinka {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("java Choinka ");
            return;
        }

        int wysokosc = Integer.parseInt(args[0]);

        for (int i = 1; i <= wysokosc; i++) {
            for (int j = 0; j < wysokosc - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
