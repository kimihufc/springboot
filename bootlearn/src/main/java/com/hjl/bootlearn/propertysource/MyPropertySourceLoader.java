package com.hjl.bootlearn.propertysource;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-9-29
 * Time: 上午11:54
 * Description:
 */
public class MyPropertySourceLoader implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[] { "json" };
    }

    @Override
    public PropertySource<?> load(String s, Resource resource, String s1) throws IOException {
        String s2 = readFile(resource);
        System.out.println("MyPropertySourceLoader"+s2);
        return null;
    }

    private String readFile(Resource resource) throws IOException {
        InputStream inputStream = resource.getInputStream();
        List<Byte> byteList = new LinkedList<Byte>();
        byte[] readByte = new byte[1024];
        int length;
        while ((length = inputStream.read(readByte)) > 0) {
            for (int i = 0; i < length; i++) {
                byteList.add(readByte[i]);
            }
        }
        byte[] allBytes = new byte[byteList.size()];
        int index = 0;
        for (Byte soloByte : byteList) {
            allBytes[index] = soloByte;
            index += 1;
        }
        return new String(allBytes, "UTF-8");
    }
}
