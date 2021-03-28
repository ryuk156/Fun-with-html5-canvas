

package org.kohsuke.github
@Grab(group='org.kohsuke', module='github-api', version='1.75')
import org.kohsuke.github.GitHub


def build(){
	    def repos = []
		def org = 'ryuk156';
		def githubCom = GitHub.connectUsingOAuth('d759513fda2a314bf1e16f9805a06f6609ac4356');
		def repoList = new File('list.txt')
		
		githubCom.getOrganization(org).listRepositories().each {
			repoList.append(it.getName() + ",")
		}
}

def test(){
	writeFile file: 'groovy1.txt', text: 'Working with files the Groovy way is easy.'
	println("created")
}

def deploy(){
	echo'deploy'
}

return this