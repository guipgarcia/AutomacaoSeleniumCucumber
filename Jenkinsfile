pipeline{
    agent any
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
