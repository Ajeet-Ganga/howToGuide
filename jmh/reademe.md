Maven remote catalog URL: https://repo1.maven.org/maven2/archetype-catalog.xml 

JMH home page: http://openjdk.java.net/projects/code-tools/jmh/

JMH archetype: jmh-java-benchmark-archetype

Benchmark function annotation:
@Benchmark

Class level annotations:
@Measurement(iterations=2)
@Warmup(iterations=2)
@Fork(value=2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)

Command line:
rm -rf target; mvn clean install; java -jar target/benchmarks.jar
