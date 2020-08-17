FROM    maven:3.6.0-jdk-8
RUN     mkdir /functional-assurance
WORKDIR /functional-assurance
COPY    . .
RUN ls
CMD mvn clean test -Dcucumber.options="--tags '@UITest and @Smoke'" -DexecutionPlatform="GRID_CHROME"