package view;


import model.DeviceForToys;
import model.Toy;
import presenter.Presenter;

import java.util.Random;
import java.util.Scanner;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        boolean flagStart = true;
        while (flagStart){
            System.out.println("Выберите пункт меню:\n" +
                    "1. Получить игрушку\n" +
                    "2. Меню для редакции\n" +
                    "3. Выход");
            String data = scanner.nextLine();
            switch (data){
                case "1":
                    roulette();
                    break;
                case "2":
                    redaction();
                    break;
                case "3":
                    flagStart = false;
                    break;
                default:
                    inputError();
                    break;
            }
        }

    }

    private void roulette() {
        presenter.roulette();
    }


    public void redaction() {
        boolean flag = true;
        while (flag){
            System.out.println("Выберите пункт меню:\n" +
                    "1. Показать весь список игрушек\n" +
                    "2. Сохранить\n" +
                    "3. Прочитать файл\n" +
                    "4. Добавить игрушку\n"+
                    "5. Изменить запись\n" +
                    "6. выход");
            String data = scanner.nextLine();
            switch (data){
                case "1":
                    getToyInfo();
                    break;
                case "2":
                    save();
                    break;
                case "3":
                    read();
                    getToyInfo();
                    break;
                case "4":
                    addToy();
                    break;
                case "5":
                    change();
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    inputError();
                    break;
            }
        }
    }

    private void addToy() {
        System.out.println("Введите названии игрушки");
        String name = scanner.nextLine();
        System.out.println("Введите кол-во");
        String count = scanner.nextLine();
        int intCount = Integer.parseInt(count);
        presenter.addToy(name,intCount);
    }

    private void change() {/*Кол-во напрямую зависит на вероятность, каких ээлементов больше по
        отношению к другим у того шанс выпасть больше, поэтому я не понимаю как
        без изменения кол-во можно изменить вероятность*/
        getToyInfo();
        System.out.println("Введите номер записи");
        String index = scanner.nextLine();
        Toy toy = presenter.change(index);
        System.out.println(toy);
        boolean flagChange = true;
        while (flagChange){
            System.out.println("Выберите пункт меню:\n" +
                    "1. Изменить кол-во\n" +
                    "3. Выход");
            String data = scanner.nextLine();
            switch (data){
                case "1":
                    getToyInfo();
                    break;
                case "2":
                    flagChange = false;
                    break;
                default:
                    inputError();
                    break;
            }
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void save(){
        String name = inputFile("Введите имя файла");
        presenter.save(name);
    }
    public void read(){
        String name = inputFile("Введите имя файла");
        presenter.read(name);
    }

    public String inputFile(String mesage){
        System.out.println(mesage);
        String name = scanner.nextLine();
        name += ".out";
        return name;
    }

    public void getToyInfo() {
        presenter.getToyInfo();
    }
}
