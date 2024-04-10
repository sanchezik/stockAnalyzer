# Stock Analyzer

Developed by Aliaksandr Tsatserski

### Usage

Have JDK installed on your machine. To check if it's installed, use command:

    java -version

Compile the code:

    javac StockAnalyzer.java

Put your CSV files with stocks into <u>/input</u> directory.
Run Analyzer:

    java StockAnalyzer AAPL 2020

### Testing

Compile the code:

    javac -cp "lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar;." StockAnalyzer.java StockAnalyzerTest.java

Run test file:

    java -cp "lib/junit-4.12.jar;lib/hamcrest-core-1.3.jar;." org.junit.runner.JUnitCore StockAnalyzerTest