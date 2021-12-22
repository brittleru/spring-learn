const addEmployeeButton = document.getElementById("employeeButton");


console.log("test addEmployee");

function addEmployee() {
    window.location.href="add";
    return false;
}


addEmployeeButton.addEventListener("click", addEmployee);
