function main() {
	var x = 5;
	console.log(x);

	function sub1() {
		var y = x + 10;
		console.log(y);

		function sub2() {
			var z = (y + x) * 2;
			console.log(z);

			function sub3() {
				var sum = x + y + z;
				console.log(sum);
				console.log(' x = '+ x + '\n y = ' + y +
				            '\n z = '+ z +  '\n sum = ' + sum);
			}
			sub3();
		}
		sub2();
	}
	sub1();
}
main();