
### How to run the UI and RWD Tests

###### UI & API - Smoke Tests
```
$ mvn clean test -Dcucumber.options="--tags @Smoke" -DExecutionPlatform="AWS_CHROME"
```

###### API Tests :
```
$ mvn clean test -Dcucumber.options="--tags @APITest"
```

###### UI Tests
```
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="AWS_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="AWS_FIREFOX"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Search'" -DexecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags '@UITest and @Smoke'" -DexecutionPlatform="LOCAL_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="AWS_DEVICEFARM_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UITest" -DexecutionPlatform="AWS_DEVICEFARM_FIREFOX"

```

###### RWD Tests
```
$ mvn clean test -Dcucumber.options="--tags @UIRWDTest" -DexecutionPlatform="AWS_CHROME"
$ mvn clean test -Dcucumber.options="--tags @UIRWDTest" -DexecutionPlatform="AWS_DEVICEFARM_CHROME"

```