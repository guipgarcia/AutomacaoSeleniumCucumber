pipeline{
    agent any
        stage('Test'){
            steps{
                dir('SeleniumTraining_DemoWebshop_Sampleapp'){
                   sh 'mvn -B package --file pom.xml test'
                }
            }
        }
    }
}
