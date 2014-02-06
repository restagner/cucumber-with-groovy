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

//    new CucumberWithGroovyWorld(myHelper: new MyHelper(), testEnvironment: new TestEnvironment())
}

Before() {
//    CucumberWithGroovyWorld world = delegate as CucumberWithGroovyWorld
    println "\nCall ${myTestMethod()} method from ${this.getClass()} BEFORE hook\n"
}
