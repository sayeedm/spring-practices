$(document).ready(function(){
    var ws = null;
    $('#connect').click(function(){
        connect();
    });

    $('#disconnect').click(function(){
        //disconnect();
    });

    $('#send').click(function () {
       sendName();
    });




    function connect() {
        ws = new WebSocket('ws://localhost:8080/name');
        ws.onopen = function(){
          var joinMessage = {
             user: 'dummy Name',
             status: 'ENTRY'
          };
          ws.send(JSON.stringify(joinMessage));
          setConnected(true);
        };
        ws.onmessage = function(data){
            console.log(data);
            showGreeting(data.data);
        };
        ws.onerror = function(error){
            console.log(error);
        };

        ws.onclose = function(){
            console.log('on close');
            setConnected(false);
        };

    }



    function disconnect() {
        if (ws != null) {
            ws.close();
        }
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        var msg = {
            user: 'dummy Name',
            message: $("#name").val()
        };
        if (ws != null)
            ws.send(JSON.stringify(msg));
        else
            console.log('ws is null');
    }


    function showGreeting(message) {
        console.log(message);
        $("#greetings").append(" " + JSON.stringify(message) + "");
    }


    function setConnected(isConnected){
        if (isConnected)
            $('#status').html("connected");
        else
            $('#status').html("disconnected");
    }



});