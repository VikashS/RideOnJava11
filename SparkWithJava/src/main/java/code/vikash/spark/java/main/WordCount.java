package code.vikash.spark.java.main;

import java.util.Arrays;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.getLogger("org").setLevel(Level.ERROR);
        SparkConf conf = new SparkConf().setAppName("WordCount").setMaster("local[*]");
        
        JavaSparkContext jsc=new JavaSparkContext(conf);
        JavaRDD<String> jscRead=jsc.textFile("in/word_count.text");
        JavaRDD<String> jscFlatMap=jscRead.flatMap(line -> Arrays.asList(line.split(" ")).iterator());
        
        Map<String,Long> map=jscFlatMap.countByValue();
        
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

	}

}
