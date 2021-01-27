package starter.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import starter.navigation.NavigateTo;
import starter.questions.CreditAvailable;
import starter.questions.OverviewData;
import starter.tasks.login.DoLogin;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;


public class LoginStepDefinitions {
    String name;
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    //(.*)
    @Given("(.*) has an active account")
    public void josimarHasAnActiveAccount(String name){
        this.name=name;
    }

    @When("he sends their valid credentials")
    public void heSendsTheirValidCredentials() {
       theActorCalled(name).attemptsTo(
               NavigateTo.theDuckDuckGoHomePage(),
               DoLogin.withCredentials("jjosimarlc","Auna123456!")
       );
    }

    @Then("he should have access to manage his account")
    public void heShouldHaveAccessToManageHisAccount() {
        //System.out.println("****** " + CreditAvailable.value().answeredBy(theActorInTheSpotlight()));
        //System.out.println("****** " + OverviewData.totalBalance().answeredBy(theActorInTheSpotlight()));

        theActorInTheSpotlight().should(
                seeThat("",OverviewData.creditAvaible(),equalTo("$17,800")),
                seeThat("",OverviewData.totalBalance(),equalTo("$17,800")),
                seeThat("",OverviewData.creditAvaible(),equalTo("$17,800"))

        );
    }
}
