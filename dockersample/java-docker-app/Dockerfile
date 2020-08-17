FROM maven:3.6.0-jdk-8
COPY . /sample_programs
WORKDIR /sample_programs
RUN javac SampleOne.java
RUN javac SampleTwo.java
CMD ["java", "SampleOne"]

