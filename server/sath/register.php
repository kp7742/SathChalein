<?php
    include "Users.php";
    
    $uname = "";
    $email = "";
    $pass = "";
    $number = "";
    $someJSON = [
        "msg" => "Fail To Register",
        "statuscode" => "-1"
    ];

    if(isset($_POST['name'])){
        $uname = $_POST['name'];
        if(isset($_POST['email'])){
            $email = $_POST['email'];
            if(isset($_POST['pass'])){
                $pass = $_POST['pass'];
                if(isset($_POST['number'])){
                    $number = $_POST['number'];
                    if(isExist($email) < 1){
                        addUsers($uname, $email, $pass, $number, 0, 0, 0);
                        $someJSON = [
                            "msg" => "Register Successfully",
                            "statuscode" => "0"
                        ];
                    } else {
                        $someJSON = [
                            "msg" => "You Already Registered",
                            "statuscode" => "-1"
                        ];
                    }
                }
            }
        }
    }

    echo json_encode($someJSON);
?>