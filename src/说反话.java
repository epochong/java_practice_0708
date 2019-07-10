import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/7/10 17:42
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class 说反话 {
    public static void reverse(String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String str = input.nextLine();
            String[] strings = str.split(" ");
            for (int i = strings.length - 1; i >= 0; i--) {
                if (i > 0) {
                    reverse(strings[i]);
                    System.out.print(" ");
                } else {
                    reverse(strings[i]);
                }
            }
        }
    }
}
