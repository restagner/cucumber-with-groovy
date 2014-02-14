package cucumber.support

import cucumber.api.groovy.Hooks
import cucumber.helpers.MyHelper

this.metaClass.mixin(Hooks)

class CucumberWithGroovyWorld {
//    @Delegate MyHelper myHelper
//    @Delegate TestEnvironment testEnvironment
}

World {
    def cucumberWithGroovyWorld = new CucumberWithGroovyWorld()
    cucumberWithGroovyWorld.metaClass.mixin([MyHelper, TestEnvironment])
    return cucumberWithGroovyWorld
}

Before() {
    println "\nCall ${myTestMethod()} method from ${this.getClass()} BEFORE hook\n"
}
