#!/usr/bin/env groovy // let your editor detect you are working with groovy script

def call () {
    echo 'building the application...'
    sh 'mvn package'
}