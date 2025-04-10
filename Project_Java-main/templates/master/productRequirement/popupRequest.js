document.addEventListener("DOMContentLoaded", function () {
    fetch("popupRequest.html")
        .then(response => response.text())
        .then(data => {
            document.body.insertAdjacentHTML("beforeend", data);
            addPopupEvents(); // Gọi ngay khi popup được thêm vào
        });

    function addPopupEvents() {
        const popup = document.getElementById("popup");
        const requestBtn = document.querySelector(".post-ad");
        const closeBtn = document.querySelector(".close-btn");

        if (!popup || !requestBtn || !closeBtn) {
            console.error("Không tìm thấy popup hoặc nút yêu cầu!");
            return;
        }

        requestBtn.addEventListener("click", function () {
            popup.style.display = "flex";
        });

        closeBtn.addEventListener("click", function () {
            popup.style.display = "none";
        });

        window.addEventListener("click", function (event) {
            if (event.target === popup) {
                popup.style.display = "none";
            }
        });

        // Gán sự kiện tìm kiếm
        const searchBtn = document.getElementById("search-button");

        if (!searchBtn) {
            console.error("Không tìm thấy nút tìm kiếm!");
            return;
        }

        searchBtn.addEventListener("click", function (event) {
            event.preventDefault(); // Ngăn form submit làm reload trang

            let searchName = document.getElementById("part-name").value.trim().toLowerCase();
            let searchBrand = document.getElementById("car-brand").value.trim().toLowerCase();
            let searchYear = document.getElementById("year").value.trim();

            let parts = document.querySelectorAll(".part-item");
            let found = false;
            let noResultMessage = document.getElementById("no-results");

            if (!noResultMessage) {
                noResultMessage = document.createElement("div");
                noResultMessage.id = "no-results";
                noResultMessage.style.display = "none";
                noResultMessage.style.textAlign = "center";
                noResultMessage.style.color = "red";
                noResultMessage.style.marginTop = "10px";
                noResultMessage.innerText = "Không tìm thấy sản phẩm nào phù hợp.";
                document.querySelector(".parts-list").appendChild(noResultMessage);
            }

            parts.forEach(part => {
                let name = part.getAttribute("data-name").toLowerCase();
                let brand = part.getAttribute("data-brand").toLowerCase();
                let year = part.getAttribute("data-year");

                let matchName = searchName === "" || name.includes(searchName);
                let matchBrand = searchBrand === "" || brand.includes(searchBrand);
                let matchYear = searchYear === "" || year.includes(searchYear);

                if (matchName && matchBrand && matchYear) {
                    part.style.display = "block";
                    found = true;
                } else {
                    part.style.display = "none";
                }
            });

            noResultMessage.style.display = found ? "none" : "block";
        });
    }
});
