java -Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=2048M -jar `dirname $0`/sbt-launch.jar "$@"
