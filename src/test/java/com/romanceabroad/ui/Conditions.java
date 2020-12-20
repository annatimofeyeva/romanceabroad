package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions extends BaseUI {
    @Test
    public void test1() {
        String fruit1 = "orange";
        String fruit2 = "kiwi";
        String fruit3 = "";
        String fruit4 = "";
        if (fruit2.contains("kiwi")) {
            System.out.println("We can find out our fruit 1!");
        }
        if (fruit1.contains("orange")) {
            System.out.println("We can find our fruit 2!");
        } else {
            System.out.println(" We can't find fruit!");
        }
//
//        if(fruit3.contains("kiwi")) {
//            System.out.println("We can find out our fruit 1!");
//        }
//        if(fruit4.contains("orange")) {
//            System.out.println("We can find our fruit 2!");
//        }
//        else {
//            Assert.fail("We can not find any fruit!");
//        }

        if (fruit2.contains("kiwi") && fruit2.contains("k")) {
            System.out.println("We can find out our fruit 1!");
        }

        if (fruit2.contains("kiwi") || fruit2.contains("k")) {
            System.out.println("We can find out our fruit 1!");
        }

        if (fruit2.contains("kiwi") || fruit2.contains("orange")) {
            System.out.println("We can find out our fruit 1!");
        }
    }

    @Test
    public void test2() {
        int number1 = 10;
        int number2 = 10;
        int sum;
//        if(number==15) {
//            System.out.println("I can find valid number");
        if (number1 == 10 + 5) {
            sum = 95 + 100;
        }
        if (number1 == number2) {
            sum = 95 + 95;
        } else {
            sum = 100 - 95;
        }
        System.out.println(sum);
    }

    @Test
    public void test3() {
        boolean requirement = true;
        //boolean requirement = false;
//       if(!requirement) {
//            System.out.println("");
//        }

        if (requirement) {
            System.out.println("Boolean is true!");
        } else {
            Assert.fail("Boolean is false");
        }
    }

    @Test
    public void test4() {
        WebElement tabSearch = driver.findElement(Locators.LINK_SEARCH);

//        if(tabSearch.getText().contains("PRETTY WOMEN")) {
//            tabSearch.click();
//        }
//        if(tabSearch.getText().contains("PRETTY WOMEN")) {
//            tabSearch.click();
//        }
//        if(tabSearch.getText().contains("PRETTY WOMEN")) {
//            tabSearch.click();
//        }
//        if(tabSearch.getText().contains("PRETTY WOMEN")) {
//            tabSearch.click();
//        }else {
//            Assert.fail("We can't find Pretty Woman tab");
//        }
//
//        if(tabSearch.isDisplayed()) {
//            tabSearch.click()

        if (driver.findElement(Locators.LINK_SEARCH).getText().contains("PRETTY WOMEN")) {
            tabSearch.click();
        } else {
            Assert.fail("We can't find Pretty Woman tab");
        }
//
//        if(tabSearch.getText().contains("PRETTY WOMEN")) {
//            tabSearch.click();
//        }else {
//            Assert.fail("We can't find Pretty Woman tab");
//        }
    }


    @Test
    public void test6() {
        List<String> fruits = new ArrayList<>(Arrays.asList("kiwi", "orange", "melon"));
        if (fruits.contains("orange")) {
            System.out.println(fruits);
        }
//        String firstFruit = (fruits.get(0));
//        System.out.println(firstFruit);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 10, 15));
//        int sum = numbers.get(1) + numbers.get(2);
//        System.out.println(sum);

        for (int i = 0; i < 5; i++) {
            System.out.println("Hi, guys!");
        }

        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        System.out.println(links.size());
        for (int i = 0; i < links.size(); i++) {
//            WebElement elementOfList = links.get(i);
//            String info = elementOfList.getText();
//            System.out.println(info);
            System.out.println(links.get(i).getText());
            links.get(i).click();
            driver.get(Data.mainUrl);
            links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        }
    }

    @Test
    public void test7() {
        List<Integer> crunchifyList1 = new ArrayList<>(Arrays.asList(5, 10, 15));
        System.out.println("What inside the list:" + crunchifyList1);
        crunchifyList1.add(20);
        System.out.println(crunchifyList1.size());
        for (int i = 0; i < crunchifyList1.size(); i++) {
            int element = crunchifyList1.get(i);
            System.out.println(element);
        }
    }

    @Test
    public void test8() {
        String phrase = "Melon is inside list";
        List<String> crunchifyList1 = new ArrayList<>(Arrays.asList("apple", "kiwi", phrase));
        for (int i = 0; i < crunchifyList1.size(); i++) {
            String element = crunchifyList1.get(i);
            System.out.println(i + " iteration");
            if (element.contains("apple")) {
                System.out.println("Apple");
                //break;
            }
            if (element.contains("i")) {
                System.out.println("III");
            }

            if (element.contains("Me")) {
                System.out.println(phrase);
                continue;
            }
            if (element.contains("orange")) {
                System.out.println("Orange");
            } else {
                System.out.println("Invalid loop");
            }
        }
    }
}

