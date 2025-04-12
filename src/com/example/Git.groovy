#!/usr/bin/env groovy
package com.example

class Git implements Serializable {

    def script

    Git(script) {
        this.script = script
    }

    def commitUpdate() {
            script.withCredentials([script.usernamePassword(credentialsId: 'github-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                script.sh 'git config --global user.email "jenkins@example.com"'
                script.sh 'git config --global user.name "jenkins"'

                //script.sh 'git status'
                //script.sh 'git branch'
                //script.sh 'git config --list'

                script.sh "git remote set-url origin https://${script.USER}:${script.PASS}@github.com/victordgr8t/java-maven-app.git"
                script.sh 'git add .'
                script.sh 'git commit -m "ci: version bump"'
                script.sh 'git push origin HEAD:jenkinsjobs'
            }
        }
    }