package ar.edu.unlam.mobile.scaffold.data.interceptor

import ar.edu.unlam.mobile.scaffold.domain.authorization.services.AuthorizationGetter
import ar.edu.unlam.mobile.scaffold.utils.constants.AuthorizationConstants
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class BearerTokenInterceptor(authorizationGetter: AuthorizationGetter) : Interceptor {

    val token = runBlocking {
        authorizationGetter.getAuthorization(
            AuthorizationConstants.CLIENT_CREDENTIALS,
            AuthorizationConstants.CLIENT_ID,
            AuthorizationConstants.CLIENT_SECRET,
        )
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest =
            originalRequest.newBuilder().addHeader("Authorization", "Bearer $token").build()
        return chain.proceed(newRequest)
    }
}
