$(function() {
    $(".delete-board-group").on("click", function() {
        const boardGroupIdx = $(this).attr("data-board-group-idx");

        if (!confirm("이 게시판을 삭제하시겠습니까?")) {
            return;
        }

        $.ajax({
            type: "POST",
            url: "/admin/categories/" + boardGroupIdx + "/delete",
            success: function(result) {
                if (result === "success") {
                    alert("게시판이 삭제되었습니다.")
                    location.reload();
                    return;
                }

                alert("게시판을 삭제할 수 없습니다. 게시글이 있는지 확인해주세요.")
            },
            error: function(xhr) {
                if (xhr.status === 404) {
                    alert("게시판을 찾을 수 없습니다. 목록을 다시 확인해주세요.");
                    location.href = "/admin/categories";
                    return;
                }
				
				if (xhr.status === 400) {
					alert(xhr.responseText);
					return;
				}
				
                alert("서버 통신 중 오류가 발생했습니다.");
            }
        });
    });
});