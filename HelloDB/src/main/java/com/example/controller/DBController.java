package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.model.Student;
import com.example.service.DBService;

@Controller
public class DBController {
	@Autowired
	private DBService service;
	
	@GetMapping("/all")
	public ModelAndView allstudent(ModelAndView mav) {
		mav.setViewName("dbResult");
		List<Student> stds = service.getAll();
		if(stds == null) {
			mav.addObject("msg","학생데이터가 존재하지 않습니다.");
		}else {
			ArrayList<Student> list = new ArrayList<Student>();
			for(Student std : stds) {
				list.add(std);
			}
			mav.addObject("msg","전체 학생 검색 결과");
			mav.addObject("list",list);
		}
		
		return mav;
	}
	
	public void insertTest() {
		int cnt=1;
		String stationUrl = "http://openapi.airkorea.or.kr/openapi/services/rest/MsrstnInfoInqireSvc/getMsrstnList?"
		    + "ServiceKey=3iRMYhnC0gpmlbqMVLagOwONCTDJ16M07lqat19aiJHKdPYEniDuT%2FoEVv0im4vK6HtVccA7sc7sz2bNrnfTYQ%3D%3D&numOfRows=600";

		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document xml = documentBuilder.parse(stationUrl);

			Element ele = xml.getDocumentElement();
			NodeList node = ele.getElementsByTagName("item");

			if(node.getLength() ==0) {
				System.out.println("data X@!!!!!!@!@!@!@!@!@!@");
				return;
			}
			for(int i=0; i<node.getLength(); i++){
				Node nodeItem = node.item(i);
	            String stationName = getTagValue("stationName",(Element)nodeItem);
                String dmx = getTagValue("dmX",(Element)nodeItem);
                String dmy = getTagValue("dmY",(Element)nodeItem);
                String addr = getTagValue("addr",(Element)nodeItem);
               
                if(addr.startsWith("전남")||addr.startsWith("광주")) {
	               System.out.println(stationName);
	               System.out.println(dmx);
	               System.out.println(dmy);
	               System.out.println(addr + "\n");
	               System.out.println(cnt++ + "\n");
	               service.insertDB(stationName, addr, dmx, dmy);
                }
			}
		}catch (Exception e) {

		}
		}


	public static String getTagValue(String sTag, Element element) {
		try{
		  String result = element.getElementsByTagName(sTag).item(0).getTextContent();
		  return result;
		} catch(NullPointerException e){
		      return "";
		} catch(Exception e){
		      return "";
		}
	}
		
	
}
