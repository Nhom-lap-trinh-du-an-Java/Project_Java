document.addEventListener("DOMContentLoaded", function () {
    const searchBarContent = `
        <div class="search-container">
            <div class="search-bar">
                <span class="search-icon">🔍</span>
                <input type="text" placeholder="Tìm kiếm phụ tùng theo tên">
                <span class="clear-icon">✖</span>
            </div>
            <div class="header-icons">
                <a href="../search/login/login" class="account-icon" role="button" tabindex="0">👤</a>
                <a href="../search/master/cart" class="cart-icon" role="button" tabindex="0">🛒</a>
            </div>
        </div>
    `;

    // Tải thanh tìm kiếm vào tất cả vị trí có class 'search-bar-placeholder'
    const placeholders = document.querySelectorAll(".search-bar-placeholder");
    placeholders.forEach(placeholder => {
        placeholder.innerHTML = searchBarContent;
    });

    // Xử lý xóa nội dung input khi nhấn vào clear-icon
    document.querySelectorAll(".clear-icon").forEach(clearIcon => {
        clearIcon.addEventListener("click", function () {
            this.parentElement.querySelector("input").value = "";
        });
    });

    // Mở popup yêu cầu
    document.querySelectorAll("#requestBtn").forEach(btn => {
        btn.addEventListener("click", () => {
            const popup = document.getElementById("popup");
            if (popup) {
                popup.classList.remove("hidden");
            }
        });
    });

    // Đóng popup
    const popup = document.getElementById("popup");
    if (popup) {
        const closeBtn = popup.querySelector(".close-btn");

        if (closeBtn) {
            closeBtn.addEventListener("click", () => {
                popup.classList.add("hidden");
            });
        }

        // Đóng popup nếu click ra ngoài nội dung
        popup.addEventListener("click", (e) => {
            if (e.target === popup) {
                popup.classList.add("hidden");
            }
        });
    }

});
