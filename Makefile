all: run

clean:
        rm -f out/Bluck.jar out/CheckPrimeNumber.jar

out/FileInput.jar: out/parcs.jar src/FileInput.java
        @javac -cp out/parcs.jar src/FileInput.java
        @jar cf out/FileInput.jar -C src FileInput.class
        @rm -f src/FileInput.class

out/Bluck.jar: out/parcs.jar src/Bluck.java src/CheckPrimeNumber.java src/FileInput.java
        @javac -cp out/parcs.jar src/Bluck.java src/CheckPrimeNumber.java src/FileInput.java
        @jar cf out/Bluck.jar -C src Bluck.class -C src CheckPrimeNumber.class -C src FileInput.class
        @rm -f src/Bluck.class src/CheckPrimeNumber src/FileInput.class

out/CheckPrimeNumber.jar: out/parcs.jar src/CheckPrimeNumber.java src/FileInput.java
        @javac -cp out/parcs.jar src/CheckPrimeNumber.java src/FileInput.java
        @jar cf out/CheckPrimeNumber.jar -C src CheckPrimeNumber.class -C src FileInput.class
        @rm -f src/CheckPrimeNumber.class src/FileInput.class

build: out/Bluck.jar out/CheckPrimeNumber.jar out/FileInput.jar

run: out/Bluck.jar out/CheckPrimeNumber.jar out/FileInput.jar
        @cd out && java -cp 'parcs.jar:Bluck.jar:CheckPrimeNumber.jar' Bluck
