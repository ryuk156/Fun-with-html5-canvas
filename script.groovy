#!/usr/bin/env groovy

import groovy.json.JsonSlurperClassic 
import static groovy.io.FileType.FILES

def fetch() {
	
	def response = sh(script: 'curl -s https://api.github.com/users/ryuk156/repos', returnStdout: true).trim()
	def json = new groovy.json.JsonSlurperClassic().parseText(response)
    
    def repos=[]

   json.each {
		repos << it.name
	}
	
	//println(repos)


		dir('meta-data') {
			git url: 'https://github.com/ryuk156/Amazon-Clone-React.js'
		}
   
   repos.each {
			dir(it) {
				git url: "https://github.com/ryuk156/${it}"
				sh'ls -l'
                exec()
			}
		}

}



def exec(){
	 def requiredFile = "./module.txt"
	 def indexdir = "../meta-data/"
	            if(fileExists(requiredFile)) {
                  
                  moduleData = readFile(requiredFile)
                  moduleDataToJson = new groovy.json.JsonSlurperClassic().parseText(moduleData)
                  moduleName = moduleDataToJson.get("id")
                  println(moduleName)
                  moduleDir = new File(indexdir + moduleName.toString())
                  
                  sh "mkdir ${moduleDir}"
                  
                  moduleSrc=moduleData
                  moduleDest= writeFile(moduleDir.toString()+"/module.txt")

                  println("fetched module data")

                  
                  
                  

	            }else{
	            	println "The following repository is not a module."
	            	
	            }
}



return this