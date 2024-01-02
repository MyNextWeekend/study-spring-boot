package com.example.studyspringboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author weekend
 */
@Configuration
//EnableAsync // 启动类或者这里开启异步支持都行
public class AsyncConfiguration implements AsyncConfigurer {
    private final Logger logger = LoggerFactory.getLogger(AsyncConfiguration.class);

    @Bean(name = "asyncPoolTaskExecutor") //线程池注册并取名
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(2);    //核心线程数
        taskExecutor.setMaxPoolSize(10);    //线程池维护线程的最大数量,只有在缓冲队列满了之后才会申请超过核心线程数的线程
        taskExecutor.setQueueCapacity(50);  //缓存队列
        taskExecutor.setKeepAliveSeconds(200);  //许的空闲时间,当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
        taskExecutor.setTaskDecorator(new MdcTaskDecorator());    //线程装饰：针对线程的 开始和结束 做一些处理
        taskExecutor.setThreadNamePrefix("async-"); //异步方法内部线程名称
        /**
         * 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略
         * 通常有以下四种策略：
         * AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         * DiscardPolicy：也是丢弃任务，但是不抛出异常。
         * DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * CallerRunsPolicy：重试添加当前的任务，自动重复调用 execute() 方法，直到成功
         */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();  // 初始化initialize()方法会启动所有配置的线程
        return taskExecutor;
    }

    /**
     * 指定默认线程池
     */
    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    /**
     * 当线程池执行异步任务时会抛出AsyncUncaughtExceptionHandler异常，
     * 此方法会捕获该异常
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (err, method, params) -> {
            logger.error("线程池 asyncPoolTaskExecutor 执行任务发生未知错误,执行方法:{},参数:{}", method.getName(), Arrays.toString(params), err);
        };

    }
}