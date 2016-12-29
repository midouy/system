package org.system.web.task;

import  org.slf4j.Logger;
import  org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by midouy on 2016/12/3.
 */
@Component("springTaskTestService")
@Lazy(value=false)
public class SpringTaskTestService
{
	private Logger logger = LoggerFactory.getLogger(SpringTaskTestService.class);
	public void execute()throws Exception{
		String time = DateFormat.getDateTimeInstance().format(new Date());
		System.out.println("定时器触发打印"+time);
//		System.out.println(Thread.currentThread());
		logger.info(Thread.currentThread().toString());
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis()-start<5*1000){
		}
	}
}
