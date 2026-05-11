package com.configurationstyle;
import org.springframework.stereotype.Service;
@Service

class TeamLead implements Allocator{
	TeamLead(){
		System.out.println("Manager Bean Created");
	}
public void taskAllocation(String user) {
	System.out.println("Task is allocated by : Manager to "+ user);
}
}
