package com.configurationstyle;

import org.springframework.beans.factory.annotation.Autowired;

public class DelegateAnnotationBased {
	
	private final Allocator allocator;
	@Autowired
	public DelegateAnnotationBased(Allocator allocator) {
		super();
		this.allocator=allocator;
		System.out.println("Inside Delegate Constructor- Allocator Impl: "+ allocator.getClass().getSimpleName());
		
	};
	public void notifyUser() {
		allocator.taskAllocation("Ayush");
	}
}
