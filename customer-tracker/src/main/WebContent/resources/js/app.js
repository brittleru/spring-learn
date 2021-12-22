const addCustomerButton = document.getElementById("customerButton");

// const deleteCustomerButton = document.getElementById("deleteCustomer");
console.log("test script");

function addCustomer() {
    window.location.href="add";
    return false;
}



// function deleteCustomer() {
//     console.log("test delete");
//     return confirm('Are you sure you want to delete this customer?');
// }

addCustomerButton.addEventListener("click", addCustomer);
// deleteCustomerButton.addEventListener("click", deleteCustomer);
