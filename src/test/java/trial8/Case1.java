package trial8;

import org.testng.annotations.*;

public class Case1 {
    @BeforeTest
    public void bt(){
        System.out.println("before test");
    }
    @AfterTest
    public void at(){
        System.out.println("after test");
    }

    @BeforeSuite
    public void bs(){
        System.out.println("before suite");
    }
    @AfterSuite
    public void as(){
        System.out.println("after suite");
    }

    @BeforeMethod
    public void bm(){
        System.out.println("before method");
    }
    @AfterMethod
    public void am(){
        System.out.println("after method");
    }

    @Test
    public void test01(){
        System.out.println("test 01");
    }
    @Test
    public void test02(){
        System.out.println("test 02");
    }
    @Test
    public void test03(){
        System.out.println("test 03");
    }

    @BeforeClass
    public void bc(){
        System.out.println("before class");
    }
    @AfterClass
    public void ac(){
        System.out.println("after class");
    }

}
