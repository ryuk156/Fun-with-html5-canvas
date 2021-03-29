#!/usr/bin/env groovy

import groovy.json.JsonSlurper
import static groovy.io.FileType.FILES

def fetch() {
	
	def response = sh(script: 'curl -s https://api.github.com/users/ryuk156/repos', returnStdout: true).trim()
	def json = new JsonSlurper().parseText(response)
    
    def repos=[]

   json.each {
		repos << it.name
	}
	
	//println(repos)
   
   repos.each {
			dir(it) {
				git url: "https://github.com/ryuk156/${it}"
	            def requiredFile = "./module.txt"
	            if(fileExists(requiredFile)) {
                  
                  moduleData= readFile(requiredFile)
                  moduleDataToJson = new JsonSlurper().parseText(moduleData)
                  moduleName= moduleDataToJson.get("id")
                  moduleDir= new File(moduleName.toString())
                  moduleDir.mkdir()
                    

	            }else{
	            	println "The following repository is not a module."
	            	
	            }
			}
		}

}

return this