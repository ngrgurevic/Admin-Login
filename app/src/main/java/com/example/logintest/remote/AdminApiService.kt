import com.example.logintest.model.Admin
import com.example.logintest.model.AdminData
import com.example.logintest.model.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface AdminApiService {

    @POST("/api/User/AdminLogin")
    suspend fun loginAdmin(@Body adminData: AdminData): Response<Admin>

    @GET("/api/User/User")
    suspend fun getUserData(@Header("Authorization") token: String): Response<User>

    companion object {
        private const val baseUrl = "https://account.zadar.mediaapp.eu"
        val client: AdminApiService = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AdminApiService::class.java)
    }
}
