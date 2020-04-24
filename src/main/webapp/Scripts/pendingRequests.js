function myPending(){
	System.out.println("running");
	var xhr = new XMLHttpRequest();

	let tbody = document.getElementById('tbody');

		
	let pending = JSON.parse(xhr.response);
		
	for(let p of pending){
		let tr = document.createElement('tr');
		let amount = document.createElement('td');
		let requester = document.createElement('td');
		let description = document.createElement('td');
		let image = document.createElement('td');
			
		amount.innerHTML = p["amount"];
		requester.innerHTML = p["requester"];
		description.innerHTML = p["description"];
		image.innerHTML = p["image"];
			
		tr.appendChild(amount);
		tr.appendChild(requester);
		tr.appendChild(description);
		tr.appendChild(image);
		tbody.appendChild(tr);
		}
		
		
	
	xhr.open('GET', '/ExpenseReimbursement/MyRequests', true);
	xhr.send();
}

window.onload = function(){
	console.log('This runs when the window loads.');
}

