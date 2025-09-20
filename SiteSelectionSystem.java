package com.example.weatherapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SiteSelectionSystem {
    private Scanner scanner;

    public SiteSelectionSystem(Scanner scanner) {
        this.scanner = scanner;
    }
    public int selectOption() {
        while (true) {
            System.out.println("Делай выбор: ");
            System.out.println("1. Узнать погоду");
            System.out.println("2. Выход");
            String input = scanner.nextLine();

            if (input.contains(" ")) {
                System.out.println("Пиши без пробела");
                continue;
            }
            try {
                int choice = Integer.parseInt(input);
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("ТЫ ТУПОЙ 1 ИЛИ 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("ой даун");
            }
        }
    }
}

