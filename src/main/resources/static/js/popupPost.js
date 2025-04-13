document.addEventListener("DOMContentLoaded", function () {
    fetch("popupNoiDungDangBanPhuTung.html")
        .then(response => response.text())
        .then(data => {
            document.body.insertAdjacentHTML("beforeend", data);
            setupPopupEvents();
        });

    function setupPopupEvents() {
        const popup = document.getElementById("popup");
        const postAdBtn = document.querySelector(".post-ad");
        const closeBtn = document.querySelector(".close-btn");
        const form = popup.querySelector("form");

        if (!popup || !postAdBtn || !closeBtn || !form) {
            console.error("Không tìm thấy popup hoặc các nút liên quan!");
            return;
        }

        postAdBtn.addEventListener("click", function () {
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

        form.addEventListener("submit", function (event) {
            event.preventDefault();

            const partName = document.getElementById("part-name").value;
            const carBrand = document.getElementById("car-brand").value;
            const year = document.getElementById("year").value;
            const price = document.getElementById("price").value;
            const description = document.getElementById("description").value;
            const image = document.getElementById("image-upload").files[0];

            console.log("Thông tin phụ tùng:", { partName, carBrand, year, price, description, image });

            const partsList = document.querySelector(".parts-list");
            const newPart = document.createElement("div");
            newPart.classList.add("part-item");
            newPart.innerHTML = `
                <img src="${image ? URL.createObjectURL(image) : 'placeholder.jpg'}" alt="${partName}">
                <h3>Bán: ${partName}</h3>
                <div class="part-details">
                    <span class="brand">${carBrand}</span>
                    <span class="year">${year}</span>
                    <span class="condition">Tình trạng: Mới</span>
                </div>
                <div class="price">Giá bán: ${price} VNĐ</div>
                <div class="description">Chú thích: ${description}</div>
                <button class="view-details">Xem chi tiết</button>
            `;
            partsList.appendChild(newPart);

            partsList.scrollTop = partsList.scrollHeight;
            popup.style.display = "none";
            form.reset();
        });
    }
});
