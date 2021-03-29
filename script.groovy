#!/usr/bin/env groovy


def fetch() {
	
	def response = sh(script: 'curl -s https://api.github.com/users/$USER/repos', returnStdout: true).trim()
	def json = new groovy.json.JsonSlurperClassic().parseText(response)
    
    println(json)
}

return this