/*<![CDATA[*/

/*let user = {

    url: {
        lists: function () {
            return '/user/list';
        },
        finds: function (name) {
            return '/user/find/' + name;
        },
        insert: function (name, age) {
            return '/user/insert/' + name + '/' + age;
        },
        modify: function (id, name, age) {
            return '/user/modify/' + id + +'/' + name + '/' + age;
        },
        removes: function (id) {
            return '/user/remove/' + id;
        }
    },
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

    },


};*/

$('#refreshBtn').click(function () {
    window.location.reload();


});
$('#insertBtn').click(function () {
/*    let showmsg = $('#showmsg');
    showmsg.html('<span class="label label-success">' + 'lists' + '</span>');
    $.post(showurl, {}, function (result) {
        console.log(result);
        if (result && result['success']) {
            let showResult = result['data'];
            let state = showResult['state'];
            let stateInfo = showResult['stateInfo'];
            node.html('<span class="label label-success">' + stateInfo + '</span>');
        }
    });*/

});

$('#updateBtn').click(function () {

});
$('#findBtn').click(function () {

});
$('#deleteBtn').click(function () {

});


/*]]>*/