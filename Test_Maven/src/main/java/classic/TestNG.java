package classic;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG {

	@Parameters  ({"para 1"})
	@Test  (groups = {"regression"})
	public void test1(String para) {
		System.out.println("test1");
System.out.println(para);
	}

	@Test(groups = {"Sanity", "regression", "broken"})
	public void test2() {
		System.out.println("test2");

	}

	@Test  (groups = {"Sanity"})
	public void test3() {
		System.out.println("test3");

	}



	@Test  (groups = {"Sanity", "regression"})
	public void test4() {
		System.out.println("test4");

	}
}
