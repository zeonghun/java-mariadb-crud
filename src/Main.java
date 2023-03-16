import java.util.Scanner;

/**
 * @brief (non-javadoc)
 * 
 * @author zeonghun
 * @since 230316
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Create c = new Create();
        Update u = new Update();
        Delete d = new Delete();
        Read r = new Read();
        while (true) {
            System.out.println();
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Read");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("번호 입력: ");
            int num = sc.nextInt();
            System.out.println();
            switch (num) {
                case 1:
                    c.insert();
                    break;
                case 2:
                    u.update();
                    break;
                case 3:
                    d.delete();
                    break;
                case 4:
                    r.read();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("1~5중에서 입력하세요");
            }
            if (num == 5)
                break;
        }
        sc.close();
    }
}
