# Overview
> Java SDK is a Java development kit for PlatONE public chain provided by PlatONE for Java developers.

# Build
```
    git clone https://github.com/PlatONEnetwork/client-sdk-java.git
    cd client-sdk-java/
    ./gradlew clean jar            //Generate jar package
	./gradlew clean distZip        //Generate code generation skeleton tool
    ./gradlew -Pintegration-tests=true :integration-tests:test    //To run the integration tests:
   
``` 

# Use

* config maven repository:  https://sdk.platone.network/nexus/content/groups/public/
* config maven or gradle in project

```
<dependency>
    <groupId>com.platone.client</groupId>
    <artifactId>core</artifactId>
    <version>0.11.0.1</version>
</dependency>
```

or

```
compile "com.platone.client:core:0.11.0.1"
```

* use in project

```
Web3j web3 = Web3j.build(new HttpService("https://host:port"));
```


# Other
[more reference wiki](https://github.com/PlatONEnetwork/wiki/wiki)