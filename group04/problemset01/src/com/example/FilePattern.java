package com.example;

import java.io.File;
import java.io.FileFilter;

/** Filters file names using command-line wildcards.
 * <P>
 * <tt>*</tt> matches any number of characters.
 * <tt>?</tt> matches exactly one characters.
 * <P>
 * <b>Example:</b> 
 * <tt>*.txt</tt> matches all text files;  
 * <tt>cat??.jpg</tt> matches all images that start
 * with <i>cat</i> and got two more characters. 
 * 
 * @author You!
 *
 */
/*
 * @corrections Alex
 *
 * Your filter passes all default provided tests! But it fails
 * additional tests, take a look in FilePatternExtraTest.java
 * For example:
 * newFileFilter("**").accept(new File("")) returns false
 * I think, you just had no idea, that it can be two stars in
 * pattern, but it can be. And because of that using recursion is
 * the best approach.
 * If only you added some additional tests to check extreme cases...
 * As you see it is not so simple to be a tester, you should take care
 * about every possible and impossible case.
 *
 * @status ACCEPTED (ok)
 *
 * @suggestions
 * 	in future assignments take care about
 * 		- various test cases
 * 		- naming
 * 
 * By the way, why is there an empty file MathsBigD.java?
 * Please, clean your repository.
 */
public class FilePattern implements FileFilter {

	private String filter;

	/**
	 * Creates a new instance of the FilePattern class that filters
	 * file names based on the given pattern.
	 * 
	 * @param pattern the pattern used to filter file names.
	 * @see FilePattern
	 */
	public FilePattern(String pattern) {
		this.filter = pattern;
	}

	public boolean accept(File pathname) {
		int indxPathname = 0;
		/*
		 * Wasn't it better to create an additional variable for pathname.getName()?
		 * There is no need to invoke in a loop getter when you can get a filename
		 * before loop and use variable. You can minimize method invoking overhead.
		 * The problem is when you call a method, JVM stores registers in stack 
		 * and restores them after returning from the method. Try to improve performance
		 * where possible if only it does not interfere with design.
		 */
		for ( int indxFilter = 0; indxFilter < this.filter.length(); indxFilter++ ) {
			if ( indxPathname < pathname.getName().length() &&
					this.filter.charAt ( indxFilter ) == '?' )
				indxPathname++;
			else if ( this.filter.charAt ( indxFilter ) == '*' &&
					indxFilter == this.filter.length() - 1 ) {
				return true;
			}
			else if ( this.filter.charAt ( indxFilter ) == '*' ) {
				/*
				 * Use some imagination to find a good name for "i1" variable
				 */
				for ( int i1 = indxPathname; i1 < pathname.getName().length(); i1++ ) {
					if ( pathname.getName().charAt ( indxPathname ) == 
							this.filter.charAt ( indxFilter + 1 ) ) {
						break;
					}
					indxPathname++;
				}
			}
			else if ( indxPathname < pathname.getName().length() &&
					this.filter.charAt ( indxFilter ) ==
					pathname.getName().charAt ( indxPathname ) ) {
				indxPathname++;
			}
			else {
				return false;
			} 
		}
		return indxPathname == pathname.getName().length();
		/*
		 * I saw in git comment that you were curious what that
		 * strange piece of code is for. To help you there was
		 * a skeleton for FilePattern. accept(..) method returns boolean.
		 * Without return statement it produces compilation error and red lines
		 * in IDE. throwing an Error exception indicates that method isn't implemented
		 * yet. You can simply remove that line.
		 */
//		throw new Error(); // What for ??
	}
}
