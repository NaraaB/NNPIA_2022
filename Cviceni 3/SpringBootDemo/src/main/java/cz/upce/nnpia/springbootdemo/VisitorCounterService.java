package cz.upce.nnpia.springbootdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VisitorCounterService implements CounterService{
    private Integer counter = 0;
    @Override
    public void increment(){
        this.counter++;
    }
    @Override
    public Integer getCounter(){
        return counter;
    }
}
