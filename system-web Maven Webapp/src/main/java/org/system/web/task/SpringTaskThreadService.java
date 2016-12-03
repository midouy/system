package org.system.web.task;

import org.springframework.stereotype.Component;

/**
 * Created by midouy on 2016/12/3.
 */
@Component
public class SpringTaskThreadService
{
	public void execute(){
		System.out.println("Thread running ");
	}
}
