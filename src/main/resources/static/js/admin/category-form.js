$(function() {
    $("#boardGroupForm").on("submit", function(event) {
        event.preventDefault();

        $.ajax({
            type: "POST",
            url: "/admin/categories",
            data: $(this).serialize(),

            success: function(result) {
                if (result === "success") {
                    alert("게시판이 생성되었습니다.");
                    location.href = "/admin/categories";
					return;
				}
				
				alert("게시판 생성에 실패했습니다.");
            },

			error: function() {
				alert("서버 통신 중 오류가 발생했습니다.");
			}
        });
    });
});