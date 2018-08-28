/*<![CDATA[*/

var user = {

    url: {
        lists: function () {
            return 'user/list/';
        },
        finds: function (name) {
            return 'user/find/' + name;
        },
        insert: function (name, age) {
            return 'user/insert/' + name + '/' + age;
        },
        update: function (id, name, age) {
            return 'user/update/' + id + +'/' + name + '/' + age;
        },
        removes: function (id) {
            return 'user/remove/' + id;
        }
    }/*,
    handleruser: function (id) {
        $.get(user.url.resolve(id), {}, function (result) {
            if (result && result['success']) {
                let resolve = result['data'];
                if (resolve['done']) {
                    let exec = user.url.execution(id);
                    console.log("showurl: " + showurl);

                }
            } else {
                console.log('result: ' + result);
            }
        });

    },*/
};

$('#refreshBtn').click(function () {
    window.location.reload();
});
$('#insertBtn').click(function () {
    var name = $('#insertName').val();
    var age = $('#insertAge').val();
    var url = user.url.insert(name, age);
    $.get(url, function (data) {
        if (data !== 0) {
            alert('success inserted');
        }
        else alert('insert failed');
    })
});

$('#updateBtn').click(function () {
    var id = $('#updateId').val();
    var name = $('#updateName').val();
    var age = $('#updateAge').val();
    var url = user.url.update(id, name, age);
    $.get(url, function (data) {
        if (data !== 0) {
            alert('success updated');
        }
        else alert('update failed');
    })
});
$('#findBtn').click(function () {
    var name = $('#findName').val();
    var url = user.url.finds(name);
    $.get(url, function (data) {
        if (data !== null) {
            $('#myModal').modal('show');
            $('#showMsg').append(data);
        }
        else alert('no such user');
    })
});
$('#deleteBtn').click(function () {
    var id = $('#deleteId').val();
    var url = user.url.removes(id);
    $.get(url, function (data) {
        if (data !== 0) {
            alert('delete success');
        }
        else alert('delete failed');
    })
});


/*]]>*/