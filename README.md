# Web3j Unit Test

<p> This is a very basic visual introduction to the concepts about EVMTest. </p>

## Setup
Get the code:

```
git clone git@github.com:chainerist/web3j-unit-test-example.git
```

## Add Mvn Setting XML

We should add beus artificial management plugin our mvn setting.xml

###### Repository
```
<repository>
    <id>besu-maven</id>
    <name>besu-maven</name>
    <url>https://hyperledger.jfrog.io/artifactory/besu-maven/</url>
</repository>
```

###### Plugin
```
<pluginRepository>
    <id>besu-mavent</id>
    <url>https://hyperledger.jfrog.io/artifactory/besu-maven/</url>
</pluginRepository>

```

## Install dependencies:

```
mvn clean

```

```
mvn install -U 

```

## Notice 

if your operating system is **Windows** you should install solc compiler manually otherwise your mvn install or generate command will be fail

#### Setup 

Go to solc compiler relaase page

```
https://github.com/ethereum/solidity/releases?page=2
```

> Click collepsable assert then download and install solc-windows.exe

###### Configure Sloc Relese.json  

Open **releases.json** of web3j then add your solc compiler version in file

> your releases.json file location is /user/your-username/.web3j/sloc

You should configure file as below

```
{"version":"0.8.7","windows_url":"https://github.com/ethereum/solidity/releases/download/v0.8.7/solc-windows.exe","mac_url":"https://github.com/ethereum/solidity/releases/download/v0.8.7/solc-macos","linux_url":"https://github.com/ethereum/solidity/releases/download/v0.8.7/solc-static-linux"}

```


then, you should repeat install dependencies step again, your compiler will success
