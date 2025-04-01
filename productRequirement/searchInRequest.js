document.getElementById("search-button").addEventListener("click", function () {
    let partName = document.getElementById("part-name").value.toLowerCase();
    let carBrand = document.getElementById("car-brand").value.toLowerCase();
    let year = document.getElementById("year").value.toLowerCase();

    let parts = document.querySelectorAll(".part-item");

    parts.forEach(part => {
        let name = part.getAttribute("data-name").toLowerCase();
        let brand = part.getAttribute("data-brand").toLowerCase();
        let manufactureYear = part.getAttribute("data-year").toLowerCase();

        // Kiểm tra nếu tất cả điều kiện khớp hoặc nếu không nhập giá trị nào thì bỏ qua
        let matchName = partName === "" || name.includes(partName);
        let matchBrand = carBrand === "" || brand.includes(carBrand);
        let matchYear = year === "" || manufactureYear.includes(year);

        if (matchName && matchBrand && matchYear) {
            part.style.display = "block"; // Hiển thị nếu khớp
        } else {
            part.style.display = "none";  // Ẩn nếu không khớp
        }
    });
});
