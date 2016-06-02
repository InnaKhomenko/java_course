package ru.stqa.pft.t.uk.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.t.uk.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Inna on 12.05.2016.
 */
public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("inna@doubledmarketing.com", "qwerty12345"));
        assertTrue(session.isLoggedInAs("inna@doubledmarketing.com"));
    }
}
