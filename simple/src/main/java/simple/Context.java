package simple;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class Context 
{

	public static JavaSparkContext getInstance() 
	{
		System.setProperty("hadoop.home.dir", "C:\\dev\\spark-2.3.1-bin-hadoop2.7");
		SparkConf conf = new SparkConf().setAppName("Sparkle Samples").setMaster("local");
		return new JavaSparkContext(conf);
	}

	public static SparkSession getSession() 
	{
		return SparkSession.builder().appName("Spark In Action").master("local").getOrCreate();
	}

}
