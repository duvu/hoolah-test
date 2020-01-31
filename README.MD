## To Build
```shell script
mvn clean compile assembly:single
```

## To Run
```shell script
java -jar target/HoolahTest-1.0-jar-with-dependencies.jar
```

# To Change CSV file
Go to the main-class (me.duvu.hoolah.Main.java) and change provide a file-path to variable filename, or copy your data file into root of project and rename it "input.csv"