package health.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.NoHealthException;
import health.Health;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HealthTest {

    private Health health;
    private NoHealthException nhe;

    @Given("^a NPC with health of (\\d+) and a max of (\\d+)$")
    public void a_NPC_with_health_of_and_a_max_of(int arg1, int arg2) {
        health = new Health(arg1, arg2);
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^is healed (\\d+)$")
    public void is_healed(int arg1)  {
        // Write code here that turns the phrase above into concrete actions
        health.addHealth(arg1);
    }

    @Then("^his health should be (\\d+)$")
    public void his_health_should_be(int arg1) {
        assertEquals(arg1, health.getActualHealth());
    }

    @When("^receive an attack of (\\d+)$")
    public void receive_an_attack_of(int arg1) {
        try {
            health.receiveDamage(arg1);
        } catch (NoHealthException e){
            nhe = e;
        }
    }

    @Then("^the NPC is killed$")
    public void the_NPC_is_killed() {
        assertNotNull(nhe);
    }
}
