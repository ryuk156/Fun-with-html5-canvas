
var canvas = document.querySelector('canvas');


canvas.width= window.innerWidth;
canvas.height= window.innerHeight;



var c = canvas.getContext('2d');



var colorArray=[
  'Red',
  '#90F78A',
  '#8020C1',
  '#37B8E0',
  '#FF503B',
   '#FFC112',

]

var mouse={

	x:undefined,
	y:undefined,
}

window.addEventListener('mousemove',function(event){


	mouse.x=event.x;
	mouse.y=event.y;
})




function Circle(x,y,dx,dy,radius){
	this.x=x;
	this.y=y;
	this.dx=dx;
	this.dy=dy;
    this.radius=radius;
    this.minradius=radius;
    this.color=colorArray[Math.floor(Math.random()*colorArray.length)];
	this.draw= function(){

	c.beginPath()
	c.arc(this.x,this.y,this.radius,0,Math.PI * 2,false);
    c.fillStyle=this.color;
    c.strokeStyle=this.color;
    c.fill()
    c.stroke()

	}

	this.update= function(){

        if(this.x + this.radius>innerWidth|| this.x- this.radius <0){
	        this.dx=-this.dx
              }
        if(this.y + this.radius>innerHeight||this.y- this.radius <0){
	        this.dy=-this.dy
              }

        this. x+=this.dx;
         this.y+=this.dy;

        if(mouse.x-this.x<50 && mouse.x-this.x> -50 && mouse.y-this.y<50 && mouse.y-this.y>-50 && this.radius<50){
        	this.radius +=1;
        }else if (this.radius >this.minradius){
        	this.radius-=1;
        }
         this.draw();
     }
     

}

var circleArray =[];

for(var i=0; i<800 ;i++){
	var x=Math.random()*(innerWidth -radius *2)+radius;
    var y=Math.random()*(innerHeight -radius *2)+radius;
    var dx=(Math.random()*-0.5);
    var dy=(Math.random()*-0.5);
    var radius=Math.random()*3+1;
	circleArray.push(new Circle(x,y,dx,dy,radius));

}
function animate(){
	requestAnimationFrame(animate);
	c.clearRect(0,0,innerWidth,innerHeight)
	for (var i = 0; i < circleArray.length; i++) {
		circleArray[i].update();
	}
	
	
}

animate();








window.addEventListener('keydown',this.check,false);

function check(e) {
    if (e.keyCode == "39"){
        rect()
      x+=dx

    }else if (e.keyCode == "38"){
        rect()
      y+=-dy

    }else if (e.keyCode == "40"){
        rect()
      y+=dy

    }else if (e.keyCode == "37"){
        rect()
      x+=-dx

    }
}
 
