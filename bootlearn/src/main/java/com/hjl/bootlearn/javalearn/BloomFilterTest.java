package com.hjl.bootlearn.javalearn;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-11-11
 * Time: 下午5:56
 * Description:
 */
public class BloomFilterTest {


    public static void main(String[] args) {
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),100000);
        for (int i = 0; i <100000 ; i++) {
            bf.put("1"+i);
        }
        System.out.println(bf.mightContain("10"));
        System.out.println(bf.mightContain("3"));
    }
}
