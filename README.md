
### How to run the UI Tests

###### UI Tests
```
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="GRID_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="GRID_FIREFOX"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="LOCAL_FIREFOX"
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Smoke'" -DexecutionPlatform="LOCAL_CHROME"

```
