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
                    header.textContent = "Booking name: " + el.name;
                    elem.appendChild(header);
                    el.customers.forEach(customers => {
                        console.log(submitBooking()) // print all bookings for each customer
                        let customerName = document.createElement('p');
                        let email = document.createElement('p');
                        customerName.textContent = "customerName: " + customers.name;
                        email.textContent = "Email: " + customers.email;
                        elem.appendChild(customerName);
                        elem.appendChild(email);
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
    req.open("GET", "http://localhost:8080/getAllCustomer");
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
        name: obj.name, email: obj.email, phoneNumber: Number(obj.phoneNumber),booking:{id:Number(obj.bookingid)}}));
}
