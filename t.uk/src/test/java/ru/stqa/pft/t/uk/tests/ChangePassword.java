package ru.stqa.pft.t.uk.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.t.uk.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
/**
 * Created by Inna on 01.06.2016.
 */
public class ChangePassword extends  TestBase{

    @Test

    public void testChangePass() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("inna@doubledmarketing.com", "qwerty12345"));
        assertTrue(session.isLoggedInAs("inna@doubledmarketing.com"));
    }
}
