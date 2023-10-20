package kr.co.kgc.smsb.bo.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class BoLogbackFilter extends Filter<ILoggingEvent>{
    @Override
    public FilterReply decide(ILoggingEvent event) {    
        if (event.getLoggerName().contains("com.gsitm.ustra.java.batch")) {
            return FilterReply.DENY;
        }else{
            return FilterReply.ACCEPT;
        }
    }
}