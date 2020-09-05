function updateCustomer(id) {
    let elements = document.getElementById("updateForm").elements;
    let obj = {};
    for (let i = 0; i < elements.length - 1; i++) {
        let item = elements.item(i);
        obj[item.name] = item.value;
    }

    const req = new XMLHttpRequest();
    req.open("PUT", "http://localhost:8080/updateCustomer/" + id);
    req.onload = () => {
        if (req.status === 200 && req.readyState === 4) {
            console.log("Server Responded with: " + req.responseText);

        } else {
            console.log("Customer doesn't exist...");
        }
    };
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send(JSON.stringify({ name: obj.name, email: obj.email, phoneNumber:obj.phoneNumber,booking:{id:Number(obj.bookingid)
    }}));
}