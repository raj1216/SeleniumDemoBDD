package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
    private Properties prop;
    
    public Properties init_prop() 
    {

        prop = new Properties();
        FileInputStream ip = null;
        try 
        {
            ip = new FileInputStream("src/test/java/Utilities/config.properties");
        } 
        catch (FileNotFoundException e) 
        {
            throw new RuntimeException(e);
        }
        try 
        {
            prop.load(ip);
        } 
        catch (IOException e) 
        {
            throw new RuntimeException(e);
        }
        return prop;

    }
}