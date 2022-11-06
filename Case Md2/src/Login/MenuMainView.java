package Login;

import java.util.Scanner;

public class MenuMainView {
    Scanner scanner = new Scanner(System.in);

    public int menuAdmin(){
        while (true){
            try {
                String menuAdmin = """
                        Mời chon
                        1.Xem danh sách
                        2.Thêm
                        3.Sửa
                        4.Xóa
                        5.Sắp Xếp
                        6.Tìm kiếm
                        7.Thông tin tài khoản
                        0.Đăng xuất
                        """;
                System.out.println(menuAdmin);
            }catch (Exception e){
                System.err.println("Nhập số số số.Bị ngu ag");
            }
        }
    }
    public int menuUse(){
        while (true){
            try {
                String menuUse = """
                        Mời chọn
                        1.Hiển thị
                        2.Sắp xếp
                        3.Tìm kiếm
                        4.Chơi thử
                        0.Thoát
                        """;
                System.out.println(menuUse);
            }catch (Exception e){
                System.err.println("Nhập số số số.Bị ngu ag");
            }
        }
    }
}
