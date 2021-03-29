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
   
   repos.each {
			dir(it) {
				git url: "https://github.com/ryuk156/${it}"
                exec()
			}
		}

}



def exec(){
	 def requiredFile = "./module.txt"
	            if(fileExists(requiredFile)) {
                  
                  moduleData= readFile(requiredFile)
                  moduleDataToJson = new groovy.json.JsonSlurperClassic().parseText(moduleData)
                  moduleName= moduleDataToJson.get("id")
                  println(moduleName)
                  moduleDir= new File(moduleName.toString())
                  x= moduleDir.mkdir()
                  if(x){
                  	println("created")
                  }else{
                  	println("not created")
                  }
                  
                    

	            }else{
	            	println "The following repository is not a module."
	            	
	            }
}



return this