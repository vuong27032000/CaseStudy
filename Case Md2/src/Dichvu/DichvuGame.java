package Dichvu;

import IO.ReadandWrite;
import models.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class DichvuGame {
    static ReadandWrite<Game> gameReadandWrite = new ReadandWrite<>();
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Game> games = new ArrayList<>();
    public ArrayList<Game> getGames(){
        return games;
    }
    public DichvuGame(){
        games = gameReadandWrite.read("src/File/game.csv");

    }
    public static Game infGame(){
        System.out.println("Nhập tên game:");
        String ten = scanner.nextLine();
        System.out.println("Nhập thể loại:");
        String theloai = scanner.nextLine();
        System.out.println("Nhập dung lượng");
        String dungluong = scanner.nextLine();
        System.out.println("Nhập nhà sản xuất");
        String nhasanxuat = scanner.nextLine();
        System.out.println("Nhập giá");
        double gia = 0;
        try {
            gia = Double.parseDouble(scanner.nextLine());
        }catch (Exception e){
            System.err.println("Số bạn ơi");
        }
        Game game = new Game(ten,theloai,dungluong,nhasanxuat,gia);
        System.out.println(game);
        return game;
    }
    public static void show(){
        System.out.println("--------------Thư viện------------");
        System.out.printf("| %-25s","tên","thể loại","dung lượng","Nhà sẳn xuất","giá");
        System.out.println();
        System.out.println("----------------------------------");
        for (Game game : games){
            System.out.printf("| %-25s",game.getTen(),game.getTheloai(),game.getDungluong(),game.getNhasanxuat(),game.getGia());
            System.out.println();
            System.out.println("------------------------------");
        }
    }
    public static void add(){
        Game game = infGame();
        games.add(game);
        System.out.println("Add acc"+ game.getTen()+"success");
        gameReadandWrite.write(games,"src/File/game.csv");
    }
    public static void update(){
        System.out.println("Nhập tên muốn xóa");
        String ten = scanner.nextLine();
        for (int i = 0 ; i < games.size(); i++){
            if (games.get(i).getTen().equals(ten)){
                games.remove(i);
                break;
            }
        }
        gameReadandWrite.write(games,"src/File/game.csv");
    }
    public static void delete(){
        System.out.println("Nhập tên muốn xóa");
        String ten = scanner.nextLine();
        for (int i = 0 ; i < games.size(); i++){
            if (games.get(i).getTen().equals(ten)){
                games.remove(i);
                break;
            }
        }
        gameReadandWrite.write(games,"src/File/game.csv");
    }
    public static void sort(){
        int choose = 2;
        System.out.println("1.Giá tăng dần");
        System.out.println("2.Giá giảm dần");
        System.out.println("Nhập số để lựa chọn");
        try {
            choose = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.err.println("Số bạn ơi");
        }
        switch (choose){
            case 1 -> ascending();
            case 2 -> decrease();
        }
    }
    public static void ascending(){
        Game temp;
        for (int i = 0; i < games.size(); i++){
            for (int j = i+1; j < games.size(); j++){
                if (games.get(i).getGia()>games.get(j).getGia()){
                    temp = games.get(i);
                    games.set(i,games.get(j));
                    games.set(j,temp);
                }
            }
        }
        show();
    }
    public static void decrease(){
        Game temp;
        for (int i = 0; i < games.size() - 1; i++) {
            for (int j = i + 1; j < games.size(); j++) {
                if (games.get(i).getGia() < games.get(j).getGia()) {
                    temp = games.get(i);
                    games.set(i, games.get(j));
                    games.set(j, temp);
                }
            }
        }
    }
    public static void SearchByName(){
        System.out.println("Nhập tên game muốn tìm");
        String name = scanner.nextLine();
        for (Game game : games){
            if (game.getTen().contains(name)){
                System.out.println(game);
            }
        }
    }
}
