import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class EllysDirectoryListing
{
	public String[] getFiles(String[] files)
	{
		final int numFiles = files.length;
		while(true) {
			if((files[numFiles-1] == "." && files[numFiles-2] == "..") || (files[numFiles-1] == ".." && files[numFiles-2] == ".")) {
				return files;
			} else {
				for(int i=0; i<numFiles-2; ++i) {
					if(files[i].compareTo(".") == 0|| files[i].compareTo("..") == 0) {
						String swap = files[i];
						files[i] = files[numFiles - 1];
						files[numFiles - 1] = swap;
						break;
					}
				}
				if((files[numFiles-1] == "." && files[numFiles-2] == "..") || (files[numFiles-1] == ".." && files[numFiles-2] == ".")) {
					return files;
				}
				for(int i=0; i<numFiles-2; ++i) {
					if(files[i].compareTo(".") == 0|| files[i].compareTo("..") == 0) {
						String swap = files[i];
						files[i] = files[numFiles - 2];
						files[numFiles - 2] = swap;
						break;
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		long time;
		String[] answer;
		boolean errors = false;
		String[] desiredAnswer;
		
		boolean same;
		
		time = System.currentTimeMillis();
		answer = new EllysDirectoryListing().getFiles(new String[]{"ContestApplet.jnlp", ".", "Image.jpg", "..", "Book.pdf", "Movie.avi"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"ContestApplet.jnlp", "Movie.avi", "Image.jpg", "Book.pdf", "..", "." };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysDirectoryListing().getFiles(new String[]{"Image.jpg", "..", "."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"Image.jpg", "..", "." };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysDirectoryListing().getFiles(new String[]{"..", ".", "Image.jpg"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"Image.jpg", ".", ".." };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysDirectoryListing().getFiles(new String[]{"No", "..", "Zaphod", ".", "Just", "very", "very...", "Improbable"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"No", "Improbable", "Zaphod", "very...", "Just", "very", ".", ".." };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysDirectoryListing().getFiles(new String[]{"www.topcoder.com", "Ever.tried", ".", "Ever.failed", "..", "No", "Matter.", "Try", "Again.", "Fail", "Again..", "Fail.Better"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"www.topcoder.com", "Ever.tried", "Fail.Better", "Ever.failed", "Again..", "No", "Matter.", "Try", "Again.", "Fail", "..", "." };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new EllysDirectoryListing().getFiles(new String[]{"This", ".", "is", "tricky", "test", ".."});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"This", "test", "is", "tricky", "..", "." };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!