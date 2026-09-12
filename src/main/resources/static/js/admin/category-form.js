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

            error: function() {
                alert("서버 통신 중 오류가 발생했습니다.");
            }
        });
    });
});