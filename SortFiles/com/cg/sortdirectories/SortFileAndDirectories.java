package com.cg.sortdirectories;

import java.io.File;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.function.Predicate;

public class SortFileAndDirectories {
	public static void main(String[] args) {
		
		File file=new File("File");
		
		File listOfFolder[]=file.listFiles();
		
		//Initialize TreeSet object with lambda expression 
		TreeSet<File> ts=new TreeSet<File>( (arg0,arg1) -> arg0.compareTo(arg1));
		
		//Storing into TreeSet
		ts.addAll(Arrays.asList(listOfFolder));
		Predicate<File> choose=(element)->element.getName().contains(".");//returns whether file or not
		
		//Applying negative predicate logic for the predicate to list the directories
		ts.stream().filter(choose.negate()).forEach(System.out::println);
		
		//Applying actual predicate logic to list the files
		ts.stream().filter(choose).forEach(System.out::println);
	
	}

}