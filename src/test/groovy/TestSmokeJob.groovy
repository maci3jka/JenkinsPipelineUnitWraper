import org.junit.Test
import kudlady.CurrentJobBasePipelineTest

class TestSmokeJob extends CurrentJobBasePipelineTest {

    @Test
    void should_execute() throws Exception {
        def script = loadScript("SmokeJob.jenkinsfile")
        script.execute()
        printCallStack()
    }

    @Test
    void helper_test() throws Exception {
        def script = loadScript("SmokeJob.jenkinsfile")
        script.execute()
        println("Hello")
        helper.callStack.each {println(it)}
        println("Done")
    }
}