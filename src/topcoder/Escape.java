package topcoder;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Escape {
	int[][] map;
	final int numDimensions = 501;
	public int lowest(String[] harmful, String[] deadly) {
		map = new int[numDimensions][numDimensions];
		for(int i=0; i<numDimensions; ++i) {
			Arrays.fill(map[i], 0);
		}
		for(String s: harmful) {
			final StringTokenizer st = new StringTokenizer(s);
			final int X1 = Integer.parseInt(st.nextToken());
			final int Y1 = Integer.parseInt(st.nextToken());
			final int X2 = Integer.parseInt(st.nextToken());
			final int Y2 = Integer.parseInt(st.nextToken());
			for(int i=X1; i<=X2; ++i) {
				for(int j=Y1; j<=Y2; ++j) {
					map[i][j] = 1;
				}
			}
		}
		
		for(String s: deadly) {
			final StringTokenizer st = new StringTokenizer(s);
			final int X1 = Integer.parseInt(st.nextToken());
			final int Y1 = Integer.parseInt(st.nextToken());
			final int X2 = Integer.parseInt(st.nextToken());
			final int Y2 = Integer.parseInt(st.nextToken());
			for(int i=X1; i<=X2; ++i) {
				for(int j=Y1; j<=Y2; ++j) {
					map[i][j] = 2;
				}
			}
		}
		return 0;				
	}
	
	public static void main(String[] args) {
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;

		time = System.currentTimeMillis();
		answer = new Escape().lowest(new String[] {}, new String[] {});
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 0;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Escape().lowest(new String[] { "500 0 0 500" },
				new String[] { "0 0 0 0" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1000;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Escape().lowest(new String[] { "0 0 250 250",
				"250 250 500 500" }, new String[] { "0 251 249 500",
				"251 0 500 249" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 1000;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Escape().lowest(new String[] { "0 0 250 250",
				"250 250 500 500" }, new String[] { "0 250 250 500",
				"250 0 500 250" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = -1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Escape().lowest(new String[] { "468 209 456 32",
				"71 260 306 427", "420 90 424 492", "374 253 54 253",
				"319 334 152 431", "38 93 204 84", "246 0 434 263",
				"12 18 118 461", "215 462 44 317", "447 214 28 475",
				"3 89 38 125", "157 108 138 264", "363 17 333 387",
				"457 362 396 324", "95 27 374 175", "381 196 265 302",
				"105 255 253 134", "0 308 453 55", "169 28 313 498",
				"103 247 165 376", "264 287 363 407", "185 255 110 415",
				"475 126 293 112", "285 200 66 484", "60 178 461 301",
				"347 352 470 479", "433 130 383 370", "405 378 117 377",
				"403 324 369 133", "12 63 174 309", "181 0 356 56",
				"473 380 315 378" }, new String[] { "250 384 355 234",
				"28 155 470 4", "333 405 12 456", "329 221 239 215",
				"334 20 429 338", "85 42 188 388", "219 187 12 111",
				"467 453 358 133", "472 172 257 288", "412 246 431 86",
				"335 22 448 47", "150 14 149 11", "224 136 466 328",
				"369 209 184 262", "274 488 425 195", "55 82 279 253",
				"153 201 65 228", "208 230 132 223", "369 305 397 267",
				"200 145 98 198", "422 67 252 479", "231 252 401 190",
				"312 20 0 350", "406 72 207 294", "488 329 338 326",
				"117 264 497 447", "491 341 139 438", "40 413 329 290",
				"148 245 53 386", "147 70 186 131", "300 407 71 183",
				"300 186 251 198", "178 67 487 77", "98 158 55 433",
				"167 231 253 90", "268 406 81 271", "312 161 387 153",
				"33 442 25 412", "56 69 177 428", "5 92 61 247" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = 254;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out
					.println("You're a stud (at least on the test data)! :-D ");
	}

}
// Powered by [KawigiEdit] 2.0!