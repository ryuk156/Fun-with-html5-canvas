def build(){
	def a= 40;
	def b= 60;
	def c= a+b;
	println(c)
}

def test(){
	new File("test.txt");
	println("created")
}

def deploy(){
	echo'deploy'
}

return this