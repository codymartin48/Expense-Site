var xhr = new XMLHttpRequest();
		xhr.open('GET', '/ExpenseReimbursement/GetAllEmployees', true);
		xhr.send();

		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				console.log("readystate changed");
				let pending = JSON.parse(xhr.response);
			   
				for(let p of pending){
					let tr = document.createElement('tr');
					let firstname = document.createElement('td');
					let lastname = document.createElement('td');
					let username = document.createElement('td');
					let manager = document.createElement('td');
					

					
					
					
					firstname.innerHTML =  p["firstName"];
					lastname.innerHTML = p["lastName"];
					username.innerHTML = p["username"];
					manager.innerHTML = p["manager"];
						
					tr.appendChild(firstname);
					tr.appendChild(lastname);
					tr.appendChild(username);
					tr.appendChild(manager);
					tbody.appendChild(tr);
					}
			}
		}