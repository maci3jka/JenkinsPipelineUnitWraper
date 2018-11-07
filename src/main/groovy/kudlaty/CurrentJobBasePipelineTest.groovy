package kudlaty

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import sun.font.Script

import java.nio.file.Files

//import org.junit.Test

class CurrentJobBasePipelineTest extends BasePipelineTest{

    @Override
    @Before
    void setUp() throws Exception {
//        helper.baseScriptRoot = 'qwe'
//        helper.scriptRoots += 'src/main/groovy'
        scriptRoots += 'src/main/groovy'
//        helper.scriptExtension = 'jenkinsfile'
        super.setUp()

    }
    String wrapText(String text){
        String wrapped = """def execute() {
    ${text}
}
return this
""".stripMargin()
        return wrapped
    }
    private def createWrapedFile(File text_file){
       println("Wrapping ${text_file}")
        def path = Paths.get(".",text_file.path)
        def tmp_file= Files.createTempFile(path.parent,"wraped",text_file.name)
        tmp_file.write(wrapText(text_file.text))
//        new File("${text_file.path}wrapped").with {it.write(wrapText(text_file.text))}
        println("Wraped file in ${tmp_file.toRealPath()}}")
        return tmp_file.toAbsolutePath()
    }
    void wrapFile(String filename){
        println("scriptRoots=${scriptRoots}")
        println("filename=${filename}")
        println("scriptExtension=${scriptExtension}")

//        scriptRoots.each { scriptRoot ->
//            println(scriptRoot)
//            def files = new FileNameFinder().getFileNames(baseScriptRoot,'**')
//            println("files=${files}")
//            new File(scriptRoot ).eachFileMatch(~/.${filename}/){
//            new File(scriptRoot ).eachFile{
//                if(it.exists()){
//                    println(it.path)
//                }
////                createWrapedFile(it)
//            }
        createWrapedFile(new File(filename))
//        new File(filename).with {
//            println("file exists ${it.exists()}")
//            createWrapedFile(it)
//        }

    }


    def execute(){

        println("EXE!")
    }

    def wrapLoadScript(String scriptName) {
        println("Override loadScript")
        def wraped_file = wrapFile(scriptName)
        try {

            super.loadScript(wraped_file)
        }
        finally {
            Files.delete(wraped_file)
        }



        return this
    }
}
