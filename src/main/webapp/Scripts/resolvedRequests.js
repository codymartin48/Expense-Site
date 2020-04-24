var xhr = new XMLHttpRequest();
		xhr.open('GET', '/ExpenseReimbursement/MyResolved', true);
		xhr.send();

		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				
				let pending = JSON.parse(xhr.response);
			  
				for(let p of pending){
					let tr = document.createElement('tr');
					let amount = document.createElement('td');
					let requester = document.createElement('td');
					let description = document.createElement('td');
					let imageFrame = document.createElement('td');
					let image = document.createElement('img');

					
					image.src = "data:image/png;base64," + p["receipt"];
					image.style="width:125px;height:150px";
					
					
					amount.innerHTML = "$" + p["amount"];
					requester.innerHTML = p["requester"];
					description.innerHTML = p["description"];
					imageFrame.innerHTML = image;
						
					tr.appendChild(amount);
					tr.appendChild(requester);
					tr.appendChild(description);
					tr.appendChild(image);
					tbody.appendChild(tr);
					}
			}
		}