package azadev.backt.webserver.http

import azadev.backt.webserver.logging.ILogging
import azadev.backt.webserver.logging.LogLevel
import azadev.backt.webserver.routing.RouteParams
import io.netty.handler.codec.http.HttpMethod
import io.netty.handler.codec.http.cookie.Cookie


data class CallReferences(
		val request: Request,
		val response: Response,
		val routeParams: RouteParams
) : ILogging // Temporary inheritance
{
	override val logger = null
	override val logLevel = LogLevel.VERBOSE


	val method: HttpMethod get() = request.method
	val isGET: Boolean get() = method == HttpMethod.GET
	val isPOST: Boolean get() = method == HttpMethod.POST

//	val queryParams: Map<String, String> get() = request.queryParams
	val bodyValues: Map<String, Any> get() = request.bodyValues

	val cookies: Map<String, Cookie>
		get() = request.cookies
}
