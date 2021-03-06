package com.mycompany.myapp.corona.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;

@Controller
public class CoronaDataApi {
	@RequestMapping("/getCoronaData")
	@ResponseBody
	public Map<String, Object> getCoronaData(HttpServletRequest req , Model model) throws IOException, ParseException {
		  System.out.println("getCoronaData List ! ");
		  String defaultPageNum = req.getParameter("defaultPageNum");
		  System.out.println("defaultPageNum =====> " + defaultPageNum);
		  String page = defaultPageNum; // 현재 page number 
		  BufferedReader br = null;
		  //get Corona Data List 
		  //perPage : 한페이지당 보여질 데이터의 갯수
		  //page : 페이지 
		  String urlstr = "https://api.odcloud.kr/api/15077603/v1/uddi:90bfb316-0caf-495b-92c0-c5cbc7bca1d9?page="+page+"&perPage=5&serviceKey=pIjdyg6yRnPqmwfTfG4m3TIDh518lq4lqoOgjavC5e1QPr3Vut5Dri2mQXpGfX5CbeusLqm9VNvju4fmvIkv0g%3D%3D";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8")); 
			String result = "";
			String line;
			while((line = br.readLine()) != null) { 
				result = result + line;
			}
			
			JSONParser parser = new JSONParser();
			Object object = parser.parse(result.toString()); 
			JSONObject json = (JSONObject) object;
			System.out.println(json);
		return getMapFromJsonObject(json);
		
	}

	public Map<String , Object > getMapFromJsonObject(JSONObject jsonObj){
		Map<String , Object >map = null;
		try {
			map = new ObjectMapper().readValue(jsonObj.toJSONString(),Map.class);
			System.out.println("map data ===> " + map );
			
		}catch(JsonParseException e) {
			
		}catch(JsonMappingException e) {
			
		}catch(IOException e) {
			
		}
		return map;
		
	}
}
