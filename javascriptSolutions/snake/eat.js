/**
 * @author Bohan Zheng
 */

// direction 1 = right, 2 = down, 3 = left, 4 = up
var r1 = new Rect(0, 0, 1);
var r2 = new Rect(1, 0, 1);
var r3 = new Rect(2, 0, 1);
var r4 = new Rect(3, 0, 1);
var r5 = new Rect(4, 0, 1);
var r6 = new Rect(5, 0, 1);
var r7 = new Rect(6, 0, 1);

// Snake class

function Snake(X, Y) {
	this.X = X; // x boundary
	this.Y = Y; // y boundary
	this.exp = 0;
	this.speed = 200;
	this.snake = [ r1, r2, r3, r4, r5, r6, r7 ];
	this.turns = [];
	this.food = [];
	this.c = document.getElementById("myCanvas");
	this.ctx = this.c.getContext("2d");
}
Snake.prototype.generateFood = function() {
	var x = Math.floor(Math.random() * this.X);
	var y = Math.floor(Math.random() * this.Y);
	var newFood = new Rect(x, y)
	if (this.snake.contains(newFood) == null) {
		console.log(newFood.x + ", " + newFood.y)
		this.food.push(newFood);
	} else {
		this.generateFood();
	}
};
Snake.prototype.draw = function() {
	for (i = 0; i < this.snake.length; i++) {
		var x = this.snake[i].x * 10;
		var y = this.snake[i].y * 10;
		this.ctx.fillRect(x, y, 10, 10);
	}
	this.ctx.fillRect(this.food[0].x * 10, this.food[0].y * 10, 10, 10);
};
Snake.prototype.forward = function() {
	for (var i = 0; i < this.snake.length; i++) {
		var d = this.snake[i].direction;
		if (d === 1) {
			this.snake[i].x++;
			var turn = this.turns.contains(this.snake[i]);
			if (turn) {
				var turnTo = turn.direction;
				this.snake[i].direction = turnTo;
			}
			if (this.snake[i].x >= this.X) {
				this.snake[i].x = 0;
			}
		} else if (d === 2) {
			this.snake[i].y++;
			var turn = this.turns.contains(this.snake[i]);
			if (turn) {
				var turnTo = turn.direction;
				this.snake[i].direction = turnTo;
			}
			if (this.snake[i].y >= this.Y) {
				this.snake[i].y = 0;
			}
		} else if (d === 3) {
			this.snake[i].x--;
			var turn = this.turns.contains(this.snake[i]);
			if (turn) {
				var turnTo = turn.direction;
				this.snake[i].direction = turnTo;
			}
			if (this.snake[i].x < 0) {
				this.snake[i].x = this.X;
			}
		} else if (d === 4) {
			this.snake[i].y--;
			var turn = this.turns.contains(this.snake[i]);
			if (turn) {
				var turnTo = turn.direction;
				this.snake[i].direction = turnTo;
			}
			if (this.snake[i].y < 0) {
				this.snake[i].y = this.Y;
			}
		}
	}
	this.ctx.clearRect(0, 0, 400, 400);
	var head = this.snake[this.snake.length - 1];
	// if eat a node
	if (head.equals(this.food[0])) {
		this.eatFood();
		this.generateFood();
	}
	// checkgame over
	if (this.snake.contains(createTurn(head)) != null) {
		this.stop();
		this.draw();
		alert("GAME OVER!");
	}
	// remove used turns
	if (this.turns.length > 0 && this.snake.contains(this.turns[0]) == null) {
		this.turns.shift();
	}
	this.draw();
};
Snake.prototype.init = function() {
	this.generateFood();
	this.interval = setInterval((function(self) {
		return function() {
			self.forward();
		};
	})(this), this.speed);
};
Snake.prototype.stop = function() {
	clearInterval(this.interval);
};
Snake.prototype.eatFood = function() {
	this.food.pop();
	var tail = this.snake[0];
	var x = tail.x;
	var y = tail.y;
	var dir = tail.direction;
	if (dir == 1) {
		x--;
	} else if (dir == 2) {
		y--
	} else if (dir == 3) {
		x++;
	} else if (dir == 4) {
		y++;
	}
	var body = new Rect(x, y, dir);
	this.snake.unshift(body);
	this.exp++;
	if (this.exp > 10) {
		this.speed = this.speed * 0.8;
		this.exp = 0;
	}
};
// rect class
function Rect(x, y, direction) {
	this.x = x;
	this.y = y;
	this.direction = direction;
}
Rect.prototype.equals = function(rect) {
	var bx = this.x === rect.x;
	var by = this.y === rect.y;
	return bx && by;
};

// add a contains function to Array object
Array.prototype.contains = function(rect) {
	for (var i = 0; i < this.length; i++) {
		if (rect.equals(this[i])) {
			return this[i];
		}
	}
	return null;
};

function createTurn(rect, direct) {
	var t;
	if (rect.direction == 1) {
		t = new Rect(rect.x + 1, rect.y, direct);
	} else if (rect.direction == 2) {
		t = new Rect(rect.x, rect.y + 1, direct);
	} else if (rect.direction == 3) {
		t = new Rect(rect.x - 1, rect.y, direct);
	} else if (rect.direction == 4) {
		t = new Rect(rect.x, rect.y - 1, direct);
	}
	return t;
}
window.onload = function() {
	var mySnake = new Snake(40, 40);
	mySnake.init();

	// listen to keyboard event
	window.onkeyup = function(e) {
		var snakeHead = mySnake.snake[mySnake.snake.length - 1];
		var direct;
		var key = e.keyCode ? e.keyCode : e.which;
		if (key == 37) {
			// left
			direct = 3;
			if (snakeHead.direction != direct && snakeHead.direction != 1) {
				var t = createTurn(snakeHead, direct);
				mySnake.turns.push(t);
			}
		} else if (key == 38) {
			// up
			direct = 4;
			if (snakeHead.direction != direct && snakeHead.direction != 2) {
				var t = createTurn(snakeHead, direct);
				mySnake.turns.push(t);
			}
		} else if (key == 39) {
			// right
			direct = 1;
			if (snakeHead.direction != direct && snakeHead.direction != 3) {
				var t = createTurn(snakeHead, direct);
				mySnake.turns.push(t);
			}
		} else if (key == 40) {
			// down
			direct = 2;
			if (snakeHead.direction != direct && snakeHead.direction != 4) {
				var t = createTurn(snakeHead, direct);
				mySnake.turns.push(t);
			}
		}
	}
};
