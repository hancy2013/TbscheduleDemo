##以后台程序运行 
# 跳转到脚本所在目录   
cd $(dirname "$0") || exit 1
nohup  ./startup.sh >/dev/null 2>service.log &
