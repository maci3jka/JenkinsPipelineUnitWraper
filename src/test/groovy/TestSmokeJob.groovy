import org.junit.Test
import kudlaty.CurrentJobBasePipelineTest

class TestSmokeJob extends CurrentJobBasePipelineTest {

    /**
     * Loads without running the script by its name/path, returning the Script
     * @param scriptName script name or path
     * @return script object
     */



//    @Test
    void should_execute() throws Exception {
        def script = loadScript("SmokeJob.jenkinsfile")
        script.execute()
        printCallStack()
    }

    @Test
    void wrap_test() throws Exception {
        def script = wrapLoadScript("src/main/groovy/ToWrapJob.Jenkins")
//        println(script)
//        println(script.metaClass.methods.name.unique().sort())
//        script.execute()
//        printCallStack()

    }
}