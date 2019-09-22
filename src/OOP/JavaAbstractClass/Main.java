package OOP.JavaAbstractClass;

import java.util.Scanner;

abstract class Book {
    String title;

    String getTitle() {
        return title;
    }

    abstract void setTitle(String s);
}

class MyBook extends Book {
    String title;

    @Override
    public void setTitle(String title) {
        super.title = title;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: " + new_novel.getTitle());
        sc.close();
    }
}