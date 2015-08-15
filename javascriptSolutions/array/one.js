function question3(X, Y, Z, T) {
	var totalTime = 0;
	while (X > 0 && Y > 0 && Z > 0) {
		var delta = T;
		if (nearestKnight(X, Y, Z) === "X") {
			if (Y - T > 0) {
				Y = Y - T;
			} else {
				delta = Math.min(delta, Y);
				Y = 0;
			}

			if (Z - T > 0) {
				Z = Z - T;
			} else {
				delta = Math.min(delta, Z);
				Z = 0;
			}
			
		} else if (nearestKnight(X, Y, Z) === "Y") {
			if (X - T > 0) {
				X = X - T;
			} else {
				delta = Math.min(delta, X);
				X = 0;
			}

			if (Z - T > 0) {
				Z = Z - T;
			} else {
				delta = Math.min(delta, Z);
				Z = 0;
			}
		} else if (nearestKnight(X, Y, Z) === "Z") {
			if (Y - T > 0) {
				Y = Y - T;
			} else {
				delta = Math.min(delta, Y);
				Y = 0;
			}

			if (X - T > 0) {
				X = X - T;
			} else {
				delta = Math.min(delta, X);
				X = 0;
			}
		}
		totalTime += delta;
	}

	return totalTime;
}

function nearestKnight(X, Y, Z) {
	if (X <= Y && X <= Z) {
		return "X";
	}
	if (Y <= X && Y <= Z) {
		return "Y";
	}
	if (Z <= X && Z <= Y) {
		return "Z";
	}
}