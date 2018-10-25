package kudlady

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
//import org.junit.Test

class CurrentJobBasePipelineTest extends BasePipelineTest{

    @Override
    @Before
    void setUp() throws Exception {
        helper.baseScriptRoot = 'qwe'
        helper.scriptRoots += 'src/main/groovy'
        scriptRoots += 'src/main/groovy'
        helper.scriptExtension = 'jenkinsfile'
        super.setUp()
    }
}
