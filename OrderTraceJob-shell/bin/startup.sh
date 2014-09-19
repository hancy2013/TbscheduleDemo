# 跳转到脚本所在目录   
cd $(dirname "$0") || exit 1
cd ..
echo "java -jar lib/${project.artifactId}-${project.version}.jar  -xmode=release"
java -jar lib/${project.artifactId}-${project.version}.jar -xmode=release
