package lr4;

public class Lr4_Example10 {
	public static int m() {
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            return 20;
        }
        // лучше return finally() 
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
