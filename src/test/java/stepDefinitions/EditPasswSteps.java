package stepDefinitions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pageObjects.EditPasswPage;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

public class EditPasswSteps extends GeneralSteps {
    private EditPasswPage editPasswPage = new EditPasswPage(driver);

    @And("^Choose Change My Password$")
    public void loginContinuePassword() throws Throwable {
        editPasswPage.clickChangePassword();
    }
    @And("^write password credentials$")
    public void type_password_credentials(Map<String, String> userData)  throws Throwable {
        editPasswPage.changePassword(userData.get("changepass"), userData.get("confirmpass"));
    }
    @When ("^click continue$")
    public void clickPasswordChangeCotinue()  throws Throwable{
        editPasswPage.clickContinue();
    }
    @Then ("^get success message$")
    public void successGetSuccess() throws Throwable{
        assertEquals("Success: Your password has been successfully updated.", editPasswPage.getsSuccess());

    }
    @Then ("^get error message$")
    public void successgetsStress() throws Throwable{
        assertEquals("Password confirmation does not match password!", editPasswPage.getsStress());
    }
    @Then ("^get password error message$")
    public void errorPasswordMust() throws Throwable{
        assertEquals("Password must be between 4 and 20 characters!", editPasswPage.getsStress());
    }
    @Then ("^get error message 3$")
    public void errorPasswordOneEmpty() throws Throwable{
        assertEquals("Password confirmation does not match password!", editPasswPage.getsStress());
    }
    @When ("^click back$")
    public void whenIClickBack()  throws Throwable{
        editPasswPage.clickBack();
    }
    @And ("^delete old password$")
    public void deletePasswordField() throws Throwable{
        editPasswPage.deletePassword();
    }
    @And ("^delete old password confirmation$")
    public void deletePasswordConfirmField() throws Throwable{
        editPasswPage.deletePasswordConfirm();
    }
}