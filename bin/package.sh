#!/usr/bin/env bash

set -e


lein clean
lein compile

JAR=$( a=(dist/spring-boot-loader-*.jar); printf "${a[-1]}" )

if [[ ! -f ${JAR} ]]; then
    wget -P dist/ http://repo.spring.io/milestone/org/springframework/boot/spring-boot-loader/2.1.2.RELEASE/spring-boot-loader-2.1.2.RELEASE.jar

fi


# build BOOT-INF
# configured in project.clj "target/spring-boot/BOOT-INF/lib"
lein libdir
#mkdir -p target/spring-boot/BOOT-INF
cp -R target/classes target/spring-boot/BOOT-INF/classes

cd target/spring-boot

jar xvf ../../dist/spring-boot-loader-*.jar org

cd -

jar cm0vf dist/META-INF/MANIFEST.MF target/boot.jar -C target/spring-boot BOOT-INF -C target/spring-boot org
