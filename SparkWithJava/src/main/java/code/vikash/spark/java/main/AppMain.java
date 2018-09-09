package code.vikash.spark.java.main;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class AppMain {

	public static void main(String[] args) {
		
		Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("collect").setMaster("local[*]");
			
		JavaSparkContext jsc =new JavaSparkContext(conf);
		
		//JavaRDD<String> textLoad= jsc.textFile("C:/spark/spark-2.0.2-bin-hadoop2.7/README.md");
		System.out.println(jsc.sparkUser());

	}

}
