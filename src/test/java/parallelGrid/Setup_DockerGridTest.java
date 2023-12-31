package parallelGrid;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Setup_DockerGridTest {

  @BeforeTest
  public void startDockerGridTest() throws IOException, InterruptedException {
	//Runtime.getRuntime().exec("cmd /c start_dockergrid.command");
	  Runtime.getRuntime().exec("open " + "/Users/apple/Desktop/dip_selenium_bdd/start_dockergrid.command");
		Thread.sleep(15000);
  }

  @AfterTest
  public void stopDockerGridTest() throws IOException, InterruptedException {
	//Runtime.getRuntime().exec("cmd /c stop_dockergrid.command");
	  Runtime.getRuntime().exec("open " + "/Users/apple/Desktop/dip_selenium_bdd/stop_dockergrid.command");
	Thread.sleep(15000);
	
	//Runtime.getRuntime().exec("taskkill /F /IM Terminal");
  }
}
