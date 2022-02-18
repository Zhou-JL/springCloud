package com.zhoujl.springcloud.lib;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-18 15:57
 * @see: com.zhoujl.springcloud.lib
 * @Version: 1.0
 * MyLb  自定义负载均衡
 */
@Component
public class MyLb implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            System.out.println("current:"+current);
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("************第几次访问，next: "+next);
        return next;
    }




    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
