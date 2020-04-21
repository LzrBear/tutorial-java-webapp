#!/bin/bash
rm -rf target/
mkdir target

echo "Building HelloWorld"
cd hello/helloworld
mvn clean install
echo "Done"
cd ../..

echo "Building Web Service"
cd webservice
mvn clean install
echo "Done"
mv target/*.war ../target
cd ..


echo "Building UI"
cd ui
mvn clean install
echo "Done"
mv target/*.war ../target
cd ..