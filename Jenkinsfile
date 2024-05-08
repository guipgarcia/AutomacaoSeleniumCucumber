pipeline{
    agent any
    stages{
        stage('Install maven'){
            steps{
                sh 'java -jar /var/jenkins_home/workspace/git-pipeline/target/SeleniumTraining_DemoWebshop_Sampleapp 1.0-SNAPSHOT.jar'
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
