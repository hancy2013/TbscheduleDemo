cd ..
echo java -jar lib/${project.artifactId}-${project.version}.jar  -xmod=release
start java -jar lib/${project.artifactId}-${project.version}.jar -xmod=release
