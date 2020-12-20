package com.romanceabroad.ui;

import de.redsix.pdfcompare.CompareResult;
import de.redsix.pdfcompare.PdfComparator;
import org.testng.annotations.Test;

import java.io.IOException;

public class PdfAndSplit {
    //test is not passed, because i have no pdf files to compare in the project
  @Test
    public void testPdfComparison() throws IOException {
      new PdfComparator("expected.pdf", "actual.pdf").compare().writeTo("diffOutput");

      //The compare-method returns a CompareResult, which can be queried:
      final CompareResult result = new PdfComparator("expected.pdf", "actual.pdf").compare();
      if (result.isNotEqual()) {
          System.out.println("Differences found!");
      }
      if (result.isEqual()) {
          System.out.println("No Differences found!");
      }
      if (result.hasDifferenceInExclusion()) {
          System.out.println("Differences in excluded areas found!");
      }
      result.getDifferences(); // returns page areas, where differences were found

      //For convenience, writeTo also returns the equals status:
      boolean isEquals = new PdfComparator("expected.pdf", "actual.pdf").compare().writeTo("diffOutput");
      if (!isEquals) {
          System.out.println("Differences found!");
      }
  }
}
