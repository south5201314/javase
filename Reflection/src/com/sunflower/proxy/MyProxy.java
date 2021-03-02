package com.sunflower.proxy;

import com.sunflower.NikeFactory;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 2. 创建一个专门生产代理类对象的通用代理类
public class MyProxy{
    //返回代理类的对象
    public static Object getProxy(Object object){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.BindObject(object);
        Object newProxyInstance = Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), myInvocationHandler);
        return newProxyInstance;
    }
}

// 1.创建一个实现接口InvocationHandler的类，
// 它必须实现invoke方法，以完成代理的具体操作。
class MyInvocationHandler implements InvocationHandler{
    private Object object;
    public void BindObject(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object,args);
    }
}


class TestProxy{
    @Test
    public void TestProxy(){
        Occupation proxy = (Occupation) MyProxy.getProxy(new Star());
        proxy.Work("唱歌跳舞");
        int money = proxy.MakeMoney();
        System.out.println(money);
        Factory proxy1 = (Factory) MyProxy.getProxy(new NikeFactory());
        proxy1.Production();
    }
}