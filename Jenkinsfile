pipeline {
    agent any   // run on any available agent

    tools {
        maven 'maven3'   // configure this name in Jenkins "Global Tool Configuration"
        jdk 'jdk21'     // configure Java version in Jenkins tools
    }

    environment {
        DOCKERHUB_USER = 'your-dockerhub-username'
        DOCKERHUB_PASS = credentials('dockerhub-credentials') // Jenkins credential ID
    }

    stages {
        stage('Checkout') {
            steps {
                // pull source code from Git
                checkout scm
            }
        }

        stage('Build Backend') {
            steps {
                dir('backend2') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir('frontend2') {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Test') {
            steps {
                dir('backend2') {
                    sh 'mvn test'
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    sh """
                        echo $DOCKERHUB_PASS | docker login -u $DOCKERHUB_USER --password-stdin
                        docker build -t $DOCKERHUB_USER/frontend:latest ./frontend2
                        docker build -t $DOCKERHUB_USER/backend:latest ./backend2
                        docker push $DOCKERHUB_USER/frontend:latest
                        docker push $DOCKERHUB_USER/backend:latest
                    """
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished!'
        }
        failure {
            echo 'Build failed!'
        }
        success {
            echo 'Build succeeded!'
        }
    }
}
