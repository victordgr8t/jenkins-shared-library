#!/usr/bin/env groovy

def call () {
    echo 'building the application...'
    sh 'mvn clean package' // makes sure we have one single jar file to avoid error with DockerFile
}