package simple;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.JavaSparkContext;

//./spark-2.3.2-bin-hadoop2.7/bin/spark-submit --class simple.Test --master spark://127.0.0.1:7077 test.jar

public class Test 
{
	final static int NUM_SAMPLES = 100000;
	public static void main(String[] args) 
	{
		JavaSparkContext context = Context.getInstance();
		List<Integer> l = new ArrayList<>(NUM_SAMPLES);
		for (int i = 0; i < NUM_SAMPLES; i++) {
		  l.add(i);
		}

		long count = context.parallelize(l).filter(i -> {
		  double x = Math.random();
		  double y = Math.random();
		  return x*x + y*y < 1;
		}).count();
		System.out.println("Pi is roughly " + 4.0 * count / NUM_SAMPLES);
		context.stop();
		context.close();

	}

}
