//package runners;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions
//        (
//                tags = "@SmokeTest",
//                features = {"src/test/java/featureFiles"},
//                glue = {"stepDefinitions"},
//                plugin = {"html:target/site/cucumber-pretty.html"},
//                dryRun = false
//        )
//public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
//}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class _06_TestRunnerSmokeWithPlugin {

        @CucumberOptions(
                tags = "@SmokeTest",
                features = {"src/test/java/featureFiles"},
                glue = {"stepDefinitions"},
                plugin = {},
                dryRun = false
        )
        public static class TestRunner extends AbstractTestNGCucumberTests {

                @BeforeClass(alwaysRun = true)
                public void setUp() {
                        // Zaman damgası kullanarak benzersiz bir dosya adı oluşturma
                        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                        String reportFile = "target/site/cucumber-pretty-" + timestamp + ".html";

                        // Dinamik olarak plugin ayarını değiştirme
                        System.setProperty("cucumber.plugin", "html:" + reportFile);
                }

                @Override
                @DataProvider(parallel = true)
                public Object[][] scenarios() {
                        return super.scenarios();
                }
        }

        public static void main(String[] args) {
                // Dinamik olarak plugin ayarını Cucumber Options ile birleştirme
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String reportFile = "target/site/cucumber-pretty-" + timestamp + ".html";
                System.setProperty("cucumber.plugin", "html:" + reportFile);

                // TestNG sınıfını başlatma
                org.testng.TestNG testNG = new org.testng.TestNG();
                testNG.setTestClasses(new Class[]{TestRunner.class});
                testNG.run();
        }
}






