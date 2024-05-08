pipeline{
    agent any
    stages{
        stage("Test"){
            steps{
                dir('SeleniumTraining_DemoWebshop_Sampleapp'){
                    withMaven(
                        // Maven installation declared in the Jenkins "Global Tool Configuration"
                        maven: 'maven-3', // (1)
                        // Use `$WORKSPACE/.repository` for local repository folder to avoid shared repositories
                        mavenLocalRepo: '.repository', // (2)
                        // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
                        // We recommend to define Maven settings.xml globally at the folder level using
                        // navigating to the folder configuration in the section "Pipeline Maven Configuration / Override global Maven configuration"
                        // or globally to the entire master navigating to  "Manage Jenkins / Global Tools Configuration"
                        mavenSettingsConfig: 'my-maven-settings' // (3)
                    ) {
                        sh 'mvn -B package --file pom.xml test'
                    }
                }
            }
        }
    }
}