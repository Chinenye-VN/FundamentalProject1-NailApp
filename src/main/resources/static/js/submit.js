function displayCustomers(){
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {

        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {
                console.log("oh look its some JSON: " + req.responseText);


                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {
                    let elem = document.createElement('div');
                    let header = document.createElement('h1');
                    header.textContent = "Booking name: " + "Acrylic Nail Set";
                    elem.appendChild(header);
                    el.customers.forEach(customer => {
                        let customerName = document.createElement('p');
                        let email = document.createElement('p');
                        let phoneNumber = document.createElement('p');
                        let deleteCust = document.createElement('button');
                        deleteCust.addEventListener("click", function (){
                            deleteCustomer(customer.id);
                            location.reload();
                        });
                        // let update = document.createElement('button');
                        // update.addEventListener("click", function (){
                        //     updateCustomer(customer.id);
                        //     location.send()
                        // })

                        customerName.textContent = "Customer Name: " + customer.name;
                        email.textContent = "Email: " + customer.email;
                        phoneNumber.textContent = "Phone Number:" + customer.phoneNumber;
                        deleteCust.textContent = "Delete";
                        //update.textContent = "Update"
                        elem.appendChild(customerName);
                        elem.appendChild(email);
                        elem.appendChild(phoneNumber);
                        elem.appendChild(deleteCust);
                        //elem.appendChild(update);

                    })
                    document.body.appendChild(elem);
                });
            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://localhost:8080/getAllBooking");
    req.send();
}

function submitBooking(){
    let elements = document.getElementById("bookingForm").elements;
    let obj ={};
    for(let i = 0 ; i < elements.length - 1 ; i++){
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("POST", "http://localhost:8080/createCustomer");
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Oops...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({
        name: obj.name, email: obj.email, phoneNumber:obj.phoneNumber,booking:{id:Number(obj.bookingid)}}));
}
function deleteCustomer(id) {

    const req = new XMLHttpRequest();
    req.open("DELETE", "http://localhost:8080/deleteCustomer/" + id);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);
        } else {
            console.log("Customer doesn't exist...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send();
}