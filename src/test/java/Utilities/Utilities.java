package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import BaseClass.BaseClass;
import io.cucumber.java.Scenario;

public class Utilities 
{
	
	public void takeScreenshot(String x,WebDriver driver) throws IOException
	{
		
		
		//long x=System.currentTimeMillis();
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String failed=x.replaceAll(" ", "_");
		String filePath=System.getProperty("user.dir")+"\\Screenshot\\"+failed+timestamp+".png";
		System.out.print(filePath);
		
		
		
		
		TakesScreenshot ss=((TakesScreenshot)driver);
		
		File src=ss.getScreenshotAs(OutputType.FILE);
		File dest=new File(filePath);
		FileUtils.copyFile(src, dest);
	}

}
