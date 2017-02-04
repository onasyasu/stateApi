# stateApi
# deploy 
```
cf push state-api -p target/onasyasu-0.0.1-SNAPSHOT.jar
```
# curl
```
curl http://state-api.au-syd.mybluemix.net/state/clickableA
```
# 
```
//Aさんが音を流される状況かどうか.cronで常に叩かれる
 "getSoundableUserA":
//Aさんがクリックできる状況かどうか.dashButtonが押されたときに起動
 "clickableA":
 //Aさんが走り終えました.走り終わったときに叩かれる
 "endRunA":
 
 AをBに変えたらBさん用
 ```
