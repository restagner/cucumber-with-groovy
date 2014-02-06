package cucumber.steps

import cucumber.support.CucumberWithGroovyWorld
import static cucumber.api.groovy.EN.*
import static cucumber.api.groovy.Hooks.Before

//CucumberWithGroovyWorld world

Before() {
    println "Hello from ${this.getClass()} BEFORE hook"
//    world = delegate as CucumberWithGroovyWorld
}

Given(~'^a simple step$') { ->
    println hello() + " from Simple Steps"
}

When(~'^the action is taken$') { ->
    println brownDogJumped() + " from Simple Steps"
}

Then(~'^we should expect an answer of "([^"]*)"$') { String arg1 ->
    assert arg1.toInteger() == 2
}