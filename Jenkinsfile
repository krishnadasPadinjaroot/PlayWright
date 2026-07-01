pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            allure(
                includeProperties: false,
                jdk: '',
                commandline: 'allure',
                results: [[path: 'target/allure-results']]
            )
        }
    }
}