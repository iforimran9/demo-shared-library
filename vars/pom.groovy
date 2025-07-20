def call(String pomFile = 'pom.xml', String newVersion = '1.7') {
    // Read pom.xml content
    def pomContent = readFile(pomFile)

    // Use regex to update the <source> and <target> values inside maven-compiler-plugin
    pomContent = pomContent.replaceAll(
        /(<artifactId>maven-compiler-plugin<\/artifactId>.*?<source>)([^<]+)(<\/source>)/s,
        "\$1${newVersion}\$3"
    ).replaceAll(
        /(<artifactId>maven-compiler-plugin<\/artifactId>.*?<target>)([^<]+)(<\/target>)/s,
        "\$1${newVersion}\$3"
    )

    // Write the updated content back to pom.xml
    writeFile file: pomFile, text: pomContent

    echo "maven-compiler-plugin updated to source/target ${newVersion} in ${pomFile}"
}

