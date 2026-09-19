$(function() {
    $("#boardGroupForm").on("submit", function(event) {
        event.preventDefault();

        const boardGroupIdx = $("input[name='boardGroupIdx']").val();
        const isEdit = boardGroupIdx !== "";
        const requestUrl = isEdit
            ? "/admin/categories/" + boardGroupIdx
            : "/admin/categories";

        $.ajax({
            type: "POST",
            url: requestUrl,
            data: $(this).serialize(),

            success: function(result) {
                if (result === "success") {
                    alert(isEdit
                        ? "게시판이 수정되었습니다."
                        : "게시판이 생성되었습니다.");

                    location.href = "/admin/categories";
                    return;
                }

                alert(isEdit
                    ? "게시판 수정에 실패되었습니다."
                    : "게시판 생성에 실패되었습니다.");
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

