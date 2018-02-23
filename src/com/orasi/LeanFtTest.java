package com.orasi;

import com.hp.lft.sdk.web.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import com.hp.lft.report.*;
import unittesting.*;



public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() throws GeneralLeanFtException {

        Browser browser;

        //open www.orasi.com
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.navigate("https://spine.memorialhermann.org/");
        browser.sync();

        Link Outcomes = browser.describe(Link.class, new LinkDescription.Builder()
                .tagName("A").innerText("Outcomes").build());
        Outcomes.click();

        Link ContactUs = browser.describe(Link.class, new LinkDescription.Builder()
                .tagName("A").innerText("Contact Us").index(0).build());
        ContactUs.click();

        EditField FirstName = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("text").tagName("INPUT").name("FirstName").build());
        EditField LastName = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("text").tagName("INPUT").name("LastName").build());
        EditField Email = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("email").tagName("INPUT").name("Email").index(0).build());
        EditField Phone = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .type("tel").tagName("INPUT").name("Phone").index(0).build());
        ListBox AreaOfInterest = browser.describe(ListBox.class, new ListBoxDescription.Builder()
                .id("areaofInterest").tagName("SELECT").name("areaofInterest").build());
        ListBox Insurance = browser.describe(ListBox.class, new ListBoxDescription.Builder()
                .id("reusable2").tagName("SELECT").name("reusable2").build());

        FirstName.setValue("Jean");
        LastName.setValue("Suplick");
        Phone.setValue("4693238149");
        Email.setValue("jean.suplick@orasi.com");
        AreaOfInterest.select("Other");
        Insurance.select("Medicare");


        Link Policies = browser.describe(Link.class, new LinkDescription.Builder()
                .tagName("A").innerText("Policies & Ownership").build());
        //Reporter.reportEvent("LeanFtJUnitExample", "Test Failed", Status.Failed, e);
        Verify.areEqual("POLICIES & OWNERSHIP", "POLICIES");

         //browser.close();

    }
}