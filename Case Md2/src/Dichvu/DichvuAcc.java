package Dichvu;

import IO.ReadandWrite;
import Regex.Validate;
import models.Account;

import java.util.ArrayList;

public class DichvuAcc {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static Account account;
    ReadandWrite<Account> readandWrite = new ReadandWrite<>();

    public DichvuAcc() {
        accounts =readandWrite.read("src/File/account.csv");
    }
    public void addAcc(Account account){
        for (Account acc :accounts){
            if (acc.getUsername().equals(account.getUsername()))
                return;
        }
        accounts.add(account);
        System.out.println("Add acc"+account.getUsername()+"success");
        readandWrite.write(accounts,"src/File/account.csv");
    }
    public boolean login(){
        System.out.println("Nhập tài khoản :(Gì cũng được (5-20 ký tự))");
        String user = Validate.validateString(Validate.RegexAcc);
        System.out.println("Nhập mật khẩu :((8-16 ký tự) Nhé!");
        String pass = Validate.validateString(Validate.RegexAcc);

        for (Account acc : accounts){
            if (acc.getUsername().equals(user) && acc.getPassword().equals(pass)){
                DichvuAcc.account =acc;
                return true;
            }
        }
        return false;
    }
    public Account createAcc(){
        String user;
        System.err.println("Nhập tên");
        String name = Validate.validateString(Validate.RegexString);
        while (true){
            System.out.println("Nhập tài khuản");
            user = Validate.validateString(Validate.RegexString);
            if (checkAcc(user)){
                break;
            }else {
                System.err.println("Đổi cái khác đi cái này có rồi");
            }
        }
        System.out.println("Nhập mật khẩu");
        String pass = Validate.validateString(Validate.RegexString);
        System.out.println("Nhập email(abc@gmail.com)");
        String email = Validate.validateString(Validate.RegexEmail);
        return new Account(name,user,pass,email,"user");
    }
    public Account createEditAcc(){
        String user;
        System.out.println("Nhập tên");
        String name = Validate.validateString(Validate.RegexString);
        System.out.println("Nhập mật khẩu");
        user = Validate.validateString(Validate.RegexAcc);
        System.out.println("Nhập mật khẩu");
        String pass = Validate.validateString(Validate.RegexAcc);
        System.out.println("Nhập mật khẩu");
        String email = Validate.validateString(Validate.RegexEmail);
        return new Account(name,user,pass,email,"user");
    }

    private boolean checkAcc(String userName) {
        for (Account ac : accounts){
            if (ac.getUsername().equals(userName)){
                return false;
            }
        }
        return true;
    }
    public int searchAcc(){
        System.out.println("Nhập tên muốn tìm:");
        String user = Validate.validateString(Validate.RegexAcc);
        for (int i = 0 ; i < accounts.size(); i++){
            if (accounts.get(i).getUsername().equals(user))
                return i;
        }
        return -1;
    }
    public void deleteAcc(int index){
        if (index!=-1){
            accounts.set(index,createEditAcc());
            System.err.println("Thàn công");
            readandWrite.write(accounts,"src/File/account.csv");
        }else {
            System.out.println("Bị ngu ag acc này k tồn tại");
        }
    }
    public void editAcc(int index){
        if (index!=-1){
            accounts.set(index,createEditAcc());
            System.out.println("Đã sửa");
            readandWrite.write(accounts,"src/File/account.csv");
        }else {
            System.out.println("Bị ngu ag acc này k tồn tại");
        }
    }
    public void displayAcc(){
        System.out.println("--------------ACCOUNT------------");
        System.out.printf("|-15%","name","user","pass","email","rights");
        System.out.println();
        System.out.println("__________________________________");
        for (Account acc : accounts){
            System.out.printf("|-15%",acc.getName(),acc.getUsername(),acc.getPassword(),acc.getEmail(),acc.getRights());
            System.out.println();
            System.out.println("__________________________________");
        }
    }
}
