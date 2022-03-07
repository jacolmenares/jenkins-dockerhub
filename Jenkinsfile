pipeline {
  agent any
  
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  
  environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhub')
  }
  stages {
    stage('Build') {
      steps {
        docker build -t jacolmenares/jenkins-test:$TAG_NAME .
      }
    }
    stage('Login') {
      steps {
        sh './jenkins/login.sh'
      }
    }
    stage('Push') {
      steps {
        docker push jacolmenares/jenkins-test:$TAG_NAME
      }
    }
  }
  post {
    always {
      sh './jenkins/logout.sh'
    }
  }
}
