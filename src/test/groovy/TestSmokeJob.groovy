import org.junit.Test
import kudlady.CurrentJobBasePipelineTest

class TestSmokeJob extends CurrentJobBasePipelineTest {

    /**
     * Loads without running the script by its name/path, returning the Script
     * @param scriptName script name or path
     * @return script object
     */

    Script wrapLoadScript(String scriptName) {
        println("Override loadScript")
        super.loadScript("${scriptName}wrapped")
    }

    @Test
    void should_execute() throws Exception {
        def script = loadScript("SmokeJob.jenkinsfile")
        script.execute()
        printCallStack()
    }

    @Test
    void wrap_test() throws Exception {
        def script = wrapLoadScript("ToWrapJob.Jenkins")
        println(script)
        println(script.metaClass.methods.name.unique().sort())
        script.execute()
        printCallStack()

    }
}