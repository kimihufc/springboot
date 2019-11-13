package hjl;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-11-13
 * Time: 上午11:07
 * Description:
 */
public class TimeClassFileTransformer implements ClassFileTransformer {

    final static String prefix = "\nlong startTime = System.currentTimeMillis();\n";
    final static String postfix = "\nlong endTime = System.currentTimeMillis();\n";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if(className.startsWith("java")||className.startsWith("sun")){
            return null;
        }
        className = className.replace("/", ".");
        CtClass ctclass = null;
        try{
            ctclass = ClassPool.getDefault().get(className);
            for (CtMethod method : ctclass.getDeclaredMethods()) {
                String name = method.getName();
                String newMothid = name+"$old";
                method.setName(newMothid);
                CtMethod copy = CtNewMethod.copy(method, name, ctclass, null);
                // 构建新的方法体
                StringBuilder bodyStr = new StringBuilder();
                bodyStr.append("{");
                bodyStr.append("System.out.println(\"==============Enter Method: " + className + "." + name + " ==============\");");
                bodyStr.append(prefix);
                bodyStr.append(newMothid + "($$);\n");// 调用原有代码，类似于method();($$)表示所有的参数
                bodyStr.append(postfix);
                bodyStr.append("System.out.println(\"==============Exit Method: " + className + "." + name + " Cost:\" +(endTime - startTime) +\"ms " + "===\");");
                bodyStr.append("}");
                copy.setBody(bodyStr.toString());// 替换新方法
                ctclass.addMethod(copy);// 增加新方法
            }
            return ctclass.toBytecode();
        }catch (Exception e){

        }
        return null;
    }
}
