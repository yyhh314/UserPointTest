window.onload = function(){
    const btn_create = document.getElementById("btn-create");
    const btn_get = document.getElementById("btn-get");
    if(btn_get){
        btn_get.addEventListener("click", function() {
            var url = "/create_userName"
            fetch(url).then(response => {
                alert("nickname generated!");
                alert(response.json);
                document.getElementById("input-nickname") = response.json.nickname;
            });

        })
    }


    if(btn_create){
        btn_create.addEventListener("click", function () {
                var nickname = document.querySelector("#input-nickname").value;
                var x = document.querySelector("#input-x").value;
                var y = document.querySelector("#input-y").value;

                if ( x != '' && y != '' && nickname != ''){
                    var userPoint = {
                        nickname: nickname,
                        point : {
                            x: x,
                            y: y
                        }
                    };
                    var url = "/users/save"
                    fetch(url, {
                        method: "post",
                        body: JSON.stringify(userPoint),
                        headers: {
                            "Content-Type": "application/json"
                        }
                    }).then(response => {
                        alert("created");
                        window.location.reload();
                    });
                }
        });
    }
}