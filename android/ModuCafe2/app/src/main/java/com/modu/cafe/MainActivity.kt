package com.modu.cafe

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.modu.cafe.retrofit.LoginRequest
import com.modu.cafe.retrofit.LoginResponse
import com.modu.cafe.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val id = data?.getStringExtra("id")
                val token = data?.getStringExtra("token")
                val resultMessage = data?.getStringExtra("response_message")

                if (resultMessage.equals("success")) {
                    Toast.makeText(this, "client id: $id", Toast.LENGTH_LONG).show()

                    if (token != null && id != null) {
                        val loginRequest = LoginRequest(clientId = id, appName = "")

                        fetchLogin(token, loginRequest)
                    }
                } else if (resultMessage.equals("fail")) {
                    Toast.makeText(this, "받은 데이터: $resultMessage", Toast.LENGTH_LONG).show()
                }
            } else {

            }
        }

        button = findViewById(R.id.button)

        button.setOnClickListener {
            openActivityWithExtras(this)
        }
    }

    private fun openActivityWithExtras(context: Context) {
        val openAppKey = "openApp"
        val openAppName = applicationContext.packageName
        val packageName = "com.example.modumessenger"
        val activityName = ".Activity.LoginActivity"

        val intent = Intent().apply {
            component = ComponentName(packageName, packageName + activityName)
            action = Intent.ACTION_VIEW
            // addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra(openAppKey, openAppName)
        }

        try {
            resultLauncher.launch(intent)
        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchLogin(token: String, request: LoginRequest) {
        val call = RetrofitClient.instance.loginModuChat(token, request)

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()

                    val email = loginResponse?.email
                    val username = loginResponse?.username
                } else {
                    println("Request failed with code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                println("Request failed: ${t.message}")
            }
        })
    }
}