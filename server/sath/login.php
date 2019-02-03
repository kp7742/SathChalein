<?php
    include "Users.php";
    
    $email = "";
    $pass = "";
    $someJSON = [
        "msg"   => "Fail To Login",
        "statuscode" => "-1"
      ];

      if(isset($_POST['email'])){
        $email = $_POST['email'];
        if(isset($_POST['pass'])){
            $pass = $_POST['pass'];
            if(isExist($email) > 0){
                $user = getUsers($email);
                if($user['Password'] == $pass){
                    $someJSON = [
                        "msg"   => "Login Successfully",
                        "statuscode" => "0"
                      ];
                } else {
                    $someJSON = [
                        "msg"   => "Password Not Matched",
                        "statuscode" => "-1"
                      ];
                }
            } else {
                $someJSON = [
                    "msg"   => "You Are not Registered Yet",
                    "statuscode" => "-1"
                  ];
            }
        }
    }

    echo json_encode($someJSON);
?>