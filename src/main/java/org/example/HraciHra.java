package org.example;

import java.util.Random;
import java.util.Scanner;

public class HraciHra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // načtení vstupu od uživatele z konzole
        Random random = new Random();  // random umožňuje generovat náhodná čísla

        System.out.println("Vítejte ve hře Hádej číslo!");

        while (true) {    // nekonečná smyčka, dokud není ukončena
            System.out.print("Zvolte obtížnost (lehká, střední, těžká): ");
            String obtiznost = scanner.nextLine().toLowerCase();  // načtení řádku textu z konzole a převod na malá písmena

            int horniMez;   // nastavení obtížnosti a horní meze
            switch (obtiznost) {
                case "lehká":
                    horniMez = 10;
                    break;
                case "střední":
                    horniMez = 50;
                    break;
                case "těžká":
                    horniMez = 100;
                    break;
                default:
                    System.out.println("Neplatná obtížnost. Zkuste to znovu.");
                    continue;
            }

            int cisloKUhadnuti = random.nextInt(horniMez) + 1;  //generuje náhodné číslo od 0 do horní meze 1 a přičtením 1 se zajistí, že číslo bude v rozmezí od 1 do horní mez
            int pokusy = 0; // uchování počtů pokusů
            boolean uhodnuto = false;  // indikování zda li hráč ještě uhodl číslo

            System.out.println("Myslím si číslo mezi 1 a " + horniMez + ". Zkus ho uhodnout!"); // vypsaání informací o rozmezí čísel, které může hádat

            while (!uhodnuto) {   //herní smyčka
                System.out.print("Zadejte svůj tip: ");
                int tipHrace;

                try {
                    tipHrace = Integer.parseInt(scanner.nextLine());   //načtení vstupu od hráče jako řetězec pomocí scanner A následně se řetězec převede na celé číslo pomocí parseInt
                } catch (NumberFormatException e) {  // zabezpečení vyjímky, aby nezadal špatný vstup(např. text místo čísla)
                    System.out.println("Neplatný vstup. Zadejte celé číslo.");
                    continue;
                }

                pokusy++;  // zvýšení pokusů o 1 s každým novým tipem

                if (tipHrace == cisloKUhadnuti) {   // vypsání podmínek podle zadání čísla od uživatele
                    System.out.println("Skvělé! Uhodli jste číslo " + cisloKUhadnuti + " ve " + pokusy + " pokusech.");
                    uhodnuto = true;
                } else if (tipHrace < cisloKUhadnuti) {
                    System.out.println("Tip je menší než hledané číslo. Zkuste znovu.");
                } else {
                    System.out.println("Tip je větší než hledané číslo. Zkuste znovu.");
                }
            }

            System.out.print("Chcete hrát znovu? (ano/ne): ");
            String volba = scanner.nextLine();  // načtení odpovědi hráče

            if (!volba.toLowerCase().equals("ano")) {  // odpověď hráče převede na malá písmena a pokud odpověď je ano, tak se provede příkaz break a hra se ukončí
                break;
            }
        }

        System.out.println("Děkujeme za hraní!");
        scanner.close();
    }
}