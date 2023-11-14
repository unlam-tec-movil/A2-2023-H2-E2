package ar.edu.unlam.mobile.scaffold.data.interceptor

import android.util.Log
import ar.edu.unlam.mobile.scaffold.data.di.authorization.AuthorizationDataProvider
import ar.edu.unlam.mobile.scaffold.data.network.authorization.AuthorizationHTTPRepository
import ar.edu.unlam.mobile.scaffold.data.repository.authorization.AuthorizationDefaultRepository
import ar.edu.unlam.mobile.scaffold.domain.services.authorization.AuthorizationGetter
import ar.edu.unlam.mobile.scaffold.domain.services.authorization.AuthorizationService
import ar.edu.unlam.mobile.scaffold.utils.constants.AuthorizationConstants
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class BearerTokenInterceptor : Interceptor {
    var token: String = ""

    val gson: Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    private var authorizationGetter: AuthorizationGetter = AuthorizationService(
        AuthorizationDefaultRepository(
            AuthorizationHTTPRepository(
                AuthorizationDataProvider().provideAuthorizationAPI(gson),
            ),
        ),
    )

    var syncAuth = runBlocking {
        authorizationGetter.getAuthorization(
            AuthorizationConstants.CLIENT_CREDENTIALS,
            AuthorizationConstants.CLIENT_ID,
            AuthorizationConstants.CLIENT_SECRET,
        ).catch {
            Log.i("ERROR TOKEN", it.message.toString())
        }.collect {
            token = it.accessToken
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest =
            originalRequest.newBuilder().addHeader("Authorization", "Bearer $token")
                .build()
        return chain.proceed(newRequest)
    }
}
