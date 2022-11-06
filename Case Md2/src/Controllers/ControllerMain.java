package Controllers;

import Dichvu.DichvuAcc;
import Dichvu.DichvuGame;
import IO.ReadandWrite;
import models.Account;

public class ControllerMain {
    public ControllerLogin controllerLogin;
    public ControllerMenu  controllerMenu = new ControllerMenu();
    public ControllersAcc controllersAcc;
    ReadandWrite<Account> accountReadandWrite = new ReadandWrite<>();
    public ControllerMain(){
        controllersAcc = new ControllersAcc();
        controllerLogin = new ControllerLogin();
    }
    public void menu(){
        while (true){
            int choice = controllerLogin.loginView.menuLogin();
            switch (choice){
                case 1->choiceLogin();
                case 2->controllerLogin.choiceRegister();
                case 0->{
                    System.out.println("Thoát");
                    System.exit(0);
                }
                default -> System.err.println("Chọn lại");
            }

        }
    }
    public void choiceLogin(){
        Account admin = new Account("Admin","Admin","Vuong","Ankv20@gmail.com","admin");
        controllerLogin.dichvuAcc.addAcc(admin);
        if (controllerLogin.dichvuAcc.login()){
            System.out.println("Đăng nhập thành công");
            int choice = -1;
            if (DichvuAcc.account.getRights().equals("admin")){
                while (choice != 0 ){
                    System.out.println("Chào"+DichvuAcc.account.getName() +"!!");
                    choice = controllerMenu.menuMainView.menuAdmin();
                    switch (choice){
                        case 1:
                            DichvuGame.show();
                            break;
                        case 2:
                            DichvuGame.add();
                            break;
                        case 3:
                            DichvuGame.update();
                            break;
                        case 4:
                            DichvuGame.delete();
                            break;
                        case 5:
                            DichvuGame.sort();
                            break;
                        case 6:
                            DichvuGame.SearchByName();
                            break;
                        case 7:
                            controllersAcc.choiceAcc();
                            break;
                        case 0:{
                            System.out.println("Dăng xuất ! Biến"+ DichvuAcc.account.getName());
                            accountReadandWrite.write(DichvuAcc.accounts,"src/File/game.csv");
                        }
                        default:
                            System.err.println("Chọn lại! Số bạn ơi");
                    }
                }
            }else {
                while (true){
                    System.out.println("Hi!"+DichvuAcc.account.getName()+"!!!!!");
                    choice = controllerMenu.menuMainView.menuUse();
                    switch (choice){
                        case 1-> DichvuGame.show();
                        case 2-> DichvuGame.sort();
                        case 3-> DichvuGame.SearchByName();
                        case 0->{
                            System.out.println("Dăng xuất ! Biến"+ DichvuAcc.account.getName());
                            accountReadandWrite.write(DichvuAcc.accounts,"src/File/game.csv");
                            return;
                        }
                        default->
                            System.err.println("Chọn lại! Số bạn ơi");
                    }
                }
            }
        }
    }
}
