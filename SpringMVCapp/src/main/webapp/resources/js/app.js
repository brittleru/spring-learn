const changeText = document.getElementById('change-text');
const clickMe = document.getElementById('click-me');
console.log("medi e cute");

function changeColor() {
  clickMe.style.color = "purple";
  changeText.style.color = "purple";
}

clickMe.addEventListener("click", changeColor);
