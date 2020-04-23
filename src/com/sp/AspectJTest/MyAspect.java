package com.sp.AspectJTest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 切面类，在此类编写通知
 */
//

 @Aspect
@Component
public class MyAspect {
  //定义切入点表达式
    @Pointcut("execution(* com.sp.model.*.*(..))")
    public void allMethod() {
        //使用一个返回值为void，方法体为空的方法来命名切入点
    }

   // 前置通知
    @Before("allMethod()")
    public void myBefore(JoinPoint joinPoint){
        System.out.println("前置通知：模拟执行权限检查...."+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date()));
        System.out.println("目标类是："+joinPoint.getTarget());
        System.out.println("被织入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    //后置通知
    @AfterReturning("allMethod()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("后置通知：模拟记录日志....");
        System.out.println("被织入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }

    //环绕通知
    @Around("allMethod()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
       //开始
        long beginTime=System.currentTimeMillis();
        System.out.println("环绕开始：执行目标方法之前，模拟开启事务....时间"+beginTime+"毫秒");
        //执行当前目标方法
        Object obj=proceedingJoinPoint.proceed();
       //结束
        long endTime=System.currentTimeMillis();
        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务....时间"+endTime+"毫秒");
        System.out.println("事务处理完毕，执行时间为："+(endTime-beginTime)+"毫秒");
        return obj;
    }

    //异常通知
    @AfterThrowing(pointcut = "allMethod()",throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint){

        //获取被调用的类名
        String targetClassName=joinPoint.getTarget().getClass().getName();
        //获取被调用的方法名
        String targetMethodName=joinPoint.getSignature().getName();
        //日志格式的字符串
        String logInfoText="异常通知：执行"+targetClassName+"类中的"+targetMethodName+"方法时发生异常！";
        //将日志信息输出到控制台
        System.out.println(logInfoText);
    }

    //最终通知
    @After("allMethod()")
    public void myAfter(){
        System.out.println("最终通知：模拟方法结束后的释放资源...");
    }

}
