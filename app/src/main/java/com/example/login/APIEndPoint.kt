package com.example.login

class APIEndPoint {
    companion object {
        val SERVER = "http://192.168.43.54/android/login/"
        val login = SERVER + "login.php"
        val read = SERVER + "read_user.php"
        val update = SERVER + "update.php"
        val delete = SERVER + "delete.php"
        val add = SERVER + "add_user.php"

    }

}