#!/usr/bin/env groovy

import groovy.json.JsonSlurperClassic 
import java.io.File 


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
				
                exec()
			}
		}

}

@NonCPS 
def exec(){
	 def requiredFile = "./module.txt"
	 def indexdir = "../meta-data/"
	            if(fileExists(requiredFile)) {
                  
                  moduleData = readFile(requiredFile)
                  moduleDataToJson = new groovy.json.JsonSlurperClassic().parseText(moduleData)
                  moduleName = moduleDataToJson.get("id")
                  println(moduleName)
                  moduleDir = new File(indexdir + moduleName.toString())
                  moduleDir.mkdir()
                 
                  
                  moduleSrc = moduleData
                 
	           	  moduleDst = writeFile(moduleDir.toString() + "/module.txt")

                
                  dir = new File('./')

                 
		
		dir.eachFile { file ->
	    	if(file.name.endsWith('.md') || file.name.endsWith('.markdown') || file.name.endsWith('.MD') || file.name.endsWith('.MARKDOWN')) {
	    		println "README Found."
				
	    	}else{
	    		println("no")
	    	}
		}
                 
                



                  

                   
                  
                  

	            }else{
	            	println "The following repository is not a module."
	            	
	            }
}



return this