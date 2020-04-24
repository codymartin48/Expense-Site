
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/ExpenseReimbursement/MyEmployeesPendingRequests', true);
		xhr.send();

		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				console.log("readystate changed");
				let pending = JSON.parse(xhr.response);
			   
				for(let p of pending){
					let div = document.getElementById('tables');
					let table = document.createElement('table');
					let tbody = document.createElement('tbody');
					let form = document.createElement('form');
					let tr = document.createElement('tr');
					let amount = document.createElement('td');
					let requester = document.createElement('td');
					let description = document.createElement('td');
					let imageFrame = document.createElement('td');
					let approve = document.createElement('button');
					let approveFrame = document.createElement('td');
					let denyFrame = document.createElement('td');
					let deny = document.createElement('button');
					let image = document.createElement('img');

					table.className= "table";
					table.border = 1;
					image.src = "data:image/png;base64," + p["receipt"];
					image.style="width:100px;height:100px";
					amount.style="width:150px;height:100px";
					requester.style="width:150px;height:100px";
					description.style="width:250px;height:100px";
					approve.style="width:100px;height:100px";
					deny.style="width:100px;height:100px";
					
					
					amount.innerHTML = "$" + p["amount"];
					requester.innerHTML = p["requester"];
					description.innerHTML = p["description"];
					imageFrame.innerHTML = image;
					approve.innerHTML = "Approve";
					deny.innerHTML = "Deny";

					approve.onclick = function(){

	 	                var axhr = new XMLHttpRequest();
	 	                axhr.open('POST', '/ExpenseReimbursement/ApproveRequest', true);
	 	                axhr.setRequestHeader("id", p["id"]);
	 	                axhr.setRequestHeader("resolution", "APPROVED")
	 	                axhr.send();
	 	                
                        var index = this.parentElement.rowIndex;
                        console.log(index);
                        table.deleteRow(index-1);
					}
					
					deny.onclick = function(){

	 	                var axhr = new XMLHttpRequest();
	 	                axhr.open('POST', '/ExpenseReimbursement/ApproveRequest', true);
	 	                axhr.setRequestHeader("id", p["id"]);
	 	                axhr.setRequestHeader("resolution", "DENIED")
	 	                axhr.send();
	 	                
                        var index = this.parentElement.rowIndex;
                        console.log(index);
                        table.deleteRow(index-1);
					}
					
					approveFrame.appendChild(approve);
					denyFrame.appendChild(deny);
					
					tr.appendChild(amount);
					tr.appendChild(requester);
					tr.appendChild(description);
					tr.appendChild(image);
					tr.appendChild(approveFrame);
					tr.appendChild(denyFrame);
					
					tbody.appendChild(tr);
					table.appendChild(tbody);
					form.appendChild(table);
					tables.appendChild(form)
					}
			}
		}/**
 * 
 */