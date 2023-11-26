package com.example.gatewayservice.filter

import com.example.gatewayservice.jwt.JwtTokenProvider
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import reactor.core.publisher.Mono

@Component
class JwtAuthenticationFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config>(Config::class.java){
    class Config

    override fun apply(config: Config): GatewayFilter {
        return GatewayFilter { exchange, chain ->
            val request = exchange.request
            val response = exchange.response

            val authToken: String = resolveToken(request)

            if (jwtTokenProvider.validateToken(authToken)) {
                return@GatewayFilter chain.filter(
                    exchange.mutate()
                        .request(
                            request.mutate()
                                .build()
                        )
                        .build()
                )
            }

            return@GatewayFilter this.responseInvalidAuthToken(response)
        }
    }

    private fun responseInvalidAuthToken(response: ServerHttpResponse): Mono<Void> {
        response.statusCode = HttpStatus.FORBIDDEN
        response.headers.contentType = MediaType.APPLICATION_JSON
        return response.writeWith(
            Mono.just(
                response.bufferFactory().wrap(
                    """{
                        |"success": false,
                        |"message":"Invalid Auth Token"
                    |}""".trimMargin().toByteArray()
                )
            )
        )
    }

    private fun resolveToken(request: ServerHttpRequest): String {
        val bearerToken: String = request.headers.getFirst("Authorization").toString()


        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            bearerToken.substring(7)
        } else {
            ""
        }
    }
}