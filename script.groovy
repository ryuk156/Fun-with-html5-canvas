#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import static groovy.io.FileType.FILES

def fetch() {
	
	def response = sh(script: 'curl -s https://api.github.com/users/ryuk156/repos', returnStdout: true).trim()
	def json = new groovy.json.JsonSlurperClassic().parseText(response)
    
    def repos=[]

   json.each {
		repos << it.name
	}
	
	//println(repos)
   
   repos.each {
			dir(it) {
				git url: "https://github.com/ryuk156/${it}"
	            def moduleFile = "./module.txt"
	            if(fileExists(moduleFile)) {
                  
                  println("yes")

	            }else{
	            	println("no")
	            }
			}
		}

}

return this