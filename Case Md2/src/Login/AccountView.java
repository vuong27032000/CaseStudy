package Login;

import java.util.Scanner;

public class AccountView {
    Scanner scanner = new Scanner(System.in);

    public int menuAccount(){
        while (true){
            try {
                String menuAcc = """
                        Menu
                        1. Thêm tai khoản
                        2. Xóa tài khoản
                        3. Sửa tài khoản
                        4. Hiển thị tài khoản
                        0. Thoát
                        """;
                System.out.println(menuAcc);
            }catch (Exception e){
                System.err.println("Nhập số số số.Bị ngu ag");
            }
        }
    }
}
