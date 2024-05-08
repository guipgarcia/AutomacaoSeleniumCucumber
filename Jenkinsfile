pipeline{
    agent any
     tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "jenkins-maven"
    }
    stages{
        stage('Test'){
            steps{
                dir('SeleniumTraining_DemoWebshop_Sampleapp'){
                    container ('maven'){
                        sh 'mvn version'
                    }
                }
            }
        }
    }
}
