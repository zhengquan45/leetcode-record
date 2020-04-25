package leetcode.editor;

public class Base {

    public static void main(String[] args) {
        System.out.println("for:");
        for (int i = 0; i < 10; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("forr:");
        for (int i = 10; i > 0; i--) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("while:");
        int k = 0;
        while (k < 10) {
            System.out.print(k++ +" ");
        }
    }
}
