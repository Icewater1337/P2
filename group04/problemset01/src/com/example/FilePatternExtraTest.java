package com.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileFilter;

import org.junit.Test;

public class FilePatternExtraTest {

	protected FileFilter newFileFilter(String pattern) {
		return new FilePattern(pattern);
	}

	// Tests from the original file go here

	/*
	 * New tests for the logic
	 */

	@Test public void fMarkDotTxtShouldNotMatchDotTxt() {
		assertFalse(newFileFilter("f?.txt").accept(new File(".txt")));
	}

	@Test public void fStarDotStarShouldMatchFnameDotTxt() {
		assertTrue(newFileFilter("*.*").accept(new File("fname.txt")));
	}

	@Test public void fStarStarShouldMatchEmptyString() {
		assertTrue(newFileFilter("**").accept(new File("")));
	}

	@Test public void fStarMarkShouldNotMatchEmptyString() {
		assertFalse(newFileFilter("*?").accept(new File("")));
	}

	@Test public void fStarMarkStarShouldNotMatchEmptyString() {
		assertFalse(newFileFilter("*?*").accept(new File("")));
	}

	@Test public void fStarMarkShouldMatchX() {
		assertTrue(newFileFilter("*?").accept(new File("x")));
	}

	@Test
	public void fnameDotTextShouldNotMatch() {
		assertFalse(newFileFilter("fname.txt").accept(new File("fnameAtxt")));
	}

	@Test
	public void fnameTTextShouldNotMatch() {
		assertFalse(newFileFilter("fnamettxt").accept(new File("fname.txt")));
	}

	/*
	 * Recursion test
	 */
	@Test public void ananasDoesNotMatch() {
		assertFalse(newFileFilter("*ana").accept(new File("ananas")));
	}

	@Test public void ananasMatch() {
		assertTrue(newFileFilter("*anas").accept(new File("ananas")));
	}

	@Test public void doubelAnananas() {
		assertTrue(newFileFilter("*nas*anas").accept(new File("ananasananas")));
	}

	@Test public void fMarkStarShouldMatchX() {
		assertTrue(newFileFilter("b*ac").accept(new File("babac")));
	}

	/*
	 * Additional tests to break regex
	 */
	@Test public void fbracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f[.txt").accept(new File("f[.txt")));
	}

	@Test
	public void fCircumflexDotTxtShouldMatch() {
		assertTrue(newFileFilter("f^.txt").accept(new File("f^.txt")));
	}

	@Test
	public void fMarkDotTxtShouldMatch() {
		assertTrue(newFileFilter("f?.txt").accept(new File("f?.txt")));
	}

	@Test
	public void fSlashDotTxtShouldMatch() {
		assertTrue(newFileFilter("f\\.txt").accept(new File("f\\.txt")));
	}

	@Test
	public void fDotSlashDotTxtShouldMatch() {
		assertTrue(newFileFilter("f.\\.txt").accept(new File("f.\\.txt")));
	}

	@Test
	public void fbrightracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f[.txt").accept(new File("f[.txt")));
	}

	@Test
	public void fleftbracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f].txt").accept(new File("f].txt")));
	}

	@Test
	public void frightbeautybracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f{.txt").accept(new File("f{.txt")));
	}

	@Test
	public void fleftbeautybracketDotTxtShouldMatch() {
		assertTrue(newFileFilter("f}.txt").accept(new File("f}.txt")));
	}

	@Test
	public void fMarkDotStarDotStarShouldMatch() {
		assertTrue(newFileFilter("f?.*.*").accept(new File("f1.txt.bak")));
	}

	@Test
	public void fDotDotShouldNotMatch() {
		assertFalse(newFileFilter("f.\\.").accept(new File("fg.")));
	}

}
