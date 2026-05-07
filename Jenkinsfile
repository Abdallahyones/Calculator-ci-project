pipeline {
    agent any

    tools {
        jdk 'JDK 25'
        maven 'Maven 3.9'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/Abdallahyones/Calculator-ci-project.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }
}