package cucumber.steps

import cucumber.api.DataTable
import cucumber.support.CucumberWithGroovyWorld
import org.stag.qa.Calculator

import static cucumber.api.groovy.EN.*
import static cucumber.api.groovy.Hooks.Before

//CucumberWithGroovyWorld world
Calculator calculator

Before() {
    println "Hello from ${this.getClass()} BEFORE hook"
//    printLoader(delegate.getClass())
//    printLoader(CucumberWithGroovyWorld)
//    world = delegate as CucumberWithGroovyWorld
}


Given(~'^a calculator I just turned on$') { ->
    calculator = new Calculator()
}

When(~'^I add (\\d+) and (\\d+)$') { int arg1, int arg2 ->
    calculator.push(arg1)
    calculator.push(arg2)
    calculator.push("+")
}

Then(~'^the result is (\\d+)$') { double expected ->
    println brownDogJumped() + " from Basic Arithmetic Steps"
    assert expected == calculator.value()
}

Given(~'^the previous entries:$') { DataTable table ->
    List<Entry> entries = table.asList(Entry)
    entries.each { entry ->
        calculator.push(entry.first)
        calculator.push(entry.second)
        calculator.push(entry.operation)
    }
}

When(~'^I press (.+)$') { String what ->
    calculator.push(what)
}

class Entry {
    Integer first
    Integer second
    String operation
}

def printLoader(Class c) {
    def loader = c.classLoader

    while (loader!=null) {
        println "class loader is an instance of ${loader.getClass()} called $loader"
        loader = loader.parent
    }
    println "<bootstrap loader>\n"
}
