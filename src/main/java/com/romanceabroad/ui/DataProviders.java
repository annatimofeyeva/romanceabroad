package com.romanceabroad.ui;

import org.testng.annotations.DataProvider;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataProviders {

    @DataProvider(name = "Registration")
    public static Object[][] testRegisration() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("Registration.csv")).stream().forEach(s -> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @DataProvider(name = "Registration2")
    public static Object[][] testRegistration2() {
        return new Object[][]{
                {Data.email1, Data.userName, true},
//                {Data.email2, Data.userName, false},
//                {Data.email3, Data.userName, true}
        };
    }

    @DataProvider(name = "SignIn")
    public static Object[][] testSignIn() {
        return new Object[][]{
                // email is not valid
                {"Donna.gmail.com", "123456789", false, true},
                {"Donna!gmail.com", "123456789", false, true},
//                {"Donna%%gmail.com", "123456789", false, true},
//                {"D", "123456789", false, true},
//                {"donna111111111111)gmail.com", "123456789", false, true},
//                {"*********", "123456789", false, true},
//                {"gmail.com", "123456789", false, true},
//                {"DONNA", "123456789", false, true},
//                {"DONNA.GMAIL@COM", "123456789", false, true},
//                {"DONNA.DONNA@GMAIL>COM", "123456789", false, true},
//                {"123456789", "123456789", false, true},
//                //password is not valid
//                {"donna@gmail.com", " ", true, false},
//                {"donna@gmail.com", "!", true, false},
//                {"donna@gmail.com", "@@@@@@@@@", true, false},
//                {"donna@gmail.com", "@%%^BFGG&*FN", true, false},
        };
    }


    @DataProvider(name="Gifts Search")
    public static Object[][] testGifts() throws Exception {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("SearchGifts.cvs")).stream().forEach(s-> {
            String[] data = s.split(",");
            out.add(new Object[]{data[0]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @DataProvider(name = "Search")
    public static Object[][] testSearchFeatures() {
        return new Object[][]{
                {"18", "40", "Default"},
                {"19", "44", "Name"},
                {"30", "40", "Views"},
                {"60", "80", "Registration date"},
        };
    }
}
