package hooks;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.DriverFactory;

public class Hooks {

   @Before
   public void setUp(Scenario scenario){
       System.out.println("Starting:" + scenario.getName());
       DriverFactory.initializeDriver();
   }
   @After
    public void tearDown(Scenario scenario) {
       if (scenario.isFailed()){
           System.out.println("Failed:" + scenario.getName());
       }
       else {
           System.out.println("Passed:" + scenario.getName());
       }
       DriverFactory.quitDriver();
    }
}
