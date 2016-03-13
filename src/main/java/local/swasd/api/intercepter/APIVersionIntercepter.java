package local.swasd.api.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import local.swasd.api.configuration.SwasdConfiguration;

public class APIVersionIntercepter implements HandlerInterceptor {

	@Autowired
	SwasdConfiguration swasdConfiguration;

	private static final Logger logger = LoggerFactory.getLogger(APIVersionIntercepter.class);

	private static final String HEADER_API_VERSION = "X-Api-Version";

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {

		String clientVersion = httpServletRequest.getHeader(HEADER_API_VERSION);
		String serverVersion = swasdConfiguration.getApiVersion();
		httpServletResponse.setHeader(HEADER_API_VERSION, serverVersion);

		if (swasdConfiguration.isApiNoVersionCheck()) {
			return true;
		}
		if (clientVersion.equals(serverVersion)) {
			return true;
		}

		// or throw Exception?
		logger.info(" old client access: " + clientVersion);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
	}
}