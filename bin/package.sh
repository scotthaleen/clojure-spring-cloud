lein clean
lein compile

# build BOOT-INF
# configured in project.clj "target/spring-boot/BOOT-INF/lib"
lein libdir
#mkdir -p target/spring-boot/BOOT-INF
cp -R target/classes target/spring-boot/BOOT-INF/classes

cd target/spring-boot

jar xvf ../../dist/spring-boot-loader-1.4.1.RELEASE.jar org

cd -

jar cm0vf dist/META-INF/MANIFEST.MF target/boot.jar -C target/spring-boot BOOT-INF -C target/spring-boot org
