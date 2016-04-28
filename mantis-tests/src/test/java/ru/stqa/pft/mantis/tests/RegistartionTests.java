package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by Inna on 28.04.2016.
 */
public class RegistartionTests extends TestBase{

    @Test
    public void testRegistartion(){
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
