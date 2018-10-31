package simple;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RddTest {

	public static void main(String[] args)
	{
		JavaSparkContext sc = Context.getInstance();
		JavaRDD<String> lines = sc.textFile("test.txt");
		System.out.println(lines.count());
		JavaRDD<String> lines3 = lines.filter(word -> word.contains("123"));
		System.out.println(lines3.count());
		lines3.foreach(s -> System.out.println(s));
		sc.stop();
		sc.close();

	}

}
