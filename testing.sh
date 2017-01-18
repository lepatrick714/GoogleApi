#!/bin/bash 
pdftotext data/pdf/aaroh_winter2017_schedule.pdf 

mv data/pdf/aaroh_winter2017_schedule.txt data/txt

cd src
javac ParseData.java
java ParseData ../data/txt/aaroh_winter2017_schedule.txt
echo "Done"
