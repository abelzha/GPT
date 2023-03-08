FROM artifacts.iflytek.com/cbg-docker-private/xfyun_webdev/skywalking-agent-java:v-agent-ignore-2
LABEL maintainer="junzhang27 <junzhang27@ilytek.com>"

ARG SPRING_PROFILE
# runtime配置最佳
# ENV APP_ENV="dev"
ENV JVM_OPTS="-Xms1024m -Xmx1024m -XX:MetaspaceSize=1024m -XX:MaxMetaspaceSize=1024m"
# jar拷到哪个目录就写哪个, 如果是/app, 可以不写
# 监听的端口
EXPOSE  8080

COPY target/meta-0.0.1.jar /app/