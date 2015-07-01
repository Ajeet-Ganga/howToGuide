
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

import com.google.gson.Gson;

@Measurement(iterations=2)
@Warmup(iterations=2)
@Fork(value=2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MyBenchmark {

	public static String str = "";
	 static class Data
		{
		 
		 
		 	private List<String> innerDataList = new ArrayList<String>();
			private final int i,j,k;
			public int getI() {
				return i;
			}

			public int getJ() {
				return j;
			}

			public int getK() {
				return k;
			}

			public int getL() {
				return l;
			}

			public int getM() {
				return m;
			}

			public int getN() {
				return n;
			}

			private final int l,m,n;

			public Data(int i, int j, int k) {
				super();
				this.i = i;
				this.j = j;
				this.k = k;
				
				this.l = i;
				this.m = j;
				this.n = k;
				
				for (int x =0;x<20;x++) {
					innerDataList.add(String.valueOf(x));
				}
			}

			@Override
			public String toString() {
				return "Data [i=" + i + ", j=" + j + ", k=" + k + ", l=" + l
						+ ", m=" + m + ", n=" + n + "]";
			}

			public List<String> getInnerDataList() {
				return innerDataList;
			}

			public void setInnerDataList(List<String> innerDataList) {
				this.innerDataList = innerDataList;
			}  
			
		}
	 
    @Benchmark
    public void testGson() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.

		Gson gson = new Gson();
    	for (int i =0;i<10;i++){
    		String s = gson.toJson(new Data(i, i, i));
//    		System.out.println(s);
    		str += s;
    	}   
    }
    
    @Benchmark
    public void testJackson() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.
    	ObjectMapper mapper = new ObjectMapper();
//    	mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
    	for (int i =0;i<10;i++){
    		//String s = mapper.convertValue((new Data(i,i,i)), String.class);
    		String s = null;
			try {
				s = mapper.writeValueAsString((new Data(i,i,i)));
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//    		System.out.println(s);
    		str += s;
    	}   
    }
    
    @Benchmark
    public void oneMilliSecondOp() {
    	try {
			Thread.sleep(1);
//			System.out.println(str.length());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
