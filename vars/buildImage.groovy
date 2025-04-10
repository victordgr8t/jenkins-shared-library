#!/usr/bin/env groovy

def call () {
    echo 'building the the docker image...'
    withCredentials([usernamePassword(credentialsId: 'DOCKER-LOGIN', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t vicdg8t/my-repo:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push vicdg8t/my-repo:jma-2.0'
    }
}

