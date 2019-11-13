package hjl;

import java.lang.instrument.Instrumentation;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-11-12
 * Time: 下午5:15
 * Description:
 */
public class MyjavaAgent {

    public static void premain(String agentArgs, Instrumentation inst){
        Class[] loadedClasses = inst.getAllLoadedClasses();
        for (Class loadedClass : loadedClasses) {
            System.out.println("myagent:"+loadedClass.toString());
        }
    }
}
