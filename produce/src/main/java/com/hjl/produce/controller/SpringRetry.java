package com.hjl.produce.controller;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created   on 2018/9/14.
 *
 * @author hjl
 */
@RestController
public class SpringRetry {

    int i = 1;

    //    @Retryable：标注此注解的方法在发生异常时会进行重试
    //    参数说明：value：抛出指定异常才会重试
    //    include：和value一样，默认为空，当exclude也为空时，默认所以异常
    //    exclude：指定不处理的异常
    //    maxAttempts:最大重试次数，默认3次
    //    backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，multiplier（指定延迟倍数）
    //    默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为2，则第一次重试为1秒，第二次为
    //    2秒，第三次为4秒
    //    @Recover：用于@Retryable重试失败后处理方法，此方法里的异常一定要是@Retryable方法里抛出的异常，否则不会调用这个方法
    @GetMapping("test")
    @Retryable(value = Exception.class, maxAttempts = 4)
    public String test() {
        i++;
        System.out.println("-----" + i);
        int a = 3 / 0;
        return "11111";
    }

    @Recover
    public String recover() {
        return "recover";
    }
}
