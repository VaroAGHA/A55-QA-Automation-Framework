import org.testng.annotations.DataProvider;

public class TestData {

    //Data providers Start
    @DataProvider(name="invalidLoginData")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {"invalid@email.com", "invalidPassword"},
                {"varag@testpro.io", ""},
                {"", ""},
                {"invalid@email.com", "te$t$tudent1"},
        };
    }
}
