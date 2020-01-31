## To Build
```shell script
mvn clean compile assembly:single
```

## To Run
```shell script
java -jar target/HoolahTest-1.0-jar-with-dependencies.jar
```

# To Change CSV file
Go to the main-class (me.duvu.hoolah.Main.java) and provide a file-path to variable filename, or copy your data file into root of project and rename it "input.csv"

```java
String fileName = "./input.csv";
```
# To input argument for test
There are 3 variables there:
```java
        String fromDate = "20/08/2018 12:00:00";
        String toDate = "20/08/2018 13:00:00";
        String merchant = "Kwik-E-Mart";
```

let's change and take test.