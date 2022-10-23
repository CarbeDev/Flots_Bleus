const burgerIcon = document.querySelector(".navbar-burger");
const navbarMenu = document.querySelector("#navbarMenuHeroB");

burgerIcon.addEventListener("click", () => {
  navbarMenu.classList.toggle("is-active");
});
