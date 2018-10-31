package simple;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SqlTest {

	public static void main(String[] args) {

		SparkSession sql = Context.getSession();
		Dataset<Row> peopleInfo = sql.read().json("test.json");

		peopleInfo.printSchema();

		Dataset<Row> rows = peopleInfo.select("*");
		rows.show();
		// peopleInfo = sql.sql("select id from peopleInfo");
		sql.stop();
		sql.close();

	}

}
