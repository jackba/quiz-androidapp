package com.nvn.quizapp.utils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class NetworkUtils {
	public static final int TIME_OUT = 30000;
	public static final int SOCKET_TIME_OUT = 30000;

	public static String doRequest(String url) throws ClientProtocolException,
			IOException {
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
		HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIME_OUT);
		HttpClient client = new DefaultHttpClient(httpParameters);
		HttpGet method = new HttpGet(url);
		HttpResponse response = client.execute(method);
		// result= response.getEntity().getContent();
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		return result;
	}

	public static String doPostRequest(String url, Map<String, String> params)
			throws ClientProtocolException, IOException {
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
		HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIME_OUT);
		HttpClient client = new DefaultHttpClient(httpParameters);

		List<NameValuePair> parameters = new LinkedList<NameValuePair>();
		for (String key : params.keySet()) {
			parameters.add(new BasicNameValuePair(key, params.get(key)));
		}

		HttpPost method = new HttpPost(url);
		method.setParams(httpParameters);
		method.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));

		HttpResponse response = client.execute(method);
		// result= response.getEntity().getContent();
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		return result;
	}

	public static String doRequest(String url, Map<String, String> headers)
			throws ClientProtocolException, IOException {
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
		HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIME_OUT);
		HttpClient client = new DefaultHttpClient(httpParameters);
		HttpGet method = new HttpGet(url);

		// put Headers
		if (headers != null) {
			Header[] methodHeaders = new Header[headers.size()];
			int i = 0;

			for (String key : headers.keySet()) {
				methodHeaders[i] = new BasicHeader(key, headers.get(key));
				i++;
			}
			method.setHeaders(methodHeaders);
		}

		HttpResponse response = client.execute(method);
		// result= response.getEntity().getContent();
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		return result;
	}

	public static String doPostRequest(String url, Map<String, String> params,
			Map<String, String> headers) throws ClientProtocolException,
			IOException {
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
		HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIME_OUT);
		HttpClient client = new DefaultHttpClient(httpParameters);

		List<NameValuePair> parameters = new LinkedList<NameValuePair>();
		for (String key : params.keySet()) {
			parameters.add(new BasicNameValuePair(key, params.get(key)));
		}

		HttpPost method = new HttpPost(url);
		method.setParams(httpParameters);

		// put Headers
		if (headers != null) {
			Header[] methodHeaders = new Header[headers.size()];
			int i = 0;

			for (String key : headers.keySet()) {
				methodHeaders[i] = new BasicHeader(key, headers.get(key));
				i++;
			}
			method.setHeaders(methodHeaders);
		}

		method.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));

		HttpResponse response = client.execute(method);
		// result= response.getEntity().getContent();
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		return result;
	}

	public static String doPostRequest(String url, String data,
			Map<String, String> headers) throws ClientProtocolException,
			IOException {
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
		HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIME_OUT);
		HttpClient client = new DefaultHttpClient(httpParameters);

		HttpPost method = new HttpPost(url);
		method.setParams(httpParameters);

		// put Headers
		if (headers != null) {
			Header[] methodHeaders = new Header[headers.size()];
			int i = 0;

			for (String key : headers.keySet()) {
				methodHeaders[i] = new BasicHeader(key, headers.get(key));
				i++;
			}
			method.setHeaders(methodHeaders);
		}

		method.setEntity(new ByteArrayEntity(data.getBytes()));

		HttpResponse response = client.execute(method);
		// result= response.getEntity().getContent();
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		return result;
	}

	public static String doPutRequest(String url, Map<String, String> params,
			Map<String, String> headers) throws ClientProtocolException,
			IOException {
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
		HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIME_OUT);
		HttpClient client = new DefaultHttpClient(httpParameters);

		List<NameValuePair> parameters = new LinkedList<NameValuePair>();
		for (String key : params.keySet()) {
			parameters.add(new BasicNameValuePair(key, params.get(key)));
		}

		HttpPut method = new HttpPut(url);
		method.setParams(httpParameters);

		// put Headers
		if (headers != null) {
			Header[] methodHeaders = new Header[headers.size()];
			int i = 0;

			for (String key : headers.keySet()) {
				methodHeaders[i] = new BasicHeader(key, headers.get(key));
				i++;
			}
			method.setHeaders(methodHeaders);
		}

		method.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));

		HttpResponse response = client.execute(method);
		// result= response.getEntity().getContent();
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		return result;
	}

	public static String doDeleteRequest(String url,
			Map<String, String> params, Map<String, String> headers)
			throws ClientProtocolException, IOException {
		HttpParams httpParameters = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
		HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIME_OUT);
		HttpClient client = new DefaultHttpClient(httpParameters);

		HttpPost method = new HttpPost(url) {
			@Override
			public String getMethod() {
				return "DELETE";
			}
		};

		if (headers != null) {
			for (String key : headers.keySet()) {
				method.addHeader(key, headers.get(key));
			}
		}

		List<NameValuePair> parameters = new LinkedList<NameValuePair>();
		for (String key : params.keySet()) {
			parameters.add(new BasicNameValuePair(key, params.get(key)));
		}

		method.setParams(httpParameters);

		method.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));

		HttpResponse response = client.execute(method);
		// result= response.getEntity().getContent();
		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		return result;
	}
}
