listNoteType();
listNote();
formAddNote();

function addNoteType() {
    var formdata = new FormData();
    formdata.append("name", document.getElementById("title").value);

    var NO_CONTENT = "";
    $.ajax({
        type: 'post',
        url: '/noteType',
        processData: false,
        contentType: false,
        data: formdata,
        success: function (response) {
            alert("Thêm mới thành công!!!");
            document.getElementById("title").value = NO_CONTENT;
            listNoteType();
            formAddNote();
        }
    })
};


function listNoteType() {
    $.ajax({
        type: 'get',
        url: '/noteType',
        data: {},
        success: function (response) {
            document.getElementById("listNoteType").innerHTML = response;
        }
    })
}

function removeNoteType(id) {
    $.ajax({
        type: 'DELETE',
        url: '/noteType/' + id,
        data: {},
        error: function () {
            alert("Xoá không thành công. Vui lòng kiểm tra lại");
        },
        success: function () {
            alert("Xoá chủ đề thành công");
            listNoteType();
            formAddNote();
        }
    })
};

function updateNoteType(id) {
    var formdata = new FormData();
    formdata.append("id", id);
    formdata.append("name", document.getElementById("titleUpdate" + id).value);

    $.ajax({
        type: 'PUT',
        url: '/noteType/' + id,
        processData: false,
        contentType: false,
        data: formdata,
        success: function () {
            alert("Cập nhật thành công!!!");
            listNoteType();
            formAddNote();
        }
    })
}

function listNote() {
    $.ajax({
        type: 'get',
        url: '/note',
        data: {},
        success: function (response) {
            document.getElementById("listNote").innerHTML = response;
        }
    })
};

function formAddNote() {
    $.ajax({
        type: 'get',
        url: '/note/formAddNote',
        data: {},
        success: function (response) {
            document.getElementById("formAddNote").innerHTML = response;
        }
    })
}

function addNote() {
    var formdata = new FormData();
    var title = document.getElementById("title_note").value;
    var content = document.getElementById("content_note").value;
    var noteType = document.getElementById("note_type").value;
    formdata.append("title", title);
    formdata.append("content", content);
    formdata.append("noteType", noteType);

    var NO_CONTENT = "";

    if (noteType == '') {
        alert("Vui lòng chọn chủ đề . Nếu không có vui lòng tạo mới chủ đề");
    } else {
        $.ajax({
            type: 'post',
            url: '/note',
            processData: false,
            contentType: false,
            data: formdata,
            success: function (response) {
                alert("Thêm ghi chú thành công!!!");
                document.getElementById("title_note").value = NO_CONTENT;
                document.getElementById("content_note").value = NO_CONTENT;
                listNote();
            }
        })
    }
};

function formUpdateNote(id) {
    $.ajax({
        type: 'get',
        url: '/note/' + id,
        data: {},
        success: function (response) {
            document.getElementById("form_Update" + id).innerHTML = response;
            document.getElementById("buttonUpdate" + id).style.display = 'none';
        }
    })
}

function updateNote(id) {
    var formdata = new FormData();
    formdata.append("id", id);
    formdata.append("title", document.getElementById("title_note_update").value);
    formdata.append("content", document.getElementById("content_note_update").value);
    formdata.append("noteType", document.getElementById("note_type_update").value);

    $.ajax({
        type: 'PUT',
        url: '/note/' + id,
        processData: false,
        contentType: false,
        data: formdata,
        success: function () {
            alert("Cập nhật thành công!!!");
            listNote();
        }
    })
}

function removeNote(id) {
    $.ajax({
        type: 'DELETE',
        url: '/note/' + id,
        data: {},
        success: function () {
            alert("Xoá ghi chú thành công");
            listNote();
        }
    })
};

function listByNoteType(id) {
    $.ajax({
        type: 'get',
        url: '/note?noteType_id=' + id,
        data: {},
        success: function (response) {
            document.getElementById("listNote").innerHTML = response;
        }
    })
}

function searchByTitle() {
    var search = document.getElementById("searchText").value;
    if (search == "") {
        listNote();
    } else {
        $.ajax({
            type: 'get',
            url: '/note?search=' + search,
            data: {},
            success: function (response) {
                document.getElementById("listNote").innerHTML = response;
            }
        })
    }
}
