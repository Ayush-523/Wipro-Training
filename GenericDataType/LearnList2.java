package com.wipro.JavaBasics.GenericDataType;



import java.util.ArrayList;
import java.util.List;

public class LearnList2 {

	public static void main(String[] args) {

		
		Learner l1 = new Learner();
		l1.setName("sakshi");

		Learner l2 = new Learner();
		l2.setName("Mohit");
		l2.setVideo("On");

		Learner l3 = new Learner();
		l3.setName("Priyanshi");
		l3.setVideo("On");
		l3.setMic("On");
	
		Learner l4 = new Learner();
		l4.setName("Himanshi");
		l4.setVideo("On");
		l4.setMic("On");
		
		Learner l5 = new Learner();
		l5.setName("Himanshi");
		l5.setVideo("On");
		l5.setMic("On");
		
		
		List<Learner> learnerslist1 = new ArrayList<Learner>();


		learnerslist1.add(l1);
		learnerslist1.add(l2);
		learnerslist1.add(l3);
		
		
		List<Learner> learnerslist2 = new ArrayList<Learner>();
		
		learnerslist2.add(l4);
		learnerslist2.add(l5);
		
		
		
		
		List<List<Learner>>  listofLearners=new ArrayList<>();
		listofLearners.add(learnerslist1);
		listofLearners.add(learnerslist2);

		for (List<Learner> list : listofLearners) {
			System.out.println(list+"\n ____________");
		}

	}

}