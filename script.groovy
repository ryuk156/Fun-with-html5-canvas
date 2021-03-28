def build(){
	def a= 40;
	def b= 60;
	def c= a+b;
	println(c)
}

def test(){
	writeFile file: 'groovy1.txt', text: 'Working with files the Groovy way is easy.'
	println("created")
}

def deploy(){
	echo'deploy'
}

return this