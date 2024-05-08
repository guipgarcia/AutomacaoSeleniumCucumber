pipeline{
    agent any
    stages{
        stage('Install maven'){
            steps{
                sh 'yum install maven'
            }
        }
        stage('Test'){
            steps{
                dir('SeleniumTraining_DemoWebshop_Sampleapp'){
                   sh 'mvn -B package --file pom.xml test'
                }
            }
        }
    }
}
