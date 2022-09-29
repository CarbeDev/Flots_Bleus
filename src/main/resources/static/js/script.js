function changeUrl(selected) {
  document.location.href = "http://localhost:9000/equipage?id=" + selected;
}

let dropdown = document.querySelector(".dropdown");
dropdown.addEventListener("click", (event) => {
  event.stopPropagation();
  dropdown.classList.toggle("is-active");
});

// document.addEventListener("click", () => {
//   menu.classList.remove("is-active");
// });
