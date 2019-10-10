package test.maven.selenium;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class ExcelDataExtractTest {
@Test
public void getData() throws IOException {
	ExcelPracticeTest ept = new ExcelPracticeTest();
	ArrayList<String> al1 = ept.excelDataDriven("purchse");
	for(int i=0;i<al1.size();i++) {
		System.out.println(al1.get(i));
	}
}
}
