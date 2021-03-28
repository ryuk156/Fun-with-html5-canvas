#!/usr/bin/env groovy


def fetch() {

	def response = sh(script: 'curl https://api.github.com/users/ryuk156/repos', returnStdout: true)
	println(response.size())
}

return this