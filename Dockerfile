FROM amazonlinux:2

# Installing the required libraries

RUN yum install -y bash gcc gcc-c++ gzip libc6-dev tar wget zip zlib zlib-devel zlib1g-dev

# Installing GraalVM

ENV JDK_VERSION java11
ENV GRAAL_VERSION 21.1.0
ENV GRAAL_FILENAME graalvm-ce-${JDK_VERSION}-linux-amd64-${GRAAL_VERSION}.tar.gz

RUN wget -nv -P /usr/lib/graalvm https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-${GRAAL_VERSION}/${GRAAL_FILENAME}
RUN tar -zxf /usr/lib/graalvm/${GRAAL_FILENAME} --strip=1 -C /usr/lib/graalvm

# Installing Native Image

RUN /usr/lib/graalvm/bin/gu install native-image

# Compiling .jar archive into native executable

ENV JAR_NAME KyivAirBot-0.0.1.jar
ENV EXE_NAME kyivairbot
ENV MAIN_CLASS org.example.KyivAirRuntime

COPY target/${JAR_NAME} /home
COPY bootstrap /home
COPY src/main/resources/img /home/img

WORKDIR /home

RUN /usr/lib/graalvm/bin/native-image --no-fallback --no-server -jar ${JAR_NAME} -H:Name=${EXE_NAME} -H:Class=${MAIN_CLASS}

RUN chmod 777 bootstrap
RUN chmod 777 ${EXE_NAME}
RUN zip ${EXE_NAME}.zip bootstrap ${EXE_NAME} img/*

EXPOSE 8080
ENTRYPOINT ["/home/${EXE_NAME}"]
