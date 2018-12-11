package core;

public class OSUtils
{
   private String OS = null;
   public String getOsName()
   {
      if(OS == null) { OS = System.getProperty("os.name"); }
      return OS;
   }

   public boolean isUnix() {
	  return !System.getProperty("os.name").startsWith("Windows");
   }
}
