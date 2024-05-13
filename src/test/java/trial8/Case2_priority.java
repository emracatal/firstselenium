package trial8;

import org.testng.annotations.Test;

public class Case2_priority {
    @Test(priority = 1)
    public void test01(){
        System.out.println("test 01");
    }

    @Test(priority = -30)
    public void test02(){
        System.out.println("test 02");
    }

    @Test()
    public void test03(){
        System.out.println("test 03");
    }
}
