pipeline{
    agent any
    stages{
        stage("Test"){
            steps{
                dir('SeleniumTraining_DemoWebshop_Sampleapp'){
                    withMaven(
                        // Maven installation declared in the Jenkins "Global Tool Configuration"
                        maven: 'maven-3') {
                        sh 'mvn -B package --file pom.xml test'
                    }
                }
            }
        }
    }
}
