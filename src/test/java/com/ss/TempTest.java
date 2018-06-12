package com.ss;

import com.ss.core.WebDriverTestBase;
import org.testng.annotations.Test;

public class TempTest extends WebDriverTestBase{
    @Test
    public void temp(){
        driver.get("https://sea.plrm.in");
    }
}
