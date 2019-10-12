package com.hjl.serial;

import com.alibaba.com.caucho.hessian.io.Hessian2Input;
import com.alibaba.com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-10-12
 * Time: 下午5:37
 * Description:
 */
public class HessianSerial {


    public static byte[] enserialize(Object resource,Class<?> clazz){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(outputStream);
        try {
            output.writeObject(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                output.close();
            }catch (Exception e){

            }
        }
        try {
            output.flush();
            byte[] result = outputStream.toByteArray();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try{
                outputStream.close();
            }catch (Exception e){

            }
        }

    }

    public static  <T> T deserialize(byte[] bytes,Class<T>  clazz){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        Hessian2Input hessian2Input = new Hessian2Input(inputStream);
        try {
            T result = (T)hessian2Input.readObject();
            return result;
        } catch (IOException e) {
            return null;
        }finally {
            try{
                hessian2Input.close();
            }catch (Exception e){
             e.printStackTrace();
            }
            try{
                inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
      User user = new User();
      user.setName("kimi");
        byte[] enserialize = enserialize(user, User.class);
        System.out.println(enserialize.toString());
        User user1 = deserialize(enserialize, User.class);
        System.out.println(user1.getName());
    }
}
